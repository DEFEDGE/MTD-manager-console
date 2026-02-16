## Security Requirements and Controls Implemented

During the development of the test banking application, certain security requirements were considered and implemented based on standard controls, referring, for example, to the security controls outlined by NIST. The following tables summarize the main requirements implemented for each backend endpoint and cross-cutting aspects, along with related NIST controls and a description of the specific implementation.

### Login Endpoint

| Requirement                       | NIST Control   | Control Description                                                 | Implementation                                                      |
| :-------------------------------- | :------------- | :--------------- -------------------------------------------------- | :------------------------------------------------------------------ |
| Password hash authentication      | IA-5           | Secure management of authenticators (e.g., password hashing).       | Use “check_password_hash” and “generate_password_hash” (Werkzeug).  |
| Email format validation           | SI-10          | Input validation to prevent malformed or malicious data.            | Regex “EMAIL_REGEX” to verify email format.                         |
| JWT token generation              | IA-2           | User identification and authentication via secure tokens.           | Tokens signed with “itsdangerous.URLSafeSerializer”.                |
| Secure error handling             | SI-10          | Error handling without exposing sensitive information.              | Redirect with encoded parameters.                                   |

### Register Endpoint

| Requirement             | NIST Control   | Control Description                                           | Implementation                                           |
| :-------------------- - | :------------- | :------------------------------------------------------------ | :------------------------------------------------------- |
| Password hashing        | IA-5           | Secure storage of passwords using hashing functions.          | Use “generate_password_hash” to encrypt passwords.       |
| Email validation        | SI-10          | Input validation to prevent invalid email entries.            | Regex “EMAIL_REGEX” for format checking.                 |
| Email duplicate check   | AC-2           | Account management to prevent duplicate registrations.        | SQL query to check for email existence in the database.  |

### Dashboard Endpoint

| Requirement               | NIST Control   | Control Description                                         | Implementation                                                  |
| :-----------------------  | :------------- | :---------------------------------------------------------- | :---------------------------------------------------- ----------|
| Token Validation          | AC-3           | Restrict access to authorized users only.                   | Verify token using “validate_token” before returning data.      |
| Sensitive Data Protection | SC-28          | Protection of sensitive data during storage/transmission.   | Conversion from decimal to float to avoid serialization errors. |

### Transfer Endpoint

| Requirement                  | NIST Control   | Control Description                                             | Implementation                                                                  |
| :--------------------------- | :------------- | :-------------------------------------------------------------- | :------------------------------------------------------------------------------ |
| Authorization via token      | AC-6           | Limitation of operations to authorized actions only.            | Verification of correspondence between “user_id” in the token and in the form.  |
| Atomic transactions          | SC-24          | Transactional management to ensure data integrity.              | Use of “COMMIT” and “ROLLBACK” for atomic transactions.                         |
| Balance check                | AC-3           | Control of information flow to prevent unauthorized operations. | SQL query to verify balance before operation.                                   |

### Logout Endpoint

| Requirement         | NIST Control   | Control Description                          | Implementation                                                                            |
| :---------------- - | :------------- | :--------------------------------------------| :---------------------------------------------------------------------------------------- |
| Token invalidation  | AC-12          | Secure termination of user sessions.         | Regeneration of the secret key (“token_serializer”), but previous tokens are not revoked. |

### Cross-cutting Aspects

| Requirement                          | NIST Control  | Control Description                                            | Implementation                                                                                           |
| :----------------------------------- | :------------ | :--------------------------------------------------------------| :------------------------------------------------------------------------------------------------------- |
| Restricted CORS                      | SC-7          | Limitation of allowed origins to prevent cross-domain attacks. | CORS configuration with origins limited to “http://worker1:31566”.                                       |
| Prepared statements                  | SI-10         | Prevention of SQL injection through parameterized queries.     | Use of “cursor.execute” with separate parameters (“%s”).                                                 |
| Backend error logging                | AU-3          | Error logging for forensic analysis.                           | Error logging via “app.logger.error”.                                                                    |
| Advanced input validation (XSS/SQLi) | SI-10         | Input sanitization to prevent XSS and injection.               | Basic sanitization with “sanitize_string”, but fields such as description are not validated against XSS. |
