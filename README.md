```markdown
# 🚀 Spring Kafka Integration

A basic Spring Boot application demonstrating Kafka integration for message production and consumption.

Simplify your Kafka workflows with Spring!

![License](https://img.shields.io/github/license/askur87/spring-kafka)
![GitHub stars](https://img.shields.io/github/stars/askur87/spring-kafka?style=social)
![GitHub forks](https://img.shields.io/github/forks/askur87/spring-kafka?style=social)
![GitHub issues](https://img.shields.io/github/issues/askur87/spring-kafka)
![GitHub pull requests](https://img.shields.io/github/issues-pr/askur87/spring-kafka)
![GitHub last commit](https://img.shields.io/github/last-commit/askur87/spring-kafka)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka)

## 📋 Table of Contents

- [About](#about)
- [Features](#features)
- [Demo](#demo)
- [Quick Start](#quick-start)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [Testing](#testing)
- [Deployment](#deployment)
- [FAQ](#faq)
- [License](#license)
- [Support](#support)
- [Acknowledgments](#acknowledgments)

## About

This project provides a straightforward example of integrating Apache Kafka with a Spring Boot application. It demonstrates how to produce and consume messages using Spring Kafka, simplifying the process of building event-driven microservices or real-time data pipelines.

The application is designed for developers who are new to Kafka and Spring or those seeking a minimal working example to build upon. It addresses the common challenge of setting up Kafka producers and consumers within a Spring Boot environment. The key technologies used include Spring Boot, Spring Kafka, and Apache Kafka. This project offers a quick and easy way to understand the fundamental concepts and configurations required for Kafka integration in Spring applications.

The unique selling point of this project is its simplicity and focus on core functionality, making it an excellent starting point for more complex Kafka-based systems. It avoids unnecessary complexity and provides a clear and concise implementation of basic Kafka operations.

## ✨ Features

- 🎯 **Message Production**: Easily send messages to Kafka topics using Spring Kafka's `KafkaTemplate`.
- 👂 **Message Consumption**: Configure listeners to consume messages from Kafka topics.
- ⚙️ **Configuration**: Simple configuration using Spring Boot's application properties.
- ⚡ **Asynchronous Communication**: Leverage Kafka's asynchronous messaging capabilities for improved performance.
- 🛠️ **Easy Integration**: Seamless integration with other Spring Boot components and services.
- 📚 **Clear Examples**: Well-documented code and examples to get you started quickly.

## 🎬 Demo

This project doesn't have a live demo, but here are some example screenshots of a similar application to give you an idea of how it works:

### Screenshots
![Kafka Producer](screenshots/kafka-producer.png)
*Example of a Kafka producer sending messages*

![Kafka Consumer](screenshots/kafka-consumer.png)
*Example of a Kafka consumer receiving and processing messages*

## 🚀 Quick Start

Clone and run in 3 steps:

```bash
git clone https://github.com/askur87/spring-kafka.git
cd spring-kafka
./mvnw spring-boot:run
```

You'll need a running Kafka instance.  See the Installation section for details.

## 📦 Installation

### Prerequisites

- Java 17+
- Maven
- A running Kafka instance (e.g., using Docker)

### Option 1: Running with Maven

1.  Clone the repository:

    ```bash
    git clone https://github.com/askur87/spring-kafka.git
    ```

2.  Navigate to the project directory:

    ```bash
    cd spring-kafka
    ```

3.  Run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

### Option 2: Using Docker Compose

1.  Create a `docker-compose.yml` file (example):

    ```yaml
    version: '3.7'
    services:
      zookeeper:
        image: confluentinc/cp-zookeeper:latest
        environment:
          ZOOKEEPER_CLIENT_PORT: 2181
          ZOOKEEPER_TICK_TIME: 2000
        ports:
          - 2181:2181

      kafka:
        image: confluentinc/cp-kafka:latest
        depends_on:
          - zookeeper
        ports:
          - 9092:9092
        environment:
          KAFKA_BROKER_ID: 1
          KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
          KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:9092
          KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
          KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
          KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    ```

2.  Run Docker Compose:

    ```bash
    docker-compose up -d
    ```

3.  Clone the Spring Kafka repository (if you haven't already) and run the application as described in Option 1.

## 💻 Usage

After starting the application, it will automatically start producing and consuming messages to/from the configured Kafka topic.

### Sending Messages

The application includes an example producer that sends messages to a Kafka topic. You can customize the message content and topic by modifying the code in the `KafkaProducer` class.

### Receiving Messages

The application includes an example consumer that listens for messages on a Kafka topic.  Received messages are logged to the console. You can customize the consumer behavior by modifying the code in the `KafkaConsumer` class.

## ⚙️ Configuration

### Application Properties

The application is configured using Spring Boot's `application.properties` file. You can configure the Kafka broker address, topic name, and other settings in this file.

Example `application.properties`:

```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.template.default-topic=my-topic
```

### Environment Variables

You can also configure the application using environment variables. For example:

```env
SPRING_KAFKA_BOOTSTRAP_SERVERS=localhost:9092
SPRING_KAFKA_CONSUMER_GROUP_ID=my-group
SPRING_KAFKA_TEMPLATE_DEFAULT_TOPIC=my-topic
```

## 📁 Project Structure

```
spring-kafka/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── KafkaApplication.java        # Main application class
│   │   │       ├── KafkaConsumer.java           # Kafka consumer
│   │   │       └── KafkaProducer.java           # Kafka producer
│   │   └── resources/
│   │       └── application.properties         # Application configuration
│   └── test/
│       └── java/
│           └── com/example/
│               └── KafkaApplicationTests.java   # Example tests
├── pom.xml                                     # Maven project file
├── README.md                                  # Project documentation
└── screenshots/                                # Screenshots for README
```

## 🤝 Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) (create a CONTRIBUTING.md file if you plan on having contributions) for details.

### Quick Contribution Steps

1.  🍴 Fork the repository
2.  🌟 Create your feature branch (`git checkout -b feature/AmazingFeature`)
3.  ✅ Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4.  📤 Push to the branch (`git push origin feature/AmazingFeature`)
5.  🔃 Open a Pull Request

## Testing

The project includes basic unit tests. You can run the tests using Maven:

```bash
./mvnw test
```

## Deployment

This Spring Boot application can be deployed to various platforms, including:

-   **Local Machine**: Run directly using Maven or an IDE.
-   **Cloud Platforms**: Deploy to platforms like AWS, Azure, or Google Cloud.
-   **Docker**: Build a Docker image and deploy it to a container orchestration platform like Kubernetes.

## FAQ

**Q: How do I configure the Kafka broker address?**

A: You can configure the Kafka broker address using the `spring.kafka.bootstrap-servers` property in the `application.properties` file or the `SPRING_KAFKA_BOOTSTRAP_SERVERS` environment variable.

**Q: How do I change the Kafka topic?**

A: You can change the Kafka topic using the `spring.kafka.template.default-topic` property in the `application.properties` file or the `SPRING_KAFKA_TEMPLATE_DEFAULT_TOPIC` environment variable.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### License Summary

-   ✅ Commercial use
-   ✅ Modification
-   ✅ Distribution
-   ✅ Private use
-   ❌ Liability
-   ❌ Warranty

## 💬 Support

-   🐛 **Issues**: [GitHub Issues](https://github.com/askur87/spring-kafka/issues)

## 🙏 Acknowledgments

-   📚 **Libraries used**:
    -   [Spring Kafka](https://spring.io/projects/spring-kafka) - Provides integration between Spring and Apache Kafka.
    -   [Spring Boot](https://spring.io/projects/spring-boot) - Simplifies the development of Spring-based applications.
```
