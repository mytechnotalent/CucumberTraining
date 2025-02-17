# CucumberTraining Project

## 📌 Project Overview
CucumberTraining is a **Selenium & Cucumber** automation framework integrated with **TestNG** for BDD (Behavior-Driven Development) testing. This project enables writing test cases in **Gherkin syntax** and mapping them to Java step definitions for UI automation.

## 📁 Project Structure
```
CucumberTraining/
 ├── src/test/java
 │   ├── features/             # Stores feature files (Gherkin syntax)
 │   │   ├── login.feature     # Defines login test case
 │   ├── stepDefinitions/      # Implements step definitions for feature files
 │   │   ├── LoginSteps.java   # Maps feature steps to Java methods
 │   ├── runners/              # Runs the tests
 │   │   ├── TestRunner.java   # Triggers Cucumber tests
 │   ├── utils/                # Contains reusable code (setup, teardown)
 │   │   ├── BaseTest.java     # WebDriver setup and teardown
 ├── pom.xml                   # Maven dependencies and configurations
 ├── README.md                 # Project documentation
 ├── .gitignore                # Files to ignore in Git
```
## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone git@github.com:mytechnotalent/CucumberTraining.git
cd CucumberTraining
```
### 2️⃣ Install Dependencies
Ensure **Maven** is installed, then run:
```bash
mvn clean install
```
### 3️⃣ Run Tests
To execute Cucumber tests:
```bash
mvn test
```
### 4️⃣ Generate Reports
```bash
mvn verify
```
Reports will be generated in `target/cucumber-reports.html`.

## 🛠 Dependencies
This project uses:
- **Java 21**
- **Maven**
- **Selenium WebDriver**
- **Cucumber** (cucumber-java, cucumber-testng)
- **TestNG**
- **WebDriverManager** (for automatic driver management)

## 📌 Feature Example (Gherkin Syntax)
```cucumber
Feature: Login functionality
  Scenario: User logs in with valid credentials
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be redirected to the homepage
```
## 📝 Running Individual Tests
Run a single feature file:
```bash
mvn test -Dcucumber.features=src/test/resources/features/login.feature
```
Run tests by **tag**:
```bash
mvn test -Dcucumber.options="--tags @SmokeTest"
```
## 🔥 Contributors
- **Kevin Thomas** - Creator & Maintainer

## 📜 License
This project is licensed under the **Apache License**.
