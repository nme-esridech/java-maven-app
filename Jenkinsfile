pipeline {
  
  agent any
  tools {
    maven 'Maven-3.8.6'
  }
  stages {
    
    stage("build jar"){      
      steps {
        echo 'build the application'
        sh 'maven package'
      }
    }

    stage("build image"){      
      steps {
        echo 'building the docker image'
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            sh 'docker build -t nme4esri/my-repo:jma-2.0 .'
            sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
            sh 'docker push nme4esri/my-repo:jma-2.0'
    }
        }

      }
    

    stage("deploy"){

      steps {
        echo 'deploy the application'
                
        }
    }    
  }
}
