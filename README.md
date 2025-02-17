# Java Test Framework

## 📌 Project Overview
Java Selenium & Cucumber automation framework integrated with TestNG for BDD (Behavior-Driven Development) testing. This project enables writing test cases in Gherkin syntax and mapping them to Java step definitions for UI automation.

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/mytechnotalent/CucumberTraining.git
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
