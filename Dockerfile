FROM bellsoft/liberica-openjdk-debian:21

ADD "./target/muam-start-0.0.1.jar" "/opt/app.jar"
ADD "./entrypoint.sh" "/opt/entrypoint.sh"
WORKDIR /opt
RUN chmod 755 ./entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
