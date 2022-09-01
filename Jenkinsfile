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
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
          sh 'docker build -t nme4esri/my-repo:jma-2.0 .'
          sh "echo $PASS | docker login -u $USER --password-stdin"
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
