#!/bin/bash
echo "run services"
docker run  -itd    --network=onlinestore  registry.juandevtoledo:5001/customer-service:$BUILD_VERSION
docker run  -itd    --network=onlinestore  registry.juandevtoledo:5001/product-service:$BUILD_VERSION
docker run  -itd     --network=onlinestore registry.juandevtoledo:5001/shopping-service:$BUILD_VERSION
docker run  -itd   --network=onlinestore   registry.juandevtoledo:5001/security-service:$BUILD_VERSION
echo "run gateway"
docker run  -itd  --name gateway-service  --network=onlinestore   -p 8080:8080   registry.juandevtoledo:5001/gateway-service:$BUILD_VERSION
