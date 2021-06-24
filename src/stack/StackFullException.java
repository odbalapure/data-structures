package stack;

public class StackFullException extends Exception {
    private String message;
    public StackFullException(String message) {
        this.message = message;
    }
}
