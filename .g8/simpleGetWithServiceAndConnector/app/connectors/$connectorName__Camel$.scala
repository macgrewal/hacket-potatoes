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

import models.{ErrorModel, $modelName;format="Camel"$}
import play.api.Logger
import play.api.http.Status
import play.api.http.Status._
import uk.gov.hmrc.http.{HeaderCarrier, HttpResponse}
import uk.gov.hmrc.play.bootstrap.http.HttpClient
import uk.gov.hmrc.play.http.logging.MdcLoggingExecutionContext._

import scala.concurrent.Future

@Singleton
class $connectorName;format="Camel"$Connector @Inject()(val http: HttpClient) {

  val url: String = s"sampleUrl"

  def getUrl()(implicit hc: HeaderCarrier): Future[Either[ErrorModel, $modelName;format="Camel"$]] = {
    Logger.debug(s"[$connectorName;format="Camel"$Connector][getMethod] - Calling GET $url \n\nHeaders: $hc")
    http.GET[HttpResponse](url) map {
      response =>
        response.status match {
          case OK =>
            Logger.debug(s"[$connectorName;format="Camel"$Connector][getMethod] - RESPONSE status: ${response.status}, body: ${response.body}")
            response.json.validate[$modelName;format="Camel"$].fold(
              invalid => {
                Logger.warn(s"[$connectorName;format="Camel"$Connector][getMethod] - Json ValidationError. $invalid")
                Left(ErrorModel(response.status, response.body))
              },
              valid => Right(valid)
            )
          case _ =>
            Logger.debug(s"[$connectorName;format="Camel"$Connector][getMethod] - RESPONSE status: ${response.status}, body: ${response.body}")
            Logger.warn(s"[$connectorName;format="Camel"$Connector][getMethod] - Response status: [${response.status}]")
            Left(ErrorModel(response.status, response.body))
        }
    } recover {
      case _ =>
        Logger.warn(s"[$connectorName;format="Camel"$Connector][getMethod] - Failed Future")
        Left(ErrorModel(Status.INTERNAL_SERVER_ERROR, "Failed Future"))
    }
  }
}
