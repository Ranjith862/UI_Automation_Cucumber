# UI_Automation_Cucumber

Automated testing framework for **OrangeHRM**, focusing on CRUD operations (Verify CFO Name, Add, Read, Edit, and Delete Employee). Designed for accuracy, efficiency, and scalability.

## Key Features
- **Framework**: Cucumber (BDD) with Page Object Model (POM).
- **Tools and Libraries**: Java, WebDriverManager, Extent Reports.
- **Design Patterns**: Singleton Design Pattern for efficient Page Object management.
- **Reusable Utilities**: Automated screenshot capture for failed steps.
- **Configurable Setup**: Managed via `config.properties`.

## Framework
- **Cucumber**: Implements Behavior-Driven Development (BDD) for clear, understandable test cases.
- **Page Object Model (POM)**: Enhances maintainability and readability of test scripts by separating the UI interactions.
- **WebDriverManager**: Handles WebDriver setup and updates automatically, ensuring smooth execution across different browsers.
- **Singleton Pattern**: Used for managing a single instance of Page Objects, optimizing memory usage and improving test performance.

## Highlights
- **Comprehensive Test Coverage**: Ensures reliable CRUD functionality validation.
- **Scalable and Reusable Framework**: Facilitates test case expansion.
- **Efficient Reporting**: Detailed reports generated with Extent Reports.
