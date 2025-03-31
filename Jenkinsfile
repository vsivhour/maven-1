pipeline {
    agent any
    
    tools {
        // Define the Maven and JDK tools to use
        maven 'Maven'
        jdk 'JDK21'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Get code from GitHub repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Build the Maven project
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Run the tests
                sh 'mvn test'
            }
            post {
                always {
                    // Publish test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        
        stage('Run') {
            steps {
                // Run the application (headless mode for CI environment)
                sh 'mvn exec:java -Djava.awt.headless=true'
            }
        }
    }
    
    post {
        failure {
            // Send email on failure
            mail to: 'admin@example.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with the build ${env.BUILD_URL}"
        }
        success {
            echo 'Build completed successfully!'
        }
    }
}