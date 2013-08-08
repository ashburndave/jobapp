package com.acme

import org.springframework.dao.DataIntegrityViolationException


class JobQueryController {

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index() {
    redirect(action: "list", params: params)
  }

  def list(Integer max) {
    params.each{key, value ->
      println "$key  $value"
    }
    session.sourcePicklist = ["draftfile1","draftfile2","draftfile3","finalfile1","finalfile2"] // should derive from database
    params.max = Math.min(max ?: 10, 100)
    def jobInstanceList = []
    def jobInstanceTotal = jobInstanceList.size()
    if (params.querySource) {
      def c = Job.createCriteria()
      jobInstanceList = c.list([max: params.max, offset: params.offset]) {
        eq("source", params.querySource)
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
