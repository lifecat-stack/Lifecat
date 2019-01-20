# Docker部署Javaweb(war)
# Dockerfile for lifecat-xxx
# 1. Copy lifecat.war to current directory
# 2. Build with: docker build -t lifecat-xxx .
# 3. Run with: docker run -d -p <host port>:8080 lifecat-xxx

FROM tomcat:8.0

MAINTAINER kevinten <wshten@gmail.com>

ADD ./*.war /usr/local/tomcat/webapps/

EXPOSE 8080
