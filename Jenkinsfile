pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/CrimsonBambi/OTP1.git'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Unit Tests') {
            steps {
                script {
                    bat 'mvn test'
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Coverage') {
            steps {
                script {
                    bat 'mvn jacoco:report'
                }
            }
            post {
                always {
                    jacoco execPattern: '**/target/jacoco.exec'
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
