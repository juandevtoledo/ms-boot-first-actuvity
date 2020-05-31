#!/bin/bash
echo "run eureka service"
docker run  -itd  --name registry-service-primary   -p 8083:8083  -e SPRING_PROFILES_ACTIVE=primary   --network=onlinestore   registry.juandevtoledo:5001/registry-service:$BUILD_VERSION
docker run  -itd  --name registry-service-secondary -p 8084:8084  -e SPRING_PROFILES_ACTIVE=secondary --network=onlinestore   registry.juandevtoledo:5001/registry-service:$BUILD_VERSION
docker run  -itd  --name registry-service-tertiary  -p 8085:8085  -e SPRING_PROFILES_ACTIVE=tertiary  --network=onlinestore   registry.juandevtoledo:5001/registry-service:$BUILD_VERSION
