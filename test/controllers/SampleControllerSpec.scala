package controllers

import play.api.http.Status
import play.api.test.FakeRequest
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class SampleControllerSpec extends UnitSpec with WithFakeApplication {

  val fakeRequest = FakeRequest("GET", "/")

  "GET /" should {
    "return 200" in {
      val controller = new SampleController()
      val result = controller.index()(fakeRequest)
      status(result) shouldBe Status.OK
    }
  }

}
