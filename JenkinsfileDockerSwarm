node{
    stage("Git CheckOut"){
        git url: 'https://github.com/MithunTechnologiesDevOps/spring-boot-mongo-docker.git',branch: 'master'
    }
    
    stage(" Maven Clean Package"){
      def mavenHome =  tool name: "Maven-3.6.1", type: "maven"
      def mavenCMD = "${mavenHome}/bin/mvn"
      sh "${mavenCMD} clean package"
    } 
    
    stage("Build Dokcer Image") {
         sh "docker build -t dockerhandson/spring-boot-mongo ."
    }
    
    stage("Docker Push"){
        withCredentials([string(credentialsId: 'Docker_Hub_Pwd', variable: 'Docker_Hub_Pwd')]) {
          sh "docker login -u dockerhandson -p ${Docker_Hub_Pwd}"
        }
        sh "docker push dockerhandson/spring-boot-mongo"
        
    }
    
    // Remove local image in Jenkins Server
    stage("Remove Local Image"){
        sh "docker rmi -f dockerhandson/spring-boot-mongo"
    }
    
    stage("Deploy to docker swarm cluster"){
        sshagent(['Docker_Swarm_Manager_Dev']) {
		    sh 'scp -o StrictHostKeyChecking=no  docker-compose.yml ubuntu@172.31.47.232:'
		    //sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.47.232 docker stack rm springboot'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.47.232 docker stack deploy --prune --compose-file docker-compose.yml springboot'
        }
    }
}
