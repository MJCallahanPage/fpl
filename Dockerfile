FROM openjdk:8

ENV JAVA_HOME=$(/usr/libexec/java_home)
ENV SBT_VERSION=1.3.13
ENV PORT=9000
ENV HOST=0.0.0.0

RUN \
  curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion && \
  java -version

WORKDIR /usr/local/app

ADD . /usr/local/app

RUN sbt stage

EXPOSE 9000
ENTRYPOINT ./target/universal/stage/bin/fantasy-premier-league -Dplay.http.secret.key='bananaMyKeyHashBanaas!@£!$@$$%!%!%@!%@!%RWSEGWFER£GBV£R'