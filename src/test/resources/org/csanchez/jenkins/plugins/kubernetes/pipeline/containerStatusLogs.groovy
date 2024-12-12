//noinspection GrPackage
pipeline {
    agent {
        kubernetes {
            yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: shell
    image: ubuntu
    command:
    - sleep
    args:
    - infinity
    // TODO: use requests over limits 
'''
        }
    }
    stages {
        stage('Run') {
            steps {
                sh 'sleep 20'
            }
        }
    }
}