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
            emailext(
                subject: "❌ Jenkins Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Build Failed!

Job Name: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Status: FAILURE
Build URL: ${env.BUILD_URL}

Please check Jenkins console logs.
""",
                to: "ythombare1972@gmail.com"
            )
        }
    }
}
