FROM openjdk:11-jre-slim
ARG BUILD_VERSION
ENV APP_FILE security-service-$BUILD_VERSION.jar
ENV APP_HOME /usr/apps
ENV APP_SOURCE ./build/libs
COPY $APP_SOURCE/$APP_FILE $APP_HOME/
COPY rsa-public.pem /security/rsa-public.pem
COPY rsa-private.pem /security/rsa-private.pem
RUN sh -c 'touch /security/rsa-public.pem'
RUN sh -c 'touch /security/rsa-private.pem'
RUN mkdir -p $APP_HOME/src/main/resources
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Djava.security.egd=file:/dev/./urandom -jar $APP_FILE"]
EXPOSE 8095
# docker build --build-arg BUILD_VERSION=$BUILD_VERSION -t registry.juandevtoledo:5001/security-service:$BUILD_VERSION -f Dockerfile .
# docker  push registry.juandevtoledo:5001/security-service:$BUILD_VERSION

# docker ps --filter "name=security-service"
