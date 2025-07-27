# Patient Management API

## Overview
REST API built with **Spring Boot 3.5.4** for patient registration.  
It allows registering patients with their basic information and a photo of their ID, validates the input, and stores the data in a **PostgreSQL** database.  
After a successful registration, a confirmation email is sent asynchronously using **Gmail SMTP** to avoid blocking the application.

The system is designed with future expansion in mind, including SMS notifications.

---

## Key Features
- Patient registration with:
    - First and last name
    - Email address
    - Phone number
    - Document photo upload
- Data validation using Spring Validation.
- Persistence with **Spring Data JPA**.
- Asynchronous confirmation emails using **Gmail SMTP**.
- Architecture ready for future SMS notification support.
- Fully reproducible environment with **Docker** and **Docker Compose**.

---

## Technologies
- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **PostgreSQL**
- **JavaMailSender** (configured with Gmail SMTP)
- **Docker** / **Docker Compose**

---

## Getting Started

### Requirements
- **Docker** and **Docker Compose** installed.
- A Gmail account with an **App Password** enabled (for sending confirmation emails).

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/challengeLightIt/patient-management.git
    cd patient-management
    ```

2. Configure environment variables:

Create an application.properties file in the project root (make sure to add application.properties to your .gitignore

    ```
    # Gmail SMTP credentials
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=yourmail@gmail.com
    spring.mail.password=yourpassword
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    app.mail.from = yourmail@gmail.com

    # Database credentials
    SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/patient_registration
    SPRING_DATASOURCE_USERNAME=postgres
    SPRING_DATASOURCE_PASSWORD=root

    # Cloudinary credentials
    CLOUDINARY_CLOUD_NAME=yourcloudname
    CLOUDINARY_API_KEY=yourapikey
    CLOUDINARY_API_SECRET=your_cloudinary_api_secret
    ```

3. Build and run the containers:

    ```bash
    docker-compose up --build
    ```

4. The API will be accessible at:

    ```
    http://localhost:8080
    ```

---


---

## API Usage

### Endpoint: Register a Patient

**POST** `/api/patients`

Example with `curl`:
```bash
curl --location --request POST 'http://localhost:8080/api/patients' \
--form 'patient={
  "name": "Juan",
  "surname": "Perez",
  "email": "juan@gmail.com",
  "phoneNumber": "123456789"
};type=application/json' \
--form 'documentPhoto=@/path/to/document.jpg'

{
  "id": 1,
  "name": "Juan",
  "surname": "Perez",
  "email": "juan@gmail.com",
  "phoneNumber": "123456789",
  "documentPicture": "https://..."
}
