`# Test Cases - Travel BiH Demo Application

## Authentication Login

### TC-LOGIN-01 Valid Login

**Precondition**
User exists in the system

**Steps**
1. Open login page
2. Enter valid email
3. Enter valid password
4. Click Login button

**Expected Result**
User is redirected to dashboard and attractions list is displayed

### TC-LOGIN-02 Invalid password

**Precondition:**  
User exists in the system

**Steps:**
1. Open login page
2. Enter valid email
3. Enter invalid password
4. Click Login button

**Expected Result:**  
Error message is displayed and user remains on login page

### TC-LOGIN-03 Invalid email

**Precondition:**  
User exists in the system

**Steps:**
1. Open login page
2. Enter invalid email
3. Enter valid password
4. Click Login button

**Expected Result:**  
Error message is displayed and user remains on login page

### TC-LOGIN-04 Empty fields

**Precondition:**  
None

**Steps:**
1. Open login page
2. Leave email field empty
3. Leave password field empty
4. Click Login button

**Expected Result:**  
Validation message is displayed and login is not performed

## Authentication – Registration

### TC-REG-01 Valid registration

**Precondition:**  
Email does not exist in the system

**Steps:**
1. Open registration page
2. Enter valid email
3. Enter valid password
4. Click Register button

**Expected Result:**  
User is successfully registered and redirected to dashboard


### TC-REG-02 Duplicate email registration

**Precondition:**  
User with the same email already exists

**Steps:**
1. Open registration page
2. Enter existing email
3. Enter valid password
4. Click Register button

**Expected Result:**  
Error message is displayed indicating email already exists

### TC-REG-03 Invalid email format

**Precondition:**  
Email does not exist in the system

**Steps:**
1. Open registration page
2. Enter email without @ symbol
3. Enter valid password
4. Click Register button

**Expected Result:**  
Validation error message is displayed indicating invalid email format

### TC-REG-04 Password less than 8 characters

**Precondition:**  
Email does not exist in the system

**Steps:**
1. Open registration page
2. Enter valid email
3. Enter password with less than 8 characters
4. Click Register button

**Expected Result:**  
Validation error message is displayed indicating password length requirement

## Authentication – Protected Routes (JWT)

### TC-AUTH-01 Access dashboard without token

**Precondition:**  
User is logged out (no token in browser)

**Steps:**
1. Open browser in a new/incognito window
2. Try to open /dashboard directly (paste URL in address bar)

**Expected Result:**  
User is redirected to login page and dashboard is not accessible

### TC-AUTH-02 Access attraction details without token

**Precondition:**  
User is logged out (no token in browser)

**Steps:**
1. Open browser in a new/incognito window
2. Try to open /attraction/37 directly (paste URL in address bar)

**Expected Result:**  
User is redirected to login page and attraction details are not accessible

### TC-AUTH-03 Access protected pages with valid token

**Precondition:**  
User is logged in (valid token exists)

**Steps:**
1. Login with valid credentials
2. Open /dashboard
3. Open an attraction details page (click any card)

**Expected Result:**  
Protected pages are accessible and data is displayed successfully

### TC-AUTH-04 Logout clears session and blocks protected pages

**Precondition:**  
User is logged in

**Steps:**
1. Click Logout button
2. Try to open /dashboard directly

**Expected Result:**  
User is redirected to login page and cannot access protected pages after logout

## Attractions – List (Dashboard)

### TC-ATTR-01 View attractions list after login

**Precondition:**  
User is logged in

**Steps:**
1. Login with valid credentials
2. Open dashboard page

**Expected Result:**  
Attractions list is displayed with cards (category, name, city)

### TC-ATTR-02 Open attraction details from list

**Precondition:**  
User is logged in and attractions list is displayed

**Steps:**
1. On dashboard, click on any attraction card

**Expected Result:**  
User is navigated to attraction details page and selected attraction information is displayed

### TC-ATTR-03 Attractions list not accessible without login

**Precondition:**  
User is logged out (no token)

**Steps:**
1. Try to open /dashboard directly

**Expected Result:**  
User is redirected to login page

### TC-ATTR-04 Attraction details show correct content

**Precondition:**  
User is logged in

**Steps:**
1. Open dashboard
2. Click on a specific attraction card
3. Verify the details page content

**Expected Result:**  
Details page displays correct:
- category
- attraction name
- city
- description

## Attractions – Error Handling

### TC-ATTR-05 Non-existent attraction ID returns error page/message

**Precondition:**  
User is logged in

**Steps:**
1. Manually open /attraction/9999 in the browser address bar

**Expected Result:**  
Error message is displayed (e.g., "Attraction not found") and user can navigate back to dashboard

### TC-ATTR-06 Expired/invalid token blocks attractions endpoint (UI behavior)

**Precondition:**  
Token is missing or invalid

**Steps:**
1. Delete token from browser storage (localStorage) OR use incognito window
2. Open /dashboard

**Expected Result:**  
User is redirected to login page and protected content is not shown
`