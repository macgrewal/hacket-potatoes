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

package services

import javax.inject.{Inject, Singleton}

import connectors.$connectorName;format="Camel"$Connector
import models.{Error, $modelName;format="Camel"$}

import scala.concurrent.Future

@Singleton()
class $serviceName;format="Camel"$Service @Inject()(val $connectorName;format="camel"$: $connectorName;format="Camel"$Connector) {

  def get$serviceName;format="Camel"$(): Future[Either[Error, $modelName;format="Camel"$]] = {
    $connectorName;format="camel"$.getUrl() map {
      case Right(success) =>
        //TODO: Add any service specific success logic here
        Right(success)
      case Left(error) =>
        //TODO: Add any service specific error logic here, and bubble error
        Left(error)
    }
  }

}
