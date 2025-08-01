
# 🏌️‍♂️ Golf Club Tournament API — Docker QAP (Semester Four)

**Author**: Noah Devine  
**Due Date**: August 1st, 2025

---

## Project Details
- The purpose of this project was to create a functional REST API interacting directly with the database while also utlizing docker and creating docker images.
  
- This project is based around a simple concept; a golf tournament with respective members. Within this repo, you will find two sets of files for tournaments and members, each with their own entity, repository, controller, and service files.

- This REST API allows the user to create tournaments and members, get all tournaments and members, add members to tournaments, delete members and tournaments, and provides different methods for looking up members and tournaments.

- Examples include looking up a member by name, phone number, and membership start date.

- For tournaments, you can look them up by start date, location, and even find all members in a tournament.

- You will also find in the root of the project a folder containing multiple screenshots for testing via postman. All tests were conducted using postman with a docker image setup.

## Setting up with Docker

1. Clone the project from this repo
2. Open the project in the IDE of your choice (IntelliJ is reccommended)
3. Take note of the docker-compose.yml and Dockerfile in the root of the project, these are your main files when setting up docker. You may need to change values in these files such as java version, username or password to match your credentials
4. Adjust file values as needed. For example, you might need to change the username and password in the application.properties file under resources to be able to establish a connection to the database
5. Open the Maven side panel (hope you are on IntelliJ) and under Lifecycle, run "clean" then "package"
6. Under the target directory, you should now have a .jar file of the project
7. In a command line terminal, now run "docker build -t golfclub_reg_api:latest ." this will build the image
8. now run "docker compose up" in the command line terminal, and that will now locally run your image.
9. You can now test the API endpoints in Postman, congrats dude!
  

