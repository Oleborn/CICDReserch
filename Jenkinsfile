pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Oleborn/reserchCICD.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Cleanup') {
            steps {
                sh '''
                docker ps -a -q --filter "name=spring-boot-app" | xargs -r docker stop
                docker ps -a -q --filter "name=spring-boot-app" | xargs -r docker rm
                '''

                sh '''
                docker images -q --filter "dangling=true" | xargs -r docker rmi
                '''
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t spring-boot-app:1.0 .'
            }
        }

        stage('Run Docker') {
            steps {
                sh '''
                docker run -d --name spring-boot-app -p 9090:8080 spring-boot-app:1.0
                '''
            }
        }
    }
}
