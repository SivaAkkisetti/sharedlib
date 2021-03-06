def call(nexusRepo){               
    def pom = readMavenPom file: 'pom.xml'
    def repo = nexusRepo
    def artifactId = pom.artifactId
    def groupId = pom.groupId
    nexusArtifactUploader artifacts: [[artifactId: artifactId, classifier: '', file: "target/${artifactId}-${pom.version}.war", type: 'war']], 
            credentialsId: 'admin', 
            groupId: groupId, 
            nexusUrl: '172.31.15.134:8081', 
            nexusVersion: 'nexus3', 
            protocol: 'http', 
            repository: repo, 
            version: pom.version
}
