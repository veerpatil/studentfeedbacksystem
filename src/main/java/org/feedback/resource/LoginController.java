package org.feedback.resource;


import org.feedback.Service.UserInfoService;
import org.feedback.requests.UserRequest;
import org.feedback.requests.UserResponse;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class LoginController {
    @Inject
    UserInfoService userInfoService;

    @POST()
    @Path("/SaveUserInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response SaveUserLoginInfo(UserRequest userRequest) {
     UserResponse user = userInfoService.SaveUserInfo(userRequest);
        return Response.ok(user).build();
    }


    @GET()
    @Path("/GetUserInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetUserLoginDetails() {
        return Response.ok( userInfoService.GetUserInfo()).build();
    }
}
