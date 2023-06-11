package org.feedback.Service;

import org.feedback.requests.UserRequest;
import org.feedback.requests.UserResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;


@ApplicationScoped
public interface UserInfoService {

    UserResponse SaveUserInfo(UserRequest userRequest);

    List<UserResponse> GetUserInfo();

    boolean DeleteUserInfo(long userID);

    long DeleteUser(String userName);

}
