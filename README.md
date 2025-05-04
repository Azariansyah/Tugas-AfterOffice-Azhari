# Final Project: Automated Testing with Selenium Cucumber

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.java.com/)
[![Selenium](https://img.shields.io/badge/Selenium-4.28.0-green)](https://selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-yellowgreen)](https://cucumber.io/)

Repository ini berisi implementasi automated testing untuk web e-commerce menggunakan:
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**
- **Page Object Model**
---
## 📋 Prerequisites

- Java JDK 17+
- Maven 3.8.1+
- Browser:
    - Chrome (v100+)
    - Firefox (v120+)
- WebDriver:
    - [ChromeDriver](https://chromedriver.chromium.org/)
    - [GeckoDriver](https://github.com/mozilla/geckodriver)
---
## 🚀 Installation

1. Clone repository:
   ```bash
   git clone -b Final-Project https://github.com/[username]/[repo-name].git

⚙️ Configuration
1. Atur browser di src/main/resources/GlobalData.properties:
   ```bash
   browser=firefox # atau chrome

2. Pastikan path driver sesuai:
   ```bash
   ChromeDriver: src/main/resources/chromedriver.exe
   GeckoDriver: src/main/resources/geckodriver.exe
---
🧪 Running Tests

Jalankan semua test:
          
    mvn test
Generate report HTML:
   
mvn test -Dcucumber.plugin="html:target/cucumber-report.html"



---
## 🌟 Key Features
1. BDD Approach: Test scenarios ditulis dalam Gherkin (contoh)
2. Multi-Browser Support: Chrome & Firefox
3. Page Object Model: Implementasi POM untuk maintainable code
4. Parallel Testing (Opsional): Dapat dikonfigurasi via TestNG

## 🧩 Test Scenarios

Contoh scenario dalam EndToEndCheckout.feature:

Scenario: Create Order Positive Case
Given Buyer logged to website
When Buyer add product to Cart
And Navigate to cart and checkout
And Fill checkout information
Then Buyer click complete purchase

## 📊 Reports
Laporan test otomatis tersedia di:

* HTML: target/cucumber-report.html
* JSON: target/cucumber-report.json
* XML: target/cucumber-report.xml

<div align="center"> <sub>Created with ❤️ by Azhari iriansyah untuk Final Project Submission After Office Selenium Java 
Batch 2</sub> </div>
