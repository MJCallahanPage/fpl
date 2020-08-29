FROM openjdk:8-jre

ENV SBT_VERSION 1.3.13
ENV PORT 9000
ENV HOST 0.0.0.0

RUN \
  curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

WORKDIR /usr/local/app

ADD . /usr/local/app

EXPOSE 9000
CMD sbt stage
