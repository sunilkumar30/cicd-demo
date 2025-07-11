pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQubeServer' // Jenkins SonarQube server name
        NEXUS_URL = 'http://localhost:8081/repository/maven-snapshots/' // Replace with your Nexus URL
        NEXUS_CREDENTIALS_ID = 'nexus-credentials' // Jenkins credentials ID for Nexus
        // SLACK_WEBHOOK_URL = credentials('slack-webhook-url') // Jenkins secret text credential
        MAVEN_HOME = '/usr/local/Cellar/maven/3.9.10/libexec'
        PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv(env.SONARQUBE_SERVER) {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        // stage('Quality Gate') {
        //     steps {
        //         timeout(time: 15, unit: 'MINUTES') {
        //             waitForQualityGate abortPipeline: true
        //         }
        //     }
        // }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy to Nexus') {
            steps {
                sh 'mvn deploy -DaltDeploymentRepository=nexus::default::${NEXUS_URL}'
            }
        }
    }
    post {
        always {
            script {
                // Slack notification commented out - uncomment if you want notifications
                // def status = currentBuild.currentResult == 'SUCCESS' ? ':white_check_mark:' : ':x:'
                // def message = "Build ${env.JOB_NAME} #${env.BUILD_NUMBER} ${status} (${env.BUILD_URL})"
                // sh "curl -X POST -H 'Content-type: application/json' --data '{\"text\": \"${message}\"}' ${SLACK_WEBHOOK_URL}"
                echo "Build ${env.JOB_NAME} #${env.BUILD_NUMBER} completed with status: ${currentBuild.currentResult}"
            }
        }
    }
} 