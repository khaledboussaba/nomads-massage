FROM node:8.1.4-alpine
WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 80

ENV NODE_ENV=prod

CMD ["npm","start"]