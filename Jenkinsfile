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
                    echo "My image name is ${env.IMAGE_NAME}"
                    def shellCmd = "bash ./server-cmds.sh ${IMAGE_NAME}"

                    sshagent(['ec2-server-key'])
                    {
                        sh "scp server-cmds.sh ec2-user@3.75.76.116:/home/ec2-user"
                        sh "scp docker-compose.yaml ec2-user@3.75.76.116:/home/ec2-user"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@3.75.76.116 ${shellCmd}"

                        
                    }
                }
            }
        }
    }
}