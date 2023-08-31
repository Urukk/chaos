//所有脚本命令都在pipeline中执行
pipeline {
    //定义agent，指定脚本执行的节点
    agent any

    //定义环境变量
    environment {
        key = 'value'
    }

    stages{
        stage('拉取git仓库代码'){
            steps{
                echo '拉取git仓库代码 - SUCCESS'
            }
        }
        stage('通过mavne构建项目'){
            steps{
                echo '通过mavne构建项目 - SUCCESS'
            }
        }
        stage('通过docker构建镜像'){
            steps{
                echo '通过docker构建镜像 - SUCCESS'
            }
        }
        stage('通过docker发布镜像'){
            steps{
                echo '通过docker发布镜像 - SUCCESS'
            }
        }
        stage('通过ssh远程登录服务器'){
            steps{
                echo '通过ssh远程登录服务器 - SUCCESS'
            }
        }
        stage('通过ssh远程执行命令'){
            steps{
                echo '通过ssh远程执行命令 - SUCCESS'
            }
        }
    }
}
