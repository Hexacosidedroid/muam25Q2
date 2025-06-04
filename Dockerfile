FROM ubuntu:latest
LABEL authors="slava_ivanov_saikyo"

ENTRYPOINT ["top", "-b"]