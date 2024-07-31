pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio desde GitHub
                git 'https://github.com/colombo1986/BASIC-CRUD-thymeleaf.git'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def sonarRunner = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    withSonarQubeEnv('SonarQubeServer') {
                        sh """
                            ${sonarRunner}/bin/sonar-scanner \
                            -Dsonar.projectKey=manage-eventos-app \
                            -Dsonar.java.binaries=target/classes
                        """
                    }
                }
            }
        }


        stage('Quality Gate') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
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



     def COLOR_MAP = [
         'SUCCESS': 'bueno',
         'FAILURE': 'peligro'
     ]

     // Script de Notificación
     post {
         always {
             echo 'Notificación a Slack'
             slackSend channel: '#time-tracker-ci',
                       color: COLOR_MAP[currentBuild.currentResult],
                       message: "*${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n  
      Más información en: ${env.BUILD_URL}*"
         }
     }

}