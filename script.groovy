def buildJar(){
    echo 'build the application'
    echo 'test commit for webhook22222'
    sh "mvn package"
}

def buildImage(){
    echo 'building the docker image'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t nme4esri/my-repo:jma-2.0 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh 'docker push nme4esri/my-repo:jma-2.0'
    }
}

def deployApp(){
    echo 'deploy the application'
}

return this
