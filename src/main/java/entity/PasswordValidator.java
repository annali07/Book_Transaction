package entity;

public interface PasswordValidator {
        /**
         * Validates a provided password against a stored password hash based on defined security rules.
         *
         * @param providedPassword The password provided by the user for validation.
         * @param storedPasswordHash The hash of the password stored, typically retrieved from a database, against which to validate the provided password.
         * @return true if the provided password matches the stored password hash according to the validation rules; false otherwise.
         */
        boolean validatePassword(String providedPassword, String storedPasswordHash);
}