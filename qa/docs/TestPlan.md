# Test plan - Travel BiH Demo Application

## 1. Introduction
This document describes the testing approach for the Travel BiH demo web application, which allows users to register, log in, and view tourist attractions.

## 2. Scope

### In scope
The following functionalities will be tested:
- User registration
- User login and logout
- JWT-based authentication
- Access to protected routes
- Viewing attractions list
- Viewing attraction details
- API validation and responses

### Out of scope
The following areas will not be tested:
- Performance testing
- Load and stress testing
- Security penetration testing
- UI/UX design validation

## 3. Test types

### Manual Testing
Manual testing will be performed to validate core application functionality such as user registration, login, protected routes, and viewing attractions.

### API Testing
API testing will be performed to validate backend endpoints, request and response data, authentication behavior, and error handling. API tests will be executed manually using Postman and automated using Pytest.

### Automation Testing
Automation testing will be performed for critical application flows using Pytest for API automation and Playwright for end-to-end UI testing.

## 4. Test Environment
- Backend: Spring Boot (Java)
- Frontend: React (Vite)
- Database: PostgreSQL
- Browser: Google Chrome
- API Tools: Postman
- Automation Tools: Pytest, Playwright

## Test Deliverables
The following testing artifacts will be delivered:
- Test Plan document
- Manual Test Cases document
- Postman API collection
- Automated API test scripts (Pytest)
- Automated UI test scripts (Playwright)
- Bug reports (if any)

## 6. Entry and Exit Criteria

### Entry Criteria
- Backend and frontend applications are running
- Test environment is available
- Required test data is prepared

### Exit Criteria
- All planned test cases are executed
- Critical and high severity defects are reported
- Test results are documented