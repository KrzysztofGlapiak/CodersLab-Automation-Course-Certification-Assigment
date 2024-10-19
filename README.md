# CodersLab Automation Course Certification Assignment

This repository contains automated test scripts created as part of the CodersLab Automation Course certification assignment. The tests cover various functionalities of a sample web application, including user registration, address management, and item purchase.

## Project Structure

The project follows a typical Maven-based Java project structure:

CodersLab-Automation-Course-Certification-Assigment/
```plaintext
CodersLab-Automation-Course-Certification-Assignment/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── Adding_Address_for_user.java
│   │   │   ├── Item_Purchase.java
│   │   └── resources/
│   │       └── features/
│   │           └── Examples.feature
├── pom.xml
└── README.md

- `src/test/java/`: Contains the Java test classes with Selenium WebDriver test scripts.
- `src/test/resources/features/`: Contains Cucumber feature files written in Gherkin syntax describing the test scenarios.

## Technologies Used

- **Java**: The programming language used for writing test scripts.
- **Selenium WebDriver**: For browser automation.
- **Cucumber**: For behavior-driven development (BDD) with Gherkin syntax.
- **JUnit**: For managing and running test cases.
- **Maven**: For project build and dependency management.
- **Gherkin**: To define test scenarios in a human-readable format.

## Prerequisites

To run the tests locally, ensure that the following software is installed:

- Java Development Kit (JDK) 8 or higher
- Maven 3.x
- Web browser (e.g., Chrome or Firefox)
- ChromeDriver or GeckoDriver for Selenium (make sure the driver is compatible with your browser version)
- IDE (optional, but recommended for editing the code, e.g., IntelliJ IDEA or Eclipse)

## Installation and Setup

1. Clone this repository:
   git clone https://github.com/yourusername/CodersLab-Automation-Course-Certification-Assigment.git

2. Navigate to the project directory:
   cd CodersLab-Automation-Course-Certification-Assigment

3. Install dependencies:
   mvn clean install

4. Make sure the appropriate WebDriver (e.g., ChromeDriver or GeckoDriver) is available in your system PATH.

## Running the Tests

1. To run all tests, execute:
   mvn test

2. For running specific test scenarios, use:
   mvn test -Dcucumber.options="--tags @YourTag"

3. To generate a Cucumber report after running the tests:
   mvn clean test -Dcucumber.options="--plugin html:target/cucumber-html-report"

## Test Scenarios

### Adding Address for a User

- Tests the functionality of adding a new address for a registered user.
- Validates form fields and ensures data is saved correctly.

### Item Purchase

- Simulates the process of purchasing an item.
- Checks for successful checkout and order confirmation.

### Examples.feature

- Contains Gherkin scenarios describing different test cases to be executed.

## Continuous Integration

Integrating with CI tools like Jenkins or GitHub Actions can automate the running of tests on every code change.

## Troubleshooting

- Common Issues: Ensure that the WebDriver version matches your browser's version.
- Maven Build Issues: Run mvn clean followed by mvn install to resolve potential build conflicts.

## Future Enhancements

- Add more comprehensive test cases covering edge cases.
- Integrate continuous integration (CI) with GitHub Actions or Jenkins.
- Implement parallel test execution for faster test runs.
- Expand the framework to support multiple browsers and mobile testing.
