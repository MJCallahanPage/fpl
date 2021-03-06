package controllers

import config.AppConfig
import connectors.FPLConnector
import javax.inject._
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class PlayerPointsStatsController @Inject()(val controllerComponents: MessagesControllerComponents,
                                            fplConnector: FPLConnector)(implicit appConfig: AppConfig) extends MessagesBaseController {

  def onPageLoad(): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    fplConnector.getData().map { oModel =>
      Ok(views.html.playerPointsStats(oModel))
    }
  }
}
