FROM ghcr.lank8s.cn/graalvm/jdk-community:17
CMD ["/bin/sh","-c","mkdir","-p","/data/chaos"]
ADD chaos-api.jar /data/chaos/app.jar
ENTRYPOINT ["java","-jar","/data/chaos/app.jar"]