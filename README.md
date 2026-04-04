# java-bootstrap

I put together this repo to serve as a starting point for what I want in a personal Java project:
- Java 21
- Gradle 8.10.2
- JUnit 5 and AssertJ
- Spotless for formatting
- Error Prone for static analysis
- JaCoCo test coverage
- CI checks

## Quick Start

Compile the app:

```bash
./gradlew classes
```

Run the sample program:

```bash
java -cp build/classes/java/main me.graceteng.HelloWorld
```

Expected output:

```text
Hello World!
```

Run the test suite:

```bash
./gradlew test
```

## Common Commands

Build the project:

```bash
./gradlew build
```

Run formatting checks:

```bash
./gradlew spotlessCheck
```

Generate a JaCoCo coverage report:

```bash
./gradlew jacocoTestReport
```
Test coverage reports go in `build/reports/jacoco/test/`.

## CI

GitHub Actions runs the following checks on pushes and pull requests to `main`:
- wrapper validation
- Java 21 setup
- `spotlessCheck`
- `build`
- `jacocoTestReport`
