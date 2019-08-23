pipeline{
        agent any

        stages {
            stage('Compile Stage'){
                steps{
                     maven(maven : 'maven_3_6_1'){
                        sh 'mvn clean compile'
                     }
                }

            }

            stage('Deployment Stage'){
                 steps{
                       maven(maven : 'maven_3_6_1'){
                         sh 'mvn deploy'
                       }
                 }

            }
        }
}