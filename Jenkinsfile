/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven:3.8.1-jdk-11' } }
    stages {
        stage('build') {
            steps {
                bat 'mvn --version'
            }
        }
    }
}