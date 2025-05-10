# Application Setup Guide

This README provides instructions on how to set up and run the application which consists of a Spring Boot backend and a Node.js/NPM frontend.

## Prerequisites

Before you begin, make sure you have the following installed:

- [Java JDK 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/download.cgi)
- [Node.js and NPM](https://nodejs.org/)
- Git (optional)

## Repository Structure

```
/project-root
  ├── /backend         # Spring Boot backend
  │   ├── pom.xml
  │   └── src/...
  ├── /frontend        # Node.js frontend
  │   ├── package.json
  │   └── src/...
```

## Step 1: Build and Run the Backend

Navigate to the backend directory:

```bash
cd backend
```

Build the application with Maven:

```bash
mvn clean install
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

The backend API should now be running on http://localhost:8080

## Step 2: Install and Run the Frontend

Open a new terminal window, navigate to the frontend directory:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend should now be running on http://localhost:5173

## Step 3: Access the Application

Open your browser and go to:

```
http://localhost:5173
```
