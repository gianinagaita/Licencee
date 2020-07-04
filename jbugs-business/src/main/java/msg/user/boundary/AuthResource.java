package msg.user.boundary;

import msg.user.entity.dto.UserLoginDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Document me.
 *
 * @author Gianina Gaita
 */
@Stateless
@Path("/auth")
public class AuthResource {
    @EJB
    UserFacade userFacade;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(UserLoginDTO userLoginDTO) {
        return Response.ok(userFacade.authenticateUser(userLoginDTO)).build();
    }


}
