name := """fantasy-premier-league"""
organization := "uk.co.matthewpage"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(guice, ws,
  "com.adrianhurt"            %% "play-bootstrap"       % "1.6.1-P28-B4",
  "org.webjars"               %  "bootstrap"            % "4.5.2",
  "org.webjars"               %  "jquery"               % "3.5.1",
  "org.webjars"               %  "bootstrap-table"      % "1.9.1",
  "org.scalatestplus.play"    %% "scalatestplus-play"   % "5.0.0" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "uk.co.matthewpage.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "uk.co.matthewpage.binders._"
