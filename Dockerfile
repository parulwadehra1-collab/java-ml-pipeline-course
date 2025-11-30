# Use a base image that already includes Maven + Temurin JDK 17
FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copy pom.xml first and download dependencies (better caching)
COPY pom.xml .
RUN mvn -q -B dependency:go-offline

# Now copy the rest of the project
COPY . .

# Run tests
RUN mvn -q -e -B test
