package beans;

import BO.User;
import BO.User_handler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * Created by Gurris on 2016-11-03.
 */
@ManagedBean(name="user")
@SessionScoped
public class userBean {
    private String username;
    private DataModel<User> users;
    private String email;
    private String firstname;
    private String lastname;
    private String log;
    private int redirectValue;

    public int getRedirectValue() {
        return redirectValue;
    }

    public void setRedirectValue(int redirectValue) {
        this.redirectValue = redirectValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public userBean() {
        users = new ListDataModel<>(User_handler.getAllUsers());
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public DataModel<User> getUsers(){
        return users;
    }

    public String directButton(int id){
        setRedirectValue(id);
        return "UserPage.xhtml";
    }
    
}
