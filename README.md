# CI/CD Example Project

This project demonstrates an end-to-end CI/CD pipeline using Jenkins, SonarQube, Nexus, and Slack.

## Flow
1. Developer commit → GitHub Webhook triggers Jenkins
2. Jenkins checks out code, runs unit tests, invokes SonarQube Scanner
3. If SonarQube quality gate passes, Jenkins builds the jar and uploads to Nexus
4. Build result is pushed to a Slack channel

## Project Structure
- Java Maven project (`pom.xml`)
- Jenkins pipeline (`Jenkinsfile`)
- SonarQube config (`sonar-project.properties`)
- Maven settings (`settings.xml`)

## Jenkins Setup
- Configure Jenkins with SonarQube, Nexus, and Slack credentials
- Use the provided `Jenkinsfile` for pipeline

## SonarQube
- Update `sonar-project.properties` as needed
- Access at http://localhost:9000 (admin/admin)

## Nexus
- Access at http://localhost:8081 (admin/a832590b-594c-4fbb-9fe1-c53dc97e1790)
- Update `NEXUS_URL` and credentials in `Jenkinsfile`
- Default repositories: `maven-snapshots`, `maven-releases`

## Slack
- Add Slack webhook as a Jenkins secret text credential (`slack-webhook-url`)

## Quick Start
1. Start SonarQube: `docker run -d --name sonarqube -p 9000:9000 sonarqube:community`
2. Start Nexus: `docker run -d --name nexus -p 8081:8081 sonatype/nexus3:latest`
3. Configure Jenkins with the provided credentials
4. Push to GitHub and trigger the pipeline

---

**Customize URLs and credentials as needed for your environment.** 