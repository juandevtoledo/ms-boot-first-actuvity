FROM openjdk:11-jre-slim
ARG BUILD_VERSION
ENV APP_FILE admin-service-$BUILD_VERSION.jar
ENV APP_HOME /usr/apps
ENV APP_SOURCE ./build/libs
COPY $APP_SOURCE/$APP_FILE $APP_HOME/
RUN mkdir -p $APP_HOME/src/main/resources
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Djava.security.egd=file:/dev/./urandom -jar $APP_FILE"]
EXPOSE 8086
# docker build --build-arg BUILD_VERSION=$BUILD_VERSION -t  registry.juandevtoledo:5001/admin-service:$BUILD_VERSION -f Dockerfile .
# docker  push registry.juandevtoledo:5001/admin-service:$BUILD_VERSION
# docker ps --filter "name=admin-service"

#
