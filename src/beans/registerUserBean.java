package beans;

import BO.User;
import BO.User_handler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Gurris on 2016-11-16.
 */
@ManagedBean(name="register")
@SessionScoped
public class registerUserBean {
    private String username;
    private String password1;
    private String password2;
    private String email;
    private String firstname;
    private String lastname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String register(){
        System.out.println("REGISTER");
        System.out.println("----");
        System.out.println(username + " " + password1 + " " + password2);
        System.out.println("----");
        if(!password1.equals(password2))
            return "login.xhtml";

        System.out.println("ss");
        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password1);

        if(User_handler.registerUser(user)){
            System.out.println("SUCCESS FROM USER HANDLER");
            return "index.xhtml"; // change to userpage later
        }else{
            System.out.println("FAIL FROM USER HANDLER");
            return "register.xhtml";
        }


    }

}
