# **Order Compose Machine (OCM)**

## **Description**

The **Order Compose Machine (OCM)** is a Spring Boot-based service that manages the composition of orders for customers.
This service enables users to place orders, fetch order details, and perform other relevant operations for restaurant
management.

---

## **Table of Contents**

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Repository](#repository)
- [Intro](#intro)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Configuration](#configuration)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

---

## **Getting Started**

These instructions will guide you to set up the service locally for development and testing purposes.

### **Prerequisites**

Ensure you have the following tools installed:

- **Java 17** or higher (the version your application is running on).
- **Maven** or **Gradle** (depending on your build tool).
- **Git** (to clone the repository).
- **Docker** - OPTIONALLY

Check if you have the required tools by running these commands:

```bash
java -version
mvn -v
git --version  
```

### **Repository**

Code is available under [Restaurant](#https://github.com/Januarius93/restaurant) main repo. It is advisable to clone
whole repository

```bash
git clone https://github.com/Januarius93/restaurant.git
```

### **Intro**

The goal of this service is to give ability for user to compose order payload using RestaurantUI (examplary payload)

```json
{
  "orderId": 0,
  "orderItems": [
    {
      "itemName": "strizdrgrdgng",
      "orderItemType": "FROM_MENU",
      "product": {
        "productId": 0,
        "productName": "string",
        "productType": "STARTERS",
        "description": "string",
        "isCustomizable": true
      },
      "quantity": 0,
      "price": 0,
      "specialNoteOrderItem": "string"
    }
  ],
  "orderDetails": {
    "customerData": {
      "customer": {
        "name": "string",
        "surname": "string",
        "email": "string",
        "phone": 0
      },
      "address": {
        "city": "string",
        "streetName": "string",
        "streetNumber": 0,
        "homeNumber": 0,
        "postalCode": "string"
      }
    },
    "orderId": 0,
    "orderDate": "2025-03-23",
    "orderStatus": "PENDING"
  },
  "paymentInfo": {
    "price": {
      "id": 0,
      "totalAmount": 0
    },
    "discount": {
      "id": 0,
      "totalAmount": 0
    },
    "taxation": {
      "id": 0,
      "totalAmount": 0
    },
    "paymentMethod": "DEBIT_CARD",
    "paymentStatus": "PENDING"
  },
  "restaurantSpecificDetails": {
    "tableNumber": 0,
    "staffMember": {},
    "restaurant": {}
  },
  "orderSpecialNote": "string"
}
```

Its main part is list of **orderItems** where products list are fed form **MenuSvc**

```json
    {
      "itemName": "wdwd",
      "orderItemType": "FROM_MENU",
      "product": {
        "productId": 0,
        "productName": "string",
        "productType": "STARTERS",
        "description": "string",
        "isCustomizable": true
      },
      "quantity": 0,
      "price": 0,
      "specialNoteOrderItem": "string"
    }
  ```

## **Installation**

If everything from **Prerequisites** is set up correctly , OCM service needs to be build firstly by maven

Navigate to folder with pom.xml and run maven command

``` bash
cd order_compose_machine/pom.xml
mvn clean install
```

OPTIONALLY use Intellij maven tab with **mvn clean install**

## **Running the Application**

Start OCM spring boot app

``` bash
mvn spring-boot:run
```

You can also run app in container by running scripts in **.scripts** directory(it requires to have *
*/target/order-compose-machine-0.0.1-SNAPSHOT.jar**)

**OPTIONALLY** just navigate to **src/main/java/org/restaurant/order_compose_machine/OrderComposeMachineApplication.java
** and click run in Intellij

## **API Documentation**

When the app is up and running just navigate to
[OCM Api docs](#http://localhost:9090/v3/api-docs)










