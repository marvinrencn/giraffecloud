

# Development Enviorment

1. install docker
2. run a redis
```
docker run -p 6379:6379 -d redis:latest redis-server
```
3. run a mysql
```
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.6
```