db-build:
	@docker build -t postgres-db -f postgres.Dockerfile .
db-run:
	@docker run -d --name easybank-db -p 5433:5432 -v easybank_data:/var/lib/postgresql/data postgres-db
db-start:
	@docker start easybank-db
db-stop:
	@docker stop easybank-db
test:
	mvn clean verify
clean:
	mvn clean install