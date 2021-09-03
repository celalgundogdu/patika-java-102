package hw6_InsuranceManagementSystem;

public class InvalidAuthenticationException extends Exception{

    public InvalidAuthenticationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Girilen bilgilere ait bir hesap bulunamadı.";
    }
}
