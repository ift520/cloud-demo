FROM openjdk:8-jre
LABEL author=liufei
LABEL email=liu.ift@gmail.com
LABEL phone=13333333333
ADD init.sh /init.sh
RUN chmod +x /init.sh
RUN rm -rf /etc/localtime \
&& ln -sv /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo "Asia/Shanghai" > /etc/timezone
ARG JAR_FILE
ADD ${JAR_FILE} /usr/home/app.jar
ENTRYPOINT ["java", "-jar", "/usr/home/app.jar"]