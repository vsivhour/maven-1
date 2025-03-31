# Jenkins Setup Guide

This guide will help you set up Jenkins for CI/CD with this Java desktop application.

## Prerequisites

- Docker and Docker Compose installed
- Git installed

## Setting Up Jenkins

### 1. Start Jenkins using Docker Compose

```bash
docker-compose up -d
```

### 2. Get the Initial Admin Password

```bash
docker exec jenkins-lts cat /var/jenkins_home/secrets/initialAdminPassword
```

### 3. Access Jenkins

Open your browser and navigate to `http://localhost:8080`

### 4. Install Required Plugins

During the setup wizard:
1. Choose "Install suggested plugins"
2. After that completes, go to "Manage Jenkins" > "Manage Plugins" > "Available"
3. Search for and install:
   - "Maven Integration" plugin
   - "Email Extension" plugin

### 5. Configure JDK 21

1. Go to "Manage Jenkins" > "Global Tool Configuration"
2. Under JDK, click "Add JDK"
3. Set "Name" to "JDK21"
4. Either:
   - Uncheck "Install automatically" and provide the path to your JDK 21 installation
   - Or keep "Install automatically" checked and select JDK 21 from the dropdown

### 6. Configure Maven

1. In the same "Global Tool Configuration" page
2. Under Maven, click "Add Maven"
3. Set "Name" to "Maven"
4. Keep "Install automatically" checked

## Creating the Jenkins Job

### 1. Create a New Pipeline Job

1. Click "New Item" on the Jenkins dashboard
2. Enter a name (e.g., "simple-desktop-app")
3. Select "Pipeline" and click "OK"

### 2. Configure the Pipeline

1. In the "Pipeline" section, select "Pipeline script from SCM"
2. Select "Git" as the SCM
3. Enter your GitHub repository URL
4. Set the branch to "*/main" (or your default branch)
5. Set the "Script Path" to "Jenkinsfile"

### 3. Configure Poll SCM

1. In the "Build Triggers" section, check "Poll SCM"
2. Enter a schedule (e.g., `H/15 * * * *` to check every 15 minutes)

### 4. Configure Email Notifications

1. Go to "Manage Jenkins" > "Configure System"
2. Find the "E-mail Notification" section
3. Configure your SMTP server settings
4. Test the configuration by sending a test email

## Running the Pipeline

1. Save the job configuration
2. Click "Build Now" to manually trigger the first build
3. View the console output to see the build progress

## Troubleshooting

### Common Issues

1. **Plugin Installation Failures**: Restart Jenkins and try again
2. **Git Connection Issues**: Ensure your repository is public or provide credentials
3. **Build Failures**: Check the console output for specific error messages

### Logs

Jenkins logs can be viewed by running:

```bash
docker logs jenkins-lts
```