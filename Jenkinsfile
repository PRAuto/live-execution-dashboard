node
{

def mavenHome = tool name: "maven3.8.1"
    
stage ('CodeCheckOut')    
    {
        git branch: 'master', credentialsId: 'GIT', url: 'https://github.com/frameworksselenium/live-execution-dashboard.git'
    }

stage ('Compile Stage')
    {
        sh "${mavenHome}/bin/mvn clean install -test"
    }

stage ('Test Stage')
    {
        sh "${mavenHome}/bin/mvn install"
    }


}
