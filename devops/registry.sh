#!/bin/bash
echo "run registry"
docker run -d \
  -e REGISTRY_HTTP_ADDR=0.0.0.0:5001 \
  -p 5001:5001 \
  --name registry-digitallab \
  -v C:\\Users\\juan.toledo\\Documents\\jtoledo\\studio\\register:/var/lib/registry \
  registry:2
