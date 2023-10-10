db-build:
	@docker build -t psql-db -f postgres.Dockerfile .
db-run:
	@docker run -d --name easybank_jee-db -p 5433:5432 -v easybank_jee_data:/var/lib/postgresql/data psql-db
db-start:
	@docker start easybank_jee-db
db-stop:
	@docker stop easybank_jee-db
test:
	mvn clean verify
clean:
	mvn clean install