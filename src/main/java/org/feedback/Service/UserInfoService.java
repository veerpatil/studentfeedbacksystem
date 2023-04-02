package org.feedback.Service;

import org.feedback.entity.UserInfoMaster;
import org.feedback.repository.UserInfoRepository;
import org.feedback.requests.UserRequest;
import org.feedback.requests.UserResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class UserInfoService  {

     @Inject
     UserInfoRepository userInfoRepository;

    /**
     * This method accepts the User Request Object and Saves it to database using the User Info Repository
     * @param userRequest Contains the information about UserName and Password
     * @return User details containing UserID and UserName
     */
    public UserResponse SaveUserInfo(UserRequest userRequest)
    {
        UserInfoMaster userInfoMaster = new UserInfoMaster();
        userInfoMaster.setUserName(userRequest.getUserName());
        userInfoMaster.setPassword(userRequest.getPassWord());
        UserInfoMaster user=  userInfoRepository.saveUserInfo(userInfoMaster);

        UserResponse userResponse = new UserResponse();
        userResponse.setUserID(user.getUserid());
        userResponse.setUserName(user.getUserName());
        return  userResponse;
    }

    /**
     * This Method returns the list of users from the database using User Info Repository
     * @return The information returned includes UserName and User ID
     */
    public List<UserResponse> GetUserInfo()
    {
        List<UserInfoMaster> userInfoMasters = userInfoRepository.getAllUserInfo();
        List<UserResponse> users = new ArrayList<>();
        for (UserInfoMaster user: userInfoMasters
             ) {
            UserResponse userResponse = new UserResponse();
           userResponse.setUserID(user.getUserid());
           userResponse.setUserName(user.getUserName());
           users.add(userResponse);
        }
        return users;
    }

}
