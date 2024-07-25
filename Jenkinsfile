pipeline {
    agent any

    tools {
        // Instala JDK y Maven
        jdk 'JAVA_17'
        maven 'Maven 3'
    }

    environment {
        // Variables de entorno
        MAVEN_TOOL = tool name: 'Default Maven', type: 'maven'
    }

    stages {

        stage('SCM') {
            steps {
                checkout scm
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {  // Asegúrate de reemplazar 'SonarQube' con el nombre real de tu instalación de SonarQube en Jenkins
                        sh "${MAVEN_TOOL}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=test-jenkins -Dsonar.projectName='test-jenkins'"
                    }
                }
            }
        }

        stage('Checkout') {
            steps {
                // Clona el repositorio desde GitHub
                git 'https://github.com/colombo1986/BASIC-CRUD-thymeleaf.git'
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
