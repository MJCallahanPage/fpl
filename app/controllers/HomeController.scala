package controllers

import javax.inject._
import play.api.i18n.Messages.implicitMessagesProviderToMessages
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: MessagesControllerComponents) extends MessagesBaseController {

  def index() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.index())
  }
}
