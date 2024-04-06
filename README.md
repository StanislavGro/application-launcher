# Application launcher 🎯

## Features ✨

- Import java applications
- Track app statistics
- Manage users who can control the status of applications
- Customize notifications

## Installation [frontend]

Application requires [Node.js](https://nodejs.org/) v21+ to run.

Install the dependencies and devDependencies and start the server.

```sh
cd frontend
npm i
npm start
```

## Installation [backend]

Requires [Java](https://adoptium.net/) v21+ to run

```sh
mvn spring-boot:run
```

## Installation [DB]

```sh
cd deploy/database/postgres
cp .env.example .env
```

Fill in the required fields .env file

```sh
docker compose build
docker compose up -d
```