FROM openjdk:11-jre-slim
ARG BUILD_VERSION
ENV APP_FILE employe-service-$BUILD_VERSION.jar
ENV APP_HOME /usr/apps
ENV APP_SOURCE ./build/libs
COPY $APP_SOURCE/$APP_FILE $APP_HOME/
RUN mkdir -p $APP_HOME/src/main/resources
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Djava.security.egd=file:/dev/./urandom -jar $APP_FILE"]
EXPOSE 8291
# docker build --build-arg BUILD_VERSION=$BUILD_VERSION -t registry.juandevtoledo:5001/employe-service:$BUILD_VERSION -f Dockerfile .
# docker  push registry.juandevtoledo:5001/employe-service:$BUILD_VERSION

# docker ps --filter "name=customer-service"

# docker run  --name employe-service  --network=onlinestore   -p 8291:8291  registry.juandevtoledo:5001/employe-service:$BUILD_VERSION
