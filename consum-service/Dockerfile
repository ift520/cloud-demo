FROM openjdk:8-jre-alpine
LABEL author=liufei
LABEL email=liu.ift@gmail.com
LABEL phone=13333333333
ARG JAR_FILE
RUN rm -rf /etc/localtime \
&& ln -sv /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo "Asia/Shanghai" > /etc/timezone
ADD ${JAR_FILE} /usr/home/app.jar
ENTRYPOINT ["java", "-jar", "/usr/home/app.jar"]