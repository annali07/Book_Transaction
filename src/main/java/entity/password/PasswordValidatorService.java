package entity.password;

public class PasswordValidatorService implements PasswordValidator {
    @Override
    public boolean validatePassword(String providedPassword, String storedPasswordHash) {
        // Implement hashing of providedPassword and comparison logic
        return providedPassword.equals(storedPasswordHash);
    }
}
