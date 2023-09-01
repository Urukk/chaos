FROM ghcr.io/graalvm/jdk-community:17
CMD ["/bin/sh","-c","mkdir","-p","/data/chaos"]
ADD chaos.jar /data/chaos/app.jar
ENTRYPOINT ["java","-jar","/data/chaos/app.jar"]