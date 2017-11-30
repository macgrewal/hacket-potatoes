
package connectors

import javax.inject.{Inject, Singleton}

import uk.gov.hmrc.http.{HeaderCarrier, HttpResponse}
import uk.gov.hmrc.play.bootstrap.http.HttpClient

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class SampleConnector @Inject()(http: HttpClient) {

  def getSample()(implicit hc: HeaderCarrier, ec: ExecutionContext): Future[HttpResponse] = http.GET("/some/other/service")

}