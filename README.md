# Easy Pay

Mobile payment system such as Samsung Pay, Apple Pay. It consists of MSA and is based on Spring.
As a project for learning, we learn MSA through Mobile payment.

---

### MSA Structure

- Membership: To manage users who are signing up for and using your Easy-Pay service.
  - User registration and management.
- Banking: To manage external bank interactions, including money transfers, fee and contract.
  - Initiating and managing money transfers between accounts.
  - Handling interactions with external banking systems.
  - Managing the status and details of linked bank accounts, such as account validation and expiration dates.
  - Calculating and applying transfer fees.
  - Checking the status of bank accounts to ensure they are active and valid.

---

### Command
```
./gradlew docker
docker compose up --build
```

---

### MEMO
- In the hexagonal architecture, The `Adapter` package works for the external request and the `Application` package deals with the business logic for the inner system.
- Test Link:
  - Membership: http://localhost:8081/swagger-ui/index.html
  - Baking: http://localhost:8082/swagger-ui/index.html
- DB Console: localhost:8080/h2-console/
- Keyword:
  - MSA
  - Hexagonal Architecture (Ports and Adapters)
