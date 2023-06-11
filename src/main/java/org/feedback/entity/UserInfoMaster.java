package org.feedback.entity;


import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
public class UserInfoMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    public Long userid;

    @Column(name = "USERNAME")
   public String userName;

    @Column(name = "PASSWORD")
   public String Password;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
