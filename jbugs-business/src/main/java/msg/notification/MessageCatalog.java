
package msg.notification;

import msg.exceptions.ExceptionMessage;

/**
 * A catalog of all the Messages thrown from the Notification component.
 *
 * @author Gianina Gaita
 *
 */
public class MessageCatalog {

    /**
     * A message for the case when a user already exists with the same email.
     */
    public static final ExceptionMessage MESSAGE_PARAMS_AND_TYPE_ARE_INCOMPATIBLE
            = new ExceptionMessage("NOTIF-01", "The input message parameters do not correspond to "
            + " the sent message type.");
}
