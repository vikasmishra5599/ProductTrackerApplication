# ProductTrackerApplication
An application for searching product detail using spring boot rest application with JPA.

Prerequisite
------------
1. JDK14
2. Maven
3. Docker

### Build Application
mvn clean install

### Running from maven
mvn spring-boot:run

### Build docker image
docker build . --tag product-tracker-app:1.0

### Run an image
docker run -p 8080:8080 product-tracker-app:1.0


##### In case, maven is not installed, we can run app directly from docker:: 

docker run -it --rm --name tracker-app -p 8080:8080 -v "$PWD":/usr/src/app  -v "$HOME"/.m2:/root/.m2 -w /usr/src/app maven:3.6.3-openjdk-14-slim mvn spring-boot:run

##### Kubernetes
Have uploaded docker image to dockerhub  (https://hub.docker.com/repository/docker/vikas5misra/spring-boot-rest-api)

**Create deployment**

kubectl apply -f deploy/deployment.yml
kubectl get deployments

**Create service**

kubectl apply -f deploy/service.yml
kubectl get services

minikube dashboard

kubectl get pods

kubectl expose deployment product-tracker-app --type=LoadBalancer --port=8080
minikube service  product-tracker-app

##### Endpoints

http://localhost:8082/product-app/api/     <For Healthcheck>

**GET /product**

**Query Parameter**		    **Description**

1. type				          	The product type. (String. Can be 'phone' or 'subscription')
2. min_price	  		    	The minimum price in SEK. (Number)
3. max_price		  	    	The maximum price in SEK. (Number)
4. city					          The city in which a store is located. (String)
5. property			         	The name of the property. (String. Can be 'color' or 'gb_limit')
6. property:color			    The color of the phone. (String)
7. property:gb_limit_min 	The minimum GB limit of the subscription. (Number)
8. property:gb_limit_max 	The maximum GB limit of the subscription. (Number)



Example: GET /product?type=subscription&max_price=1000&city=Stockholm


#### To run with frontend

mvn spring-boot:run

http://localhost:8082/product-app/