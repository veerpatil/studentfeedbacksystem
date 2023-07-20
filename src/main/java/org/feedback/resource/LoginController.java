package org.feedback.resource;
import org.feedback.Service.UserInfoService;
import org.feedback.requests.UserDeleteResponse;
import org.feedback.requests.UserRequest;
import org.feedback.requests.UserResponse;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;


@Path("student-feedback-system/")
public class LoginController {



    @Inject
    UserInfoService userInfoService;



    @POST()
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response SaveUserLoginInfo(UserRequest userRequest) {
     UserResponse user = userInfoService.SaveUserInfo(userRequest);
     return Response.ok(user).build();

    }


    @GET()
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetUserLoginDetails() {
        return Response.ok( userInfoService.GetUserInfo()).build();

    }

    @DELETE()
    @Path("user")
    @Produces(MediaType.TEXT_PLAIN)

    public Response DeleteUserInfo(@QueryParam("id") long userID)
    {
       boolean status=   userInfoService.DeleteUserInfo(userID);
       Response.ResponseBuilder response;
       if(status)
       {
          return Response.status(200).entity( "User is Deleted Successfully: "+ userID).build();
       }
       else
       {
        return Response.status(404).entity( "User Not found"+ userID).build();
       }

    }


    @DELETE()
    @Path("user/{user}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response DeleteUser(@PathParam("user") String userID)
    {
        long status=   userInfoService.DeleteUser(userID);
        UserDeleteResponse userDeleteResponse =  new UserDeleteResponse();
        Response response;
        userDeleteResponse.setUserName(userID);
        if(status >0)
        {
            userDeleteResponse.setMessage("User deleted successfully: "+ userID);
            return Response.ok(userDeleteResponse).build();
        }
        else
        {
            userDeleteResponse.setMessage("User Not fund: "+ userID);
          return   Response.status(404).entity(userDeleteResponse).build();
        }


    }

    @GET
    @Path("usernameid")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByIDName(@DefaultValue("") @QueryParam("userName") String userName, @DefaultValue("0") @QueryParam("id") Long id)
    {
            return Response.ok(userInfoService.getAllUsersByNameID(userName,id)).build();
    }




}
