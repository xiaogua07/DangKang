String buildNumber = env.BUILD_NUMBER;
String timestamp = new Date().format('yyyyMMddHHmmss');
String projectName = env.JOB_NAME.split(/\//)[0];
// e.g awesome-project/release/RELEASE-1.0.0
String branchName = env.JOB_NAME.split(/\//)[1..-1].join(/\//);

println("${buildNumber} ${timestamp} ${projectName}");

String version = "${buildNumber} ${timestamp} ${projectName}"

node({
    checkout scm;

    if (params.BuildType == 'Rollback') {
        return rollback();
    } else if (params.BuildType == 'Normal') {
        return normalCIBuild(version)
    } else if (branchName == 'master') {
        setScmPollStrategyAndBuildTypes(['Normal', 'Rollback'])
    }
})

def normalCIBuild(String version) {
    stage('test & package')

    sh('./mvnw clean package -DskipTests')

    stage('docker build')
    sh("docker build -t ip:port/dangkang-springboot:${version}")

    sh("docker push")

    stage('deploy')

    input ('deploy?')

    deployVersion(version)
}

def deployVersion(String version) {
    sh "ssh root@ip 'docker rm -f dangkang && docker run --name dangkang -d -p 8080:8080 ip:port/dangkang-springboot:${version}'"
}

def setScmPollStrategyAndBuildTypes(List buildTypes) {
    def propertiesArray = [
        parameters([choice(choices: buildTypes.join('\n'), description: '', name: 'BuildType')]),
        pipelineTriggers([[$class: "SCMTrigger", scmpoll_spec: "* * * * *"]])
    ];

    properties(propertiesArray);
}

def rollback() {
    def  dockerRegistryHost = "http://ip:port";
    def getAllTagsUri = "/v2/dangkang/tags/list";

    def responseJson = new URL("${dockerRegistryHost}${getAllTagsUri}")
        .getText(requestProperties: ['Content-Type': "application/json"]);
    println(responseJson)

    // { name:xxx, tags: [tag1, tag2, ...] }
    Map response = new groovy.json.JsonSlurperClassic().parseText(responseJson) as Map;

    def versionStr = response.tags.join('\n');

    def rollbackVersion = input(
        message: 'Select a version to rollback',
        ok: 'OK',
        parameters: [choice(choices: versionStr, description: 'version', name: 'version')]
    )
    println(rollbackVersion)

    deployVersion(rollbackVersion)
}