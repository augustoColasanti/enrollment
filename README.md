# Enrollment

SpringBoot App created to provide and register students information. This app connects to a PostgreSQL database that runs in a Docker container.

## To start

1- Please make sure *java 18* and *Docker Compose* are installed 

2- Run *./enrollment.ps1 install*

3- Run *./enrollment.ps1 run*

### Available scripts (enrollment-ui.ps1)

*./enrollment.ps1 install*: installs third party dependencies

*./enrollment.ps1 run*: starts the docker container, and runs the SpringBoot app

*./enrollment.ps1 test*: runs the unit tests

*./enrollment.ps1 deploy*: generates the deployable file
