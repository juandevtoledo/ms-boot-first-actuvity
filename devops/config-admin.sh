#!/bin/bash
echo "run config service"
docker run  -itd  --name config-service-primary   -p 8081:8081 -e GIT_USER=$GIT_USER -e GIT_PASSWORD=$GIT_PASSWORD -e SPRING_PROFILES_ACTIVE=primary   --network=onlinestore registry.juandevtoledo:5001/config-service:$BUILD_VERSION
docker run  -itd  --name config-service-secondary -p 8082:8082 -e GIT_USER=$GIT_USER -e GIT_PASSWORD=$GIT_PASSWORD -e SPRING_PROFILES_ACTIVE=secondary  --network=onlinestore registry.juandevtoledo:5001/config-service:$BUILD_VERSION
echo "run admin service"
docker run  -itd  --name admin-service -p 8086:8086  --network=onlinestore    registry.juandevtoledo:5001/admin-service:$BUILD_VERSION
