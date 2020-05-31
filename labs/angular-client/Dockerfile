### STAGE 1: Build ###
FROM node:10 as builder
COPY package.json package-lock.json ./

RUN npm ci && mkdir /ng-app && mv ./node_modules ./ng-app
WORKDIR /ng-app
COPY . .

RUN npm run ng build -- --prod --output-path=dist


### STAGE 2: Setup ###
FROM nginx:1.14.1-alpine
COPY nginx/default.conf /etc/nginx/conf.d/

RUN rm -rf /usr/share/nginx/html/*

COPY --from=builder /ng-app/dist /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
# docker build -t edumar111/angular-client:1.0.0 -f Dockerfile .
# docker push     edumar111/angular-client:1.0.0
# docker run -d --name angular-client -p 80:80 edumar111/angular-client:1.0.0