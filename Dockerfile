FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copy pom.xml first & download dependencies for better caching
COPY pom.xml .
RUN mvn -q -B dependency:go-offline

# Now copy the rest of the project
COPY . .

# Default command: run the test suite
CMD ["mvn", "-q", "test"]
