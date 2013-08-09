package com.acme

import org.springframework.dao.DataIntegrityViolationException


class JobQueryController {

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index() {
    redirect(action: "list", params: params)
  }

  /**
   * should derive the "Picklist" lists below by examining the database contents
   * bind the lists to the application context (and not the session)
   * this data is extremely static, so once lists are built, no real need to refresh them
   * @return
   */
  def buildPicklists() {
    //    session.sourcePicklist = null  // during development, force the list to be rebuilt
    //    session.workLocPicklist = null  // during development, force the list to be rebuilt
    //    session.laborCatPicklist = null  // during development, force the list to be rebuilt
    //    session.perfLevelPicklist = null    // during development, force the list to be rebuilt

    //    if (!session.sourcePicklist) {
    //      session.sourcePicklist = ["draftfile1","draftfile2","draftfile3","finalfile1","finalfile2"]
    //    }
    //    if (!session.workLocPicklist) {
    //      session.workLocPicklist = ["Herndon","Tyson's","Reston","Chantilly","McLean"]
    //    }
    //    if (!session.laborCatPicklist) {
    //      session.laborCatPicklist = ["Project Integrator","Tools Developer","Requirements Specialist","Applications Developer",
    //        "Customer Services and Information Technology Officer","Database Administrator","Web Developer","UNIX Administrator",
    //        "Software Quality Assurance Specialist/Applications Tester","Help Desk/Support Specialist","Software Developer (Systems Software)"]
    //    }
    //    if (!session.perfLevelPicklist) {
    //      session.perfLevelPicklist = ["Developmental","Expert","Full Performance","Senior","Subject Matter Expert"]
    //    }

    if (!session.sourcePicklist) {
      println "creating sourcePicklist"
      def c = Job.createCriteria()
      def picklist = c.list() {
        projections {
          distinct "source"
        }
      }
      session.sourcePicklist = picklist.sort()
      println session.sourcePicklist
    }
    if (!session.workLocPicklist) {
      println "creating workLocPicklist"
      def c = Job.createCriteria()
      def picklist = c.list() {
        projections {
          distinct "workLocation"
        }
      }
      session.workLocPicklist = picklist.sort()
      println session.workLocPicklist
    }
    if (!session.laborCatPicklist) {
      println "creating laborCatPicklist"
      def c = Job.createCriteria()
      def picklist = c.list() {
        projections {
          distinct "laborCat"
        }
      }
      session.laborCatPicklist = picklist.sort()
      println session.laborCatPicklist
    }
    if (!session.perfLevelPicklist) {
      println "creating perfLevelPicklist"
      def c = Job.createCriteria()
      def picklist = c.list() {
        projections {
          distinct "performanceLevel"
        }
      }
      session.perfLevelPicklist = picklist.sort()
      println session.perfLevelPicklist
    }
  }

  def list(Integer max) {
    params.each{key, value ->
      println "$key  $value"
    }
    buildPicklists()
    params.max = Math.min(max ?: 10, 100)
    def jobInstanceList = []
    def jobInstanceTotal = jobInstanceList.size()
    if (params.querySource || params.queryLaborCat || params.queryPerfLev || params.queryWorkLoc) {
      def c = Job.createCriteria()
      jobInstanceList = c.list([max: params.max, offset: params.offset]) {
        if (params.querySource) eq("source", params.querySource)
        if (params.queryLaborCat) eq("laborCat", params.queryLaborCat)
        if (params.queryPerfLev) eq("performanceLevel", params.queryPerfLev)
        if (params.queryWorkLoc) eq("workLocation", params.queryWorkLoc)
        if (params.sort && params.order) order(params.sort, params.order)
        if (params.sort && !params.order) order(params.sort, "desc")
        order("csrRefNo","asc")
      }
      jobInstanceTotal = jobInstanceList.getTotalCount()
    } else {
      jobInstanceList = Job.list(params)
      jobInstanceTotal = Job.count()
    }
    println jobInstanceList
    [jobInstanceList: jobInstanceList, jobInstanceTotal: jobInstanceTotal, params: params]
  }

  def create() {
    [jobInstance: new Job(params)]
  }

  def save() {
    def jobInstance = new Job(params)
    if (!jobInstance.save(flush: true)) {
      render(view: "create", model: [jobInstance: jobInstance])
      return
    }

    flash.message = message(code: 'default.created.message', args: [message(code: 'job.label', default: 'Job'), jobInstance.id])
    redirect(action: "show", id: jobInstance.id)
  }

  def show(Long id) {
    def jobInstance = Job.get(id)
    if (!jobInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), id])
      redirect(action: "list")
      return
    }

    [jobInstance: jobInstance]
  }

  def edit(Long id) {
    def jobInstance = Job.get(id)
    if (!jobInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), id])
      redirect(action: "list")
      return
    }

    [jobInstance: jobInstance]
  }

  def update(Long id, Long version) {
    def jobInstance = Job.get(id)
    if (!jobInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), id])
      redirect(action: "list")
      return
    }

    if (version != null) {
      if (jobInstance.version > version) {
        jobInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
            [message(code: 'job.label', default: 'Job')] as Object[],
            "Another user has updated this Job while you were editing")
        render(view: "edit", model: [jobInstance: jobInstance])
        return
      }
    }

    jobInstance.properties = params

    if (!jobInstance.save(flush: true)) {
      render(view: "edit", model: [jobInstance: jobInstance])
      return
    }

    flash.message = message(code: 'default.updated.message', args: [message(code: 'job.label', default: 'Job'), jobInstance.id])
    redirect(action: "show", id: jobInstance.id)
  }

  def delete(Long id) {
    def jobInstance = Job.get(id)
    if (!jobInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), id])
      redirect(action: "list")
      return
    }

    try {
      jobInstance.delete(flush: true)
      flash.message = message(code: 'default.deleted.message', args: [message(code: 'job.label', default: 'Job'), id])
      redirect(action: "list")
    }
    catch (DataIntegrityViolationException e) {
      flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'job.label', default: 'Job'), id])
      redirect(action: "show", id: id)
    }
  }
}
