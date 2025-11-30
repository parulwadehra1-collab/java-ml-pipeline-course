FROM eclipse-temurin:17

# Create working directory inside the container
WORKDIR /app

# Copy everything from your repo into /app
COPY . .

# (Optional but recommended) Download dependencies first to reuse cache
RUN mvn -q -B dependency:go-offline

# Run tests when the container is built
RUN mvn -q -e -B test
