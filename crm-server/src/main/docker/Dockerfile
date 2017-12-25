# 指定一个基础镜像centos
FROM docker.io/centos:latest

#安装应用执行的环境java
#RUN yum -y install java
 
#将指定的jar文件复制到容器中
COPY crm-server-1.0-SNAPSHOT.jar /usr/local/
  
#执行jar文件
ENTRYPOINT ["java" ,"-jar","/usr/local/crm-server-1.0-SNAPSHOT.jar"]
##############
#FROM java:8
​
#MAINTAINER huangll99@126.com
​
#ADD springboot-docker-0.1.jar /app.jar
​
#EXPOSE 8080
​
#ENTRYPOINT ["/usr/bin/java","-jar","app.jar"]