pipeline{
        agent any

        stages {
            stage ('Compile Stage') {
                steps {
                     withMaven(maven : 'maven_3_5_0') {
                        bat 'mvn clean compile'
                     }
                }

            }

            stage ('Deployment Stage') {
                 steps {
                       withMaven(maven : 'maven_3_5_0') {
                         bat 'mvn deploy'
                       }
                 }
            }
        }
}