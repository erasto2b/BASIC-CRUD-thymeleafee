pipeline {
    pipeline {
        agent {
            docker {
                image 'maven:3.8.6-openjdk-17'
                args '-Dorg.jenkinsci.plugins.durabletask.BourneShellScript.HEARTBEAT_CHECK_INTERVAL=86400'
            }
        }

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
