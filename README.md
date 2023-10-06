<!-- ABOUT THE PROJECT -->
## About The Project

This project is part of the Software Engineer interview process for Pismo.

### Built With


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)


## Getting Started

This document explain how to import, install and run this project

### Prerequisites

Before run this project check if you have this dependencies installed

* Java 11 or above [OpenJDK](https://openjdk.org/projects/jdk/)
* Docker [Docker Desktop](https://docs.docker.com/desktop/)
* Docker Compose [Docker Compose](https://docs.docker.com/compose/)

### Installation

_Follow these steps to get the application ready to run_

1. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Run the containers
   ```sh
   docker-compose up -d
   ```
4. Run the application
   ```sh
   ./gradlew bootRun
   ```
<!-- USAGE EXAMPLES -->
## Usage

Examples of requests

### Create an account

* POST /accounts

_Request Body:_
   ```json
   {
      "document_number": "12345678900"
   }
   ```

### Get account information

* GET /accounts/:accountId

_Response Body:_
   ```json
{
    "account_id": 1,
    "document_number": "12345678900"
  }
   ```

### Create a transaction

* POST /transactions

_Request Body:_
   ```json
{
    "account_id": 1,
    "operation_type_id": 4,
    "amount": 123.45
  }
   ```
