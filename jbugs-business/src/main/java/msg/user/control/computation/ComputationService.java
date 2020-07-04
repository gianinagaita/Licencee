package msg.user.control.computation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Document me.
 *
 * @author Gianina Gaita
 */
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Document me.
 *
 * @author Gianina Gaita
 */
@Stateless
public class ComputationService {

    @Inject
    private ComputationProcessor mProcessor;

    public void sendMail( String emailAdrres, String firstName,  String userName,  String password) {
        mProcessor.sendEmail(emailAdrres,firstName,userName,password);
    }
}