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
                    echo 'deploying docker image to EC2...'
                    def dockerComposeCmd = "docker compose -f docker-compose.yaml up --detach"
                    sshagent(['ec2-server-key'])
                    {
                        sh "scp docker-compose.yaml ec2-user@3.75.76.116:/home/ec2-user"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@3.75.76.116 ${dockerComposeCmd}"

                        
                    }
                }
            }
        }
    }
}