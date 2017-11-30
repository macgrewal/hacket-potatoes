
package connectors

import javax.inject.{Inject, Singleton}

import uk.gov.hmrc.http.HttpResponse
import uk.gov.hmrc.play.bootstrap.http.HttpClient

import scala.concurrent.Future

@Singleton
class SampleConnector @Inject()(http: HttpClient) {

  def getSample: Future[HttpResponse] = http.GET("/some/other/service")

}
