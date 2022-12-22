/* Requires the Docker Pipeline plugin */
pipeline {
    agent any
    stages {
        stage('Mvn-Version') {
            steps {
                bat 'mvn --version'
            }
        }
        stage('Build') {
            steps {
                // Build the project with Maven
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                // Run the unit tests with Maven
                bat 'mvn test'
            }
        }
    }
}