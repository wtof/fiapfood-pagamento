# Usa uma imagem base com o maven instalado
FROM maven:3.8.3-amazoncorretto-17 AS build

# Configura  o diretório de trabalho
WORKDIR /app

# Copia os arquivos pom.xml
COPY pom.xml ./

# Baixa as dependências do projeto
RUN mvn dependency:go-offline -B

# Copia o fonte dos projetos 
COPY /src ./src

# Builda o projeto
# -T 1C siguinifica uma thread por nucleo, configuração para acelerar o build
RUN mvn clean install -T 1C

# Usa uma imagem mas leve do  amazoncorretto
FROM amazoncorretto:17

# Configurao diretorio de trabalho
WORKDIR /app

# Copias os artefatos do projeto 
COPY --from=build /app/target/*.jar ./app.jar

# Executa o projeto a partir do modulo principal
CMD ["java", "-jar", "./app.jar", "--spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]