# Bug Reports – Travel BiH Demo Application

## BUG-ATTR-01 Non-existent attraction ID returns 404, but UI message is unclear (optional)

**Environment:**  
Frontend: http://localhost:5173  
Backend: http://localhost:8080

**Precondition:**  
User is logged in (valid JWT token exists in localStorage)

**Steps to Reproduce:**
1. Login with a valid user
2. Open http://localhost:5173/attraction/9999

**Expected Result:**  
UI displays a clear error message (e.g., "Attraction not found") and provides a way back to dashboard.

**Actual Result:**  
The page displays blank content and does not show the error message. Only the back link is visible.

**Evidence:**  
DevTools Network: GET http://localhost:8080/api/attractions/9999 → 404 Not Found  
Response body contains: {"message":"Attraction not found"}

**Severity:** Medium  
**Priority:** Medium
