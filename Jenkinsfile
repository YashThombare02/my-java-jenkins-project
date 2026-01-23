pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/YashThombare02/my-java-jenkins-project.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
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

🔗 Build URL:
${env.BUILD_URL}

📄 Console Log:
${env.BUILD_URL}console

📂 Workspace:
${env.WORKSPACE}

👉 Possible Cause:
Check console output for error stack trace or failed stage.

This is an automated notification from Jenkins.
"""
        )
    }
}


