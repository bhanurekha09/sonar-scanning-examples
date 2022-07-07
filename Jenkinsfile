@Library('mylibrary') _

import com.cleverbuilder.GlobalVars
import com.cleverbuilder.SampleClass

pipeline {
        
        agent {
           docker {
             image 'maven:3.8.6-jdk-11'
             args '-v /root/.m2:/root/.m2'
        }
    }
      
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv(installationName: 'sonar-server', credentialsId: 'token') {
                sh 'mvn clean package sonar:sonar'
                echo "Hello, world"
                sayHello 'Dave'

                echo 'The value of foo is : ' + GlobalVars.foo'

                script {
                    def person = new SampleClass()
                    person.age = 21
                    person.increaseAge(10)
                    echo 'Incremented age, is now : ' + person.age
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
