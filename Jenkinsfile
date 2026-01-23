def failedStage = "Not Started"

pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java'
    }

    stages {

        stage('Checkout') {
            steps {
                script {
                    failedStage = "Checkout"
                }
                git branch: 'main',
                    url: 'https://github.com/YashThombare02/my-java-jenkins-project.git'
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    failedStage = "Build and Test"
                }
                bat 'mvn clean test'
            }
        }

        // ✅ NEW STAGE ADDED HERE
        stage('SonarQube Analysis') {
            steps {
                script {
                    failedStage = "SonarQube Analysis"
                }
                withSonarQubeEnv('SonarQube') {
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=DevOPs ^
                        -Dsonar.host.url=http://localhost:9000
                    """
                }
            }
        }
    }

    post {
        failure {
            mail(
                to: 'ythombare1972@gmail.com',
                subject: "❌ Jenkins Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """🚨 BUILD FAILURE ALERT 🚨

Job Name: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Build Status: FAILED
Failed Stage: ${failedStage}

Build URL:
${env.BUILD_URL}

Console Log:
${env.BUILD_URL}console

Please check Jenkins console logs for error details.
"""
            )
        }
    }
}
