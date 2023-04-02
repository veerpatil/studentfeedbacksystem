package org.feedback.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.feedback.entity.UserInfoMaster;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class to That holds method to perform crud operations
 */
@ApplicationScoped
public class UserInfoRepository implements PanacheRepository<UserInfoMaster> {


    /**
     * This method saves the user information in to database and returns the saved info
     * @param userInfoMaster
     * @return Returns the Saved User Information
     */
    @Transactional
    public UserInfoMaster saveUserInfo(UserInfoMaster userInfoMaster)
    {
        persist(userInfoMaster);
        return  userInfoMaster;
    }


    /**
     *
     * @return This method returns all users login information
     */
    public List<UserInfoMaster> getAllUserInfo()
    {
        List<UserInfoMaster> userInfoMasters = findAll().list();

        return  userInfoMasters.stream().toList();
    }

}
