FROM openjdk:8

ENV SBT_VERSION 1.3.13

RUN \
  curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion

WORKDIR /fpl

ADD . /fpl
COPY run.sh /usr/local/bin/

RUN chmod u+x /usr/local/bin/run.sh
EXPOSE 8000 2222 80
ENTRYPOINT ["run.sh"]
