
package msg.exceptions;

/**
 * The Message structure for the {@link BusinessException}.
 *
 * @author Gianina Gaita
 *
 */
public class ExceptionMessage {

    /**
     * The code used for identifying the message. It can be used to identify the error in other systems.
     */
    private String messageCode;

    /**
     * A text message that describes the problems.
     */
    private String message;


    public ExceptionMessage() {
    }

    public ExceptionMessage(final String messageCode, final String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    /**
     * Getter.
     *
     * @return messageCode
     */
    public String getMessageCode() {
        return this.messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * Getter.
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
