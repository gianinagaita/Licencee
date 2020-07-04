package msg.exceptions;

import javax.ejb.ApplicationException;

/**
 * The exception thrown when a Business error happens.
 *
 * @author Gianina Gaita
 */
@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

    /**
     * The message inside the exception.
     */
    private ExceptionMessage exceptionMessage;

    public BusinessException(final ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * Getter.
     *
     * @return exceptionMessage
     */
    public ExceptionMessage getExceptionMessage() {
        return this.exceptionMessage;
    }
}
