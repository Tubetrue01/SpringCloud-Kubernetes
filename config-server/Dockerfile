FROM swr.cn-north-4.myhuaweicloud.com/openjdk:11.0.6-jre

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/web/config-server.jar

ENV JVM_OPTS="-Xss256k -Duser.timezone=Asia/Shanghai -Djava.security.egd=file:/dev/./urandom"
ENV JAVA_OPTS=""
ENV APP_OPTS=""

EXPOSE 4040

ENTRYPOINT [ "sh", "-c", "java $JVM_OPTS $JAVA_OPTS -jar /usr/local/web/config-server.jar $APP_OPTS" ]
