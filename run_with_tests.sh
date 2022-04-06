./build.sh
docker run -d -p 8080:8080 --name int20220405 int20220405
sleep 10 # this can replace with a wait loop
./gradlew test --tests '*.MetricsControllerTest'
docker stop int20220405
docker rm int20220405
docker rmi -f int20220405
