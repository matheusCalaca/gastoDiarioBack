# Use a imagem base com o JDK e o Gradle instalados
FROM gradle:jdk17 AS builder

# Copie os arquivos Gradle necessários para baixar as dependências
COPY settings.gradle build.gradle /home/gradle/project/

# Copie todos os arquivos do projeto
COPY . /home/gradle/project/

# Defina o diretório de trabalho
WORKDIR /home/gradle/project

# Compile o projeto usando o Gradle
RUN gradle build --no-daemon

# Use uma imagem base com o JRE para a execução da aplicação
FROM azul/zulu-openjdk:17-latest
LABEL authors="matheus Calaça"

# Copie o JAR construído a partir do estágio anterior
COPY --from=builder /home/gradle/project/gastoDiario-api/build/libs/gastoDiario-api-0.0.1-SNAPSHOT.jar /app/app.jar

# Defina o diretório de trabalho
WORKDIR /app

# Exponha a porta em que a aplicação Java está sendo executada (se necessário)
EXPOSE 8080

# Comando para executar a aplicação Java
CMD ["java", "-jar", "app.jar"]
