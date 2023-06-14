# Utiliza una imagen base de OpenJDK
FROM openjdk:17-jdk

# Copia el archivo JAR de la aplicación en el contenedor
COPY target/app-pichincha.jar /app.jar

# Expone el puerto en el que se ejecuta la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "/app.jar"]
