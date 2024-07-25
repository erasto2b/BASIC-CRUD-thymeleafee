pipeline {
    agent any

    tools {
        // Instala JDK y Maven
        jdk 'JAVA_17'
        maven 'Maven 3'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio desde GitHub
                git 'https://github.com/colombo1986/BASIC-CRUD-thymeleaf.git'
            }
        }

          stage('SonarQube Analysis') {
                withSonarQubeEnv() {
              sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=test-jenkins -Dsonar.projectName='test-jenkins'"
              }
          }

        stage('Build') {
            steps {
                // Compila el proyecto usando Maven
                sh 'mvn clean compile'
            }
        }

        stage('Package') {
            steps {
                // Empaqueta la aplicación
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Despliega la aplicación (ajusta según tu entorno)
                sh 'echo "Deploying application..."'
            }
        }
    }


}
