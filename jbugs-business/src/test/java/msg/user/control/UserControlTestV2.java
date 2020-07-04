
package msg.user.control;

import msg.exceptions.BusinessException;
import msg.exceptions.BusinessWebAppException;
import msg.notification.boundary.NotificationFacade;
import msg.notification.entity.NotificationType;
import msg.notification.entity.dto.NotificationInputDTO;
import msg.user.entity.dao.UserDAO;
import msg.user.entity.dto.UserConverter;
import msg.user.entity.dto.UserInputDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test class for UserControl.
 *
 * @author Gianina Gaita
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControlTestV2 {

    @InjectMocks
    UserControl userControl;

    @Mock
    UserDAO userDao;

    @Mock
    UserConverter userConverter;

    @Mock
    NotificationFacade notificationFacade;

    @Before
    public void setUp() {

        try {
            FieldSetter.setField(this.userControl,
                    UserControl.class.getDeclaredField("notificationFacade"),
                    this.notificationFacade);
        } catch (final NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    @Test(expected = BusinessWebAppException.class)
    public void testCreateUserNotificationSent() {
        UserInputDTO user = createTestInputDTO();

        ArgumentCaptor<NotificationType> sentNotificationType = ArgumentCaptor.forClass(NotificationType.class);
        Mockito.when(userConverter.convertInputDTOtoEntity(Mockito.any())).thenCallRealMethod();
        Mockito.when(userDao.existsEmail(user.getEmail())).thenReturn(false);
        Mockito.doNothing().when(notificationFacade).createNotification(sentNotificationType.capture(), Mockito.any());

        this.userControl.createUser(user);
        Assert.assertEquals(sentNotificationType.getValue(), NotificationType.WELCOME_NEW_USER);
    }

    @Test(expected = BusinessWebAppException.class)
    public void testCreateUserWithSuccess() {
        UserInputDTO user = createTestInputDTO();

        Mockito.when(userConverter.convertInputDTOtoEntity(Mockito.any())).thenCallRealMethod();
        Mockito.when(userDao.existsEmail(user.getEmail())).thenReturn(false);
        //Mockito.doNothing().when(notificationFacade).createNotification(Mockito.any(), Mockito.any());

        this.userControl.createUser(user);
    }

    @Test(expected = BusinessWebAppException.class)
    public void testCreateUserWhenEmailAddressAlreadyExists() {
        UserInputDTO user = createTestInputDTO();

        Mockito.when(userDao.existsEmail(user.getEmail())).thenReturn(true);
        //Mockito.doNothing().when(notificationFacade).createNotification(Mockito.any(), Mockito.any());

        this.userControl.createUser(user);
    }



    private UserInputDTO createTestInputDTO() {
        UserInputDTO user = new UserInputDTO();
        user.setLastName("Pop");
        user.setFirstName("Andrei");
        user.setEmail("axasde@yahoo.com");
        user.setMobileNumber("0700000000");
        return user;
    }

}
