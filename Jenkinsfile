pipeline {
       
        agent {
        docker {
            image 'maven:3-alpine'
            args '-v /jenkins/.m2:/jenkins/.m2'
            }
        }
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonar-server') {
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        }
      }
