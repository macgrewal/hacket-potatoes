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

package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc._
import services.UserDetailsService
import uk.gov.hmrc.play.bootstrap.controller.BaseController

@Singleton()
class PeopleController @Inject()(val userDetailsService: UserDetailsService) extends BaseController {

  def getPerson(): Action[AnyContent] = Action.async { implicit request =>
    userDetailsService.getUserDetails() map {
      case Right(success) =>
        //TODO: Add any specific controller logic for success response
        Ok(success)
      case Left(error) =>
        //TODO: Add any specific controller logic for error response, default is to return bubbled response
        Status(error.code)(error.msg)
    }
  }

}