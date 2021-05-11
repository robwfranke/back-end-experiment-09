package nl.lotrac.bv.exceptions;

public class CustomernameExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomernameExistsException() {
        super();
    }
    public CustomernameExistsException(String message) {super(message);
    }
}
