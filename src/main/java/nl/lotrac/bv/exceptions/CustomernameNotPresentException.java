package nl.lotrac.bv.exceptions;

public class CustomernameNotPresentException extends RuntimeException {



    private static final long serialVersionUID = 1L;

    public CustomernameNotPresentException() {
        super();
    }
    public CustomernameNotPresentException(String message) {super(message);
    }
}