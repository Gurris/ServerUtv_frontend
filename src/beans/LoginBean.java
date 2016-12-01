package beans;


import BO.User_handler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Gurris on 2016-11-10.
 */
@ManagedBean(name="login")
@SessionScoped
public class LoginBean implements Serializable{
    public static final String AUTHENTICATION = "userKey";

    private String password;
    private String msg;
    private String username;
    public boolean isLoggedIn = false;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String login(){
        System.out.println("LOGIN!");
        boolean valid = User_handler.login(username, password);
        if(valid){
            isLoggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTHENTICATION, username);
            return "success";
        }else{
            msg = "Incorrect credentials";
            return "failed";
        }
    }

    public String logout() {
        isLoggedIn = false;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTHENTICATION);
        return "/index.xhtml";
    }

}
