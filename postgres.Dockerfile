FROM postgres:15

ENV POSTGRES_PASSWORD=3ea14367A4
ENV POSTGRES_DB=easybank

#WORKDIR /docker-entrypoint-initdb.d

#COPY ./src/main/java/com/youcode/easybank_jee/db/migration/db.sql /docker-entrypoint-initdb.d/

EXPOSE 5433