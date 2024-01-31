#Build
FROM eclipse-temurin:21 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
#Run
FROM tomcat:10.1-jre21
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD [ "catalina.sh","run" ]