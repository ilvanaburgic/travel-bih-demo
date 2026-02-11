# Test Cases - Travel BiH Demo Application

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

