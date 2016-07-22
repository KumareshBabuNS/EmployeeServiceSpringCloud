<h1>PCF Service Registry Demo</h1>

Service Registry for Pivotal Cloud Foundry® (PCF) provides your applications with an implementation of the Service Discovery 
pattern, one of the key tenets of a microservice-based architecture. Trying to hand-configure each client of a service or 
adopt some form of access convention can be difficult and prove to be brittle in production. Instead, your applications can use 
the Service Registry to dynamically discover and call registered services

This code is for the blog entry below

```
http://theblasfrompas.blogspot.com.au/2016/07/creating-service-within-intellij-idea.html
```

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-springcloud-registery.png)

<h2> Deploy to PCF </h2>

- Clone project as shown below

```
$ git clone https://github.com/papicella/EmployeeServiceSpringCloud.git
```

- Package as shown below

```
$ cd EmployeeServiceSpringCloud
$ mvn package
```

- Create a Service Registry as shown below
  
```
cf create-service p-service-registry standard apples-service-registery
```
  
- Deploy using the provided manifest.yml file ensuring you use the correct name for the service as per the creation above

```
---
applications:
- name: apples-employee-service
  memory: 512M
  instances: 1
  host: apples-employee-service-${random-word}
  path: ./target/EmployeeService-0.0.1-SNAPSHOT.jar
  services:
    - apples-service-registery
```

- Push using 
 
```
$ cf push
```

Once deployed it will automatically bind to the Service Registry instance and you can see that as shown below.

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-springcloud-registery-2.png)

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal