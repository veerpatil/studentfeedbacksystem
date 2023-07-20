package org.feedback.ServiceImplementaion;

import org.feedback.Service.UserInfoService;
import org.feedback.entity.UserInfoMaster;
import org.feedback.repository.UserInfoRepository;
import org.feedback.requests.UserRequest;
import org.feedback.requests.UserResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class UserInfoServiceImpl implements UserInfoService {

     @Inject
     UserInfoRepository userInfoRepository;


    /**
     * This method accepts the User Request Object and Saves it to database using the User Info Repository
     * @param userRequest Contains the information about UserName and Password
     * @return User details containing UserID and UserName
     */
    @Override
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
    @Override
    public List<UserResponse> GetUserInfo()
    {
        List<UserResponse> users = new ArrayList<>();
        try {
            List<UserInfoMaster> userInfoMasters = userInfoRepository.getAllUserInfo();

            for (UserInfoMaster user : userInfoMasters
            ) {
                UserResponse userResponse = new UserResponse();
                userResponse.setUserID(user.getUserid());
                userResponse.setUserName(user.getUserName());
                users.add(userResponse);
            }

            FileWriter fileWriter = new FileWriter("users.txt",false);
            for (UserInfoMaster user : userInfoMasters)
            {
                fileWriter.write(user.getUserName() + System.lineSeparator());
            }
            fileWriter.close();
        }catch (Exception ex)
        {

        }

        return users;
    }

    @Override
    public boolean DeleteUserInfo(long userID) {
      return userInfoRepository.deleteUserInfo(userID);
    }

    @Override
    public long DeleteUser(String userName) {
        return userInfoRepository.deleteUser(userName);
    }

    @Override
    public List<UserResponse> getAllUsersByNameID(String userName, Long Id) {

        List<UserResponse> users = new ArrayList<>();

        List<UserInfoMaster> userInfoMasters = userInfoRepository.getAllUsers(userName,Id);

        for (UserInfoMaster user : userInfoMasters
        ) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserID(user.getUserid());
            userResponse.setUserName(user.getUserName());
            users.add(userResponse);
        }

        return users;
    }

}
