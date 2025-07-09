APP_NAME=my-app
.PHONY: all build docker-build run crean stop

all:run

build:
	mvn clean package

docker-build: build
	docker-compose build

run: docker-build	
	docker-compose up

stop: 
	docker-compose down

clean:
	mvn clean
	docker system prune -f