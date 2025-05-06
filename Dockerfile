# Usa uma imagem base com JDK (Java)
FROM eclipse-temurin:17-jdk-jammy

# Diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven/Gradle
COPY C:/Users/Matheus/Desktop/demo/target/demo-0.0.1-SNAPSHOT.jar 

# Porta que o Spring Boot usa (normalmente 8080)
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]