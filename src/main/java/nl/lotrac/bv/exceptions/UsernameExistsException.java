package nl.lotrac.bv.exceptions;

public class UsernameExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameExistsException() {
        super();
    }
    public UsernameExistsException(String message) {super(message);
    }
//System.out.println("UsernameExistsException");
}
