// code-examples/DSLs/payroll/pcdsl/payroll-parser-comb-v1-spec.scala

package payroll.pcdsl
import scala.util.parsing.combinator._
import org.scalatest.{ FunSpec, ShouldMatchers } 
 
import payroll._
import payroll.Type2Money._

class PayrollParserCombinatorsV1Spec extends FunSpec with ShouldMatchers("PayrollParserCombinatorsV1") { 
    
  describe "PayrollParserCombinatorsV1" {
    it "parse rules when there are no deductions" {
      val input = """paycheck for employee "Buck Trends"
                     is salary for 2 weeks minus deductions for {}"""
      val p = new PayrollParserCombinatorsV1
      p.parseAll(p.paycheck, input) match {
        case p.Success(r,_) => r.toString mustEqual
                    """(("Buck Trends"~(2~weeks))~List())"""
        case x => fail(x.toString)
      }
    }

    it "calculate the gross, net, and deductions for the pay period" {
      val input = 
          """paycheck for employee "Buck Trends" 
             is salary for 2 weeks minus deductions for {
               federal income tax            is  25.  percent of gross,
               state income tax              is  5.   percent of gross,
               insurance premiums            are 500. in gross currency,
               retirement fund contributions are 10.  percent of gross
             }"""
      val p = new PayrollParserCombinatorsV1
      p.parseAll(p.paycheck, input) match {
        case p.Success(r,_) => r.toString mustEqual 
            """(("Buck Trends"~(2~weeks))~List(25., 5., 500., 10.))"""
        case x => fail(x.toString)
      }
    }
  }
}
