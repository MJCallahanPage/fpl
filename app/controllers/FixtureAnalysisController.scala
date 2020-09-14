//package controllers
//
//import config.AppConfig
//import connectors.FPLConnector
//import javax.inject._
//import models.FPLDataModel
//import models.fixtures.Fixtures
//import play.api.mvc._
//import utils.AnalysisUtils
//
//import scala.concurrent.ExecutionContext.Implicits.global
//
//@Singleton
//class FixtureAnalysisController @Inject()(val controllerComponents: MessagesControllerComponents,
//                                          fplConnector: FPLConnector
//                                         )
//                                         (implicit appConfig: AppConfig) extends MessagesBaseController with AnalysisUtils{
//
//  def onPageLoad(): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
//    fplConnector.getData().map { oModel: Option[FPLDataModel] =>
//      fplConnector.getFixturesData().map { oFixtures: Option[Fixtures] =>
//        oModel.map { dataModel =>
//          oFixtures.map { fix =>
//            implicit val fplDataModel: FPLDataModel = dataModel
//            implicit val fixtures: Fixtures = fix
//
//            analyseOpponent("Chelsea", 1)
//
//            Ok(views.html.playerPointsStats(oModel))
//
//
//          }
//        }
//      }
//    }
//  }
//}
