#Depricated
FROM debian

RUN useradd -m -s /bin/bash java
ADD "./entrypoint.sh" "/opt/entrypoint.sh"
WORKDIR /opt
RUN chmod 755 ./entrypoint.sh
RUN mv /bin/bash /opt/bash
ENTRYPOINT ["./entrypoint.sh"]
