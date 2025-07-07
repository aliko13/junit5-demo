# JUnit 5 Demo Project with Maven

This project demonstrates how to use **JUnit 5** with **Maven** to test Java applications.  
It includes examples of:
- Basic unit tests
- Assertions (assertEquals, assertTrue, assertThrows, etc.)
- @BeforeEach, @AfterEach, @Nested, @DisplayName
- Parameterized tests using `@ParameterizedTest`, `@CsvSource`, `@ValueSource`
- Streams, exceptions, service logic testing

## Technologies

- **Java 17**
- **Maven**
- **JUnit 5 (Jupiter API + Engine + Params)**
- **Assertions & Parameterized Testing**

### Key Concepts
| Concept                                                | File                      |
| ------------------------------------------------------ | ------------------------- |
| `@Test`, `@BeforeEach`, `@DisplayName`                 | All test files            |
| `@Nested`                                              | `StudentTest`, `BookTest` |
| `@ParameterizedTest` with `@ValueSource`, `@CsvSource` | `StudentTest`             |
| Exception Handling with `assertThrows`                 | All                       |
| Business logic with Streams                            | All services              |
| Domain-driven design                                   | Model classes             |

## 🛠 Project Structure

junit5-demo/
-> src/
 -> main/java/com/example/model/ → domain classes (Student, Book, Order)
 -> main/java/com/example/service/ → service classes (business logic)
 -> test/java/com/example/test/ → JUnit 5 test classes
-> pom.xml → Maven config file
-> .gitignore → Ignore unnecessary files
-> README.md → Project documentation
---

## 🚀 Getting Started

### 1. Prerequisites

- Java 17+
- Maven 3.8+

> Check with:
```bash
java -version
mvn -v
```

### 2. Clone the Repository
```bash
git clone https://github.com/aliko13/junit5-demo.git
cd junit5-demo
```

### 3. Build and test
```bash
mvn clean test
```
