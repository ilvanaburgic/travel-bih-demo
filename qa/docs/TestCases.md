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


