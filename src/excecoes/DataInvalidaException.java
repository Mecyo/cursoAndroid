package excecoes;

/**
 *
 * @author Emerson Santos
 */
public class DataInvalidaException extends Exception{
    private final String msg;
    public DataInvalidaException(String msg, String cause) {
        super(msg, new Exception(cause));
        this.msg = msg;
    }
 
    public String getMsg() {
        return msg;
    }
}
