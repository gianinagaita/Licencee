package msg.notification.control;

import msg.notification.boundary.NotificationResource;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.TimerTask;

/**
 * Document me.
 *
 * @author Gianina Gaita
 */
@Stateless
public class PrintTask extends TimerTask {
    @EJB
    NotificationControl notificationControl;

    public void run() {
        notificationControl.deleteNotificationsPeriodically();

    }


}