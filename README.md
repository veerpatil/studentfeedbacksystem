# Student Feedback System

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Pre-Requisites
*  JDK 11 or Higher
*  MY SQL  

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## The API Details
### GET Users
    Returns All the users details
### Get User
    Returns single user details 
### Delete User By ID
    Deletes user by ID provided as Query Paramter
### Delete User By Name
    Deletes user by Name provided as Path Paramter
    
