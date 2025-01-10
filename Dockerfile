# Usar una imagen base de Java con soporte para Java 17
FROM eclipse-temurin:17-jdk-jammy

# Instalar Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y resolver dependencias para el cacheo de dependencias
COPY pom.xml ./
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline

# Copiar el código fuente al contenedor
COPY src ./src

# Compilar el proyecto y empaquetarlo como un archivo .jar
RUN mvn package -DskipTests

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/gym-0.0.1-SNAPSHOT.jar"]
