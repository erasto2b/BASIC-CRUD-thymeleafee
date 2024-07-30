pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio desde GitHub
                git 'https://github.com/colombo1986/BASIC-CRUD-thymeleaf.git'
            }
        }

          node {
              stage('SCM') {
                  checkout scm
              }
              stage('SonarQube Analysis') {
                  def mvnHome = tool name: 'Maven 3.8.7', type: 'hudson.tasks.Maven$MavenInstallation'
                  withSonarQubeEnv('SonarQube') {
                      sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=manage-eventos-app -Dsonar.projectName='manage-eventos-app'"
                  }
              }
          }


        stage('Build') {
            steps {
                // Compila el proyecto usando Maven
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Ejecuta las pruebas unitarias
                sh 'mvn test'
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



    post {
        always {
            // Publica los resultados de la prueba
            junit 'target/surefire-reports/*.xml'
        }
        success {
            // Notifica en caso de éxito
            echo 'Build and tests succeeded!'
        }
        failure {
            // Notifica en caso de fallo
            echo 'Build or tests failed.'
        }
    }

}