# SA-ShoppingCart


# CLONNING
clone using the following command. It will pull all the services automatically

```
git submodule update --init --recursive

```


### Run the following external applications
1. Run kafka zookeeper
2. Run kafka server
3. Run zipkin  
4. Run Elastic search
5. Run Kibana
6. Run logstach
7. Run the mongo-db docker client using the provided docker-compose.yml file using the following command.
   Docker must be running before that.
    ```
        docker-compose up -d
    ```

### Start the services by the following order
1. start the ConfigService
2. Start EurekaService (use profiles,  peer1 and peer2  profiles are available)
3. Start ApiGateway Service
4. Start the remaining services in any order (Except the RestClient.)

#### Note that
ProductService has three profiles: peer1, peer2, peer3.   Run the service with these profiles
To run services with profile use the following example
```
    .\mvnw spring-boot:run  -D"spring-boot.run.profiles=peer1"
```
That will run the service with profile = peer1. Do the same with the rest.

### Finally
5. Start the RestClient service.
  


