pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    def dockerCmd = 'docker run -p 3000:3080 -d 523720541885.dkr.ecr.eu-central-1.amazonaws.com/react-nodejs:1.0'
                    sshagent(['ec2-server-key'])
                    {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@3.75.76.116 ${dockerCmd}"
                        
                    }
                }
            }
        }
    }
}
