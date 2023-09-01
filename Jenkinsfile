//所有脚本命令都在pipeline中执行
pipeline {
    //定义agent，指定脚本执行的节点
    agent any

    tools{
        //指定jdk
        jdk 'jdk17'
    }
    //定义环境变量
    environment {
        key = 'value'
    }

    stages{
        stage('拉取git仓库代码'){
            steps{
                checkout scmGit(branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[credentialsId: '2bb65f98-6835-45ab-8ebd-1bfa1eae75bc', url: 'http://119.91.199.41:10800/github/chaos.git']])
                echo '拉取git仓库代码 - SUCCESS'
            }
        }
        stage('通过maven构建项目'){
            steps{
                sh '/var/jenkins_home/maven/bin/mvn clean package -Dmaven.test.skip=true'
                echo '通过maven构建项目 - SUCCESS'
            }
        }
        stage('推送项目到远程服务器构建镜像并部署'){
            steps{
                sshPublisher(publishers: [sshPublisherDesc(configName: 'CentOS7.6-Docker20-chaos', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''cd /data/chaos/docker
                mv ../chaos-api/target/*.jar ./
                docker-compose down
                docker-compose up -d --build
                docker image prune -f''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'chaos-api/target/*.jar docker/*')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                echo '推送项目到远程服务器构建镜像并部署 - SUCCESS'
            }
        }
    }
}
