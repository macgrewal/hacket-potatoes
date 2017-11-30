/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package connectors

import javax.inject.{Inject, Singleton}

import models.{Error, Person}
import play.api.Logger
import play.api.http.Status
import play.api.http.Status._
import uk.gov.hmrc.http.{HeaderCarrier, HttpResponse}
import uk.gov.hmrc.play.bootstrap.http.HttpClient
import uk.gov.hmrc.play.http.logging.MdcLoggingExecutionContext._

import scala.concurrent.Future

@Singleton
class UserDetailsConnector @Inject()(val http: HttpClient) {

  val url: String = "/test/url"

  def getUrl()(implicit hc: HeaderCarrier): Future[Either[Error, Person]] = {
    http.GET[HttpResponse](url) map {
      response =>
        response.status match {
          case OK =>
            response.json.validate[Person].fold(
              invalid => {
                Left(Error(response.status, response.body))
              },
              valid => Right(valid)
            )
          case _ =>
            Left(Error(response.status, response.body))
        }
    } recover {
      case _ =>
        Left(Error(Status.INTERNAL_SERVER_ERROR, "Failed Future"))
    }
  }
}
