# Overview
Travel BiH Demo is a web application that allows users to register, log in, and browse tourist attractions in Bosnia and Herzegovina **after authentication**.
This repository contains both the application code and a complete QA documentation and testing setup created as part of QA learning and practice.

The QA work focuses on validating core application functionality, authentication behavior, protected routes, and API correctness.

## Application Stack

- Backend: Spring Boot (Java)
- Frontend: React (Vite)
- Database: PostgreSQL
- Authentication: JWT
- API Testing: Postman
- Browser: Google Chrome

## QA Scope

The QA process covers the following areas:
- User registration and login
- JWT-based authentication
- Access control for protected routes
- Viewing attractions list
- Viewing attraction details
- API response validation 
- Negative scenarios (unauthorized access, invalid inputs)

Out of scope:
- Performance testing
- Load and stress testing
- Security penetration testing
- UI/UX design validation

### QA Structure

All QA-related artifacts are located in the /qa and /postman folders.

qa/

└── docs/

├── TestPlan.md

├── TestCases.md

└── BugReports.md

postman/

└── TravelBiH_API.postman_collection.json


## Test Plan

- The Test Plan defines:
- testing scope
- test types
- environment
- entry and exit criteria
- expected deliverables

File: qa/docs/TestPlan.md

## Test Cases

Manual test cases were created for the main user flows, including:
- login (valid / invalid scenarios)
- registration validations
- protected route access
- attractions list and details
- error handling

Each test case includes:
- preconditions
- test steps
- expected results

File: qa/docs/TestCases.md

## Bug Reports

Identified issues are documented using a structured bug report format, including:
- environment details
- steps to reproduce
- expected vs actual result
- severity and priority

File: qa/docs/BugReports.md

## API Testing (Postman)

API testing was performed using Postman.

- The Postman collection includes:
- Health check endpoint
- Authentication (login) with JWT token extraction
- Protected API endpoints
- Parameterized GET requests
- Negative authorization tests (401 Unauthorized)

The collection uses:
- environment variables (baseUrl, authToken)
- automated test scripts in the Tests tab
- Collection Runner to execute the full API test flow

Collection file: postman/TravelBiH_API.postman_collection.json

## Test Execution

API tests were executed using Postman Collection Runner, validating:
- correct HTTP status codes
- response structure
- authentication behavior
- access control for protected endpoints

All tests passed successfully after aligning positive and negative test scenarios.

## Notes

This repository represents a QA-focused approach to testing a web application, emphasizing:
- clear test documentation
- reproducible API tests
- validation of both positive and negative scenarios
- realistic QA workflow suitable for an internship-level role

## Author

QA documentation and testing prepared as part of practical QA learning and portfolio development.

## How to Run

### Backend
- Start Spring Boot application
- Default URL: http://localhost:8080
- PostgreSQL database must be running and configured
- Database tables are created via JPA/Hibernate on startup
- Attractions are seeded on startup (DataSeeder)

### Frontend
Frontend URL: http://localhost:5173
```bash
cd frontend
npm install
npm run dev

