public class InvalidBookException extends Exception
{
    public InvalidBookException(String message) {
        super(message); // Call the parent constructor with the custom message
    }
}