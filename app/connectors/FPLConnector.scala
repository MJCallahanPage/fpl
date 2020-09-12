package connectors

import config.AppConfig
import javax.inject.Inject
import models.FPLDataModel
import models.fixtures.Fixture
import play.api.Logging
import play.api.http.Status
import play.api.libs.json.{JsError, JsSuccess}
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}

class FPLConnector @Inject()(http: WSClient)(implicit appConfig: AppConfig) extends Logging {

  def getData()(implicit executionContext: ExecutionContext): Future[Option[FPLDataModel]] =
    http.url(appConfig.fplUrl).get().map { response =>
      response.status match {
        case Status.OK =>
          response.json.validate[FPLDataModel] match {
            case JsSuccess(value, _) => Some(value)
            case JsError(errors) =>
              logger.error(s"Failed to parse FPL response: $errors")
              None
          }
        case status =>
          logger.error(s"Unexpected status received from FPL API $status, body: ${response.body}")
          None
      }
    }

  def getFixturesData()(implicit executionContext: ExecutionContext): Future[Option[Seq[Fixture]]] =
    http.url(appConfig.fixturesUrl).get().map { response =>
      response.status match {
        case Status.OK =>
          response.json.validate[Seq[Fixture]] match {
            case JsSuccess(value, _) => Some(value)
            case JsError(errors) =>
              logger.error(s"Failed to parse fixtures response: $errors")
              None
          }
        case status =>
          logger.error(s"Unexpected status received from FPL Fixtures API $status, body: ${response.body}")
          None
      }
    }
}
