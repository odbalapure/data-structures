package stack;

public class StackEmptyException extends Exception {
    private String message;
    public StackEmptyException(String message) {
        this.message = message;
    }
}
