# Docker部署Javaweb(war)
# Dockerfile for lifecat-ssm
# 1. Copy lifecat.war to current directory
# 2. Build with: docker build -t lifecat-ssm .
# 3. Run with: docker run -d -p 8092:8080 lifecat-ssm

FROM tomcat:7.0

MAINTAINER kevinten <wshten@gmail.com>

ADD ssm.war /usr/local/tomcat/webapps/

EXPOSE 8080
