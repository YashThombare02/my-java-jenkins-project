pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/YashThombare02/my-java-jenkins-project.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
