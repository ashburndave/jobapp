package com.acme

import grails.test.mixin.*
import org.junit.*
import grails.test.GrailsUnitTestCase
import com.acme.Job

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

@TestFor(JobService)
//@TestMixin(DomainClassUnitTestMixin)
class JobServiceTests {  // extends GrailsUnitTestCase

  //def jobService

  void testProcessBufferBasic() {
    // Mock the domain class.
    //    def testInstances = []
    //    mockDomain(Job, testInstances)
    def jobService = new JobService()
    def buffer = """value1\tvalue2\tvalue3\tvalue4\tvalue5\tvalue6\tvalue7\tvalue8\tvalue9\tvalue10\tvalue11\tvalue12\tvalue13\tvalue14\tvalue15\tvalue16\tvalue17\tvalue18\tvalue19\tvalue20\tvalue21\tvalue22\tvalue23"""
    def job = jobService.processBuffer(buffer)
    assert (job)
    assert ("value1" == job.csrRefNo)
    assert ("value2" == job.laborCat)
    assert ("value3" == job.fullTimeOrPartTime)
    assert ("value4" == job.requiredClearanceType)
    assert ("value5" == job.workLocation)
    assert ("value6" == job.workDescription)
    assert ("value7" == job.otherRequiredQualifications)
    assert ("value8" == job.optionalQualifications)
    assert ("value9" == job.certificationRequirements)
    assert ("value10" == job.conusTravel)
    assert ("value11" == job.oconusTravel)
    assert ("value12" == job.hoursPerYear)
    assert ("value13" == job.scheduleComments)
    assert ("value14" == job.missionCritical)
    assert ("value15" == job.nightWork)
    assert ("value16" == job.pov)
    assert ("value17" == job.pagerDuty)
    assert ("value18" == job.pagerDutyComments)
    assert ("value19" == job.holidayWork)
    assert ("value20" == job.weekendWork)
    assert ("value21" == job.shiftWork)
    assert ("value22" == job.warzoneTravel)
    assert ("value23" == job.coopRequirements)
  }

  void testProcessBufferExtraTabs() {
    // Mock the domain class.
    //    def testInstances = []
    //    mockDomain(Job, testInstances)
    def jobService = new JobService()
    def buffer = """value1\tvalue2\tvalue3\tvalue4\t"value5a\tvalue5b\tvalue5c"\tvalue6\tvalue7\tvalue8\tvalue9\tvalue10\tvalue11\tvalue12\tvalue13\tvalue14\tvalue15\tvalue16\tvalue17\tvalue18\tvalue19\tvalue20\tvalue21\tvalue22\tvalue23"""
    def job = jobService.processBuffer(buffer)
    //    println ">>${job.workLocation}<<"
    //    log ">>${job.workLocation}<<"
    assert (job)
    assert ("value1" == job.csrRefNo)
    assert ("value2" == job.laborCat)
    assert ("value3" == job.fullTimeOrPartTime)
    assert ("value4" == job.requiredClearanceType)
    // assert ("value5" == job.workLocation)
    // assert ("value5a value5b value5c" == job.workLocation)
    // assert ("value5a\tvalue5b\tvalue5c" == job.workLocation)
     // assert ("\"value5a value5b value5c\"" == job.workLocation)
    assert (""" "value5a value5b value5c" """.trim() == job.workLocation)
    assert ("value6" == job.workDescription)
    assert ("value7" == job.otherRequiredQualifications)
    assert ("value8" == job.optionalQualifications)
    assert ("value9" == job.certificationRequirements)
    assert ("value10" == job.conusTravel)
    assert ("value11" == job.oconusTravel)
    assert ("value12" == job.hoursPerYear)
    assert ("value13" == job.scheduleComments)
    assert ("value14" == job.missionCritical)
    assert ("value15" == job.nightWork)
    assert ("value16" == job.pov)
    assert ("value17" == job.pagerDuty)
    assert ("value18" == job.pagerDutyComments)
    assert ("value19" == job.holidayWork)
    assert ("value20" == job.weekendWork)
    assert ("value21" == job.shiftWork)
    assert ("value22" == job.warzoneTravel)
    assert ("value23" == job.coopRequirements)
    fail "Implement me"
  }

  /**
   * This is not a valid test - the code that creates the buffer would have removed all the newlines
   */
  void testProcessBufferMultiLine() {
    // Mock the domain class.
    //    def testInstances = []
    //    mockDomain(Job, testInstances)
    def jobService = new JobService()
    def buffer = """value1\t
value2\t
value3\t
value4\t
value5\t
value6\t
value7\t
value8\t
value9\t
value10\t
value11\t
value12\t
value13\t
value14\t
value15\t
value16\t
value17\t
value18\t
value19\t
value20\t
value21\t
value22\t
value23\t"""
    def job = jobService.processBuffer(buffer)
    assert (job)
    assert ("value1" == job.csrRefNo)
    assert ("value2" == job.laborCat)
    assert ("value3" == job.fullTimeOrPartTime)
    assert ("value4" == job.requiredClearanceType)
    assert ("value5" == job.workLocation)
    assert ("value6" == job.workDescription)
    assert ("value7" == job.otherRequiredQualifications)
    assert ("value8" == job.optionalQualifications)
    assert ("value9" == job.certificationRequirements)
    assert ("value10" == job.conusTravel)
    assert ("value11" == job.oconusTravel)
    assert ("value12" == job.hoursPerYear)
    assert ("value13" == job.scheduleComments)
    assert ("value14" == job.missionCritical)
    assert ("value15" == job.nightWork)
    assert ("value16" == job.pov)
    assert ("value17" == job.pagerDuty)
    assert ("value18" == job.pagerDutyComments)
    assert ("value19" == job.holidayWork)
    assert ("value20" == job.weekendWork)
    assert ("value21" == job.shiftWork)
    assert ("value22" == job.warzoneTravel)
    assert ("value23" == job.coopRequirements)
    fail "Implement me"
  }

}
