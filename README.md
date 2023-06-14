# Prueba-tecnica-backend

Ejecución

Clone el repositorio en una carpeta especifica dentro de ordenador, posteriormente ejecute los siguientes comandos

haga checkout a la rama master
dentro de carpeta backend-demo abra una ventana de gitbash o su equivalente y ejecute los siguientes comandos:
En consola ejecutar:

mvn clean package

Posteriormente ejecutar 

 docker login
 Username:
 Password
 
docker build -t app-springboot-postgresql .
docker tag app-springboot-postgresql <Dockerhub user>/app-springboot-postgresql:latest
docker push <Dockerhub user>/app-springboot-postgresql
docker-compose up --force-recreate




En el archivo BaseDatos.txt se encuentra el script de creación de la base de datos.
En el archivo pichincha.postman_collection.json se encuentra el JSON con las pruebas de los diferentes endpoints.
