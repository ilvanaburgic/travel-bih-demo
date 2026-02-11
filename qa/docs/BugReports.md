# Bug Reports – Travel BiH Demo Application

## BUG-ATTR-01 Missing error message on attraction details (404)

**Environment:**  
Frontend: http://localhost:5173  
Backend: http://localhost:8080

**Steps to Reproduce:**
1. Login
2. Open http://localhost:5173/attraction/9999

**Expected Result:**  
An error message is displayed (e.g., "Attraction not found") and user can navigate back.

**Actual Result:**  
Page shows no error message (blank content / only back link).

**Evidence:**  
DevTools Network: GET http://localhost:8080/api/attractions/9999 → 401 Unauthorized

**Severity:** Medium  
**Priority:** Medium
