package models.team

import play.api.libs.json.{Reads, _}


object Club extends Enumeration {

  type Club = Value

  val Arsenal = Value("Arsenal")
  val AstonVilla = Value("Aston Villa")
  val Brighton = Value("Brighton & Hove Albion")
  val Burnley = Value("Burnley")
  val Chelsea = Value("Chelsea")
  val CrystalPalace = Value("Crystal Palace")
  val Everton = Value("Everton")
  val Fulham = Value("Fulham")
  val Leeds = Value("Leeds United")
  val Leicester = Value("Leicester City")
  val Liverpool = Value("Liverpool")
  val ManCity = Value("Manchester City")
  val ManUnited = Value("Manchester United")
  val Newcastle = Value("Newcastle United")
  val SheffieldUnited = Value("Sheffield United")
  val Southampton = Value("Southampton")
  val Spurs = Value("Tottenham Hotspur")
  val WestBrom = Value("West Bromwich Albion")
  val WestHam = Value("West Ham United")
  val Wolves = Value("Wolverhampton Wanderers")
}
