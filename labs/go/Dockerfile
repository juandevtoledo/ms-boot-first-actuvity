###MULTI SSTAGE BUILDS
### STAGE 1: Build ###
FROM golang:1.11-alpine AS builder
RUN apk add --update git && apk add build-base  make gcc musl-dev linux-headers
RUN go get  github.com/edumar111/fastpv-auth
WORKDIR /go/src/github.com/edumar111/fastpv-auth
RUN export GO111MODULE=on &&  go build  -o /go/bin/auth *.go

### STAGE 2: Setup ###
FROM alpine:latest
RUN apk add --no-cache ca-certificates
WORKDIR /root/
COPY --from=builder /go/bin /
COPY --from=builder /go/src/github.com/edumar111/fastpv-auth/settings /settings

CMD ["/auth"]

# docker login
# docker build -t edumar111/fastpv-auth:v1.0.5 -f Dockerfile .
# docker push     edumar111/fastpv-auth:v1.0.5
