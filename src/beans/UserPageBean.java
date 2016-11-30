package beans;

import BO.Log;
import BO.User;
import BO.Message;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Gustaf on 2016-11-24.
 */
@ManagedBean(name="userPage")
@SessionScoped
public class UserPageBean {

    private User user;
    public User getUser() {
        return user;
    }
    public ArrayList<Log> logs;
    private String submitMsg;

    public String getSubmitMsg() {
        return submitMsg;
    }

    public void setSubmitMsg(String submitMsg) {
        this.submitMsg = submitMsg;
    }

    public ArrayList<Log> getLogs() {
        return null;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public void init(int uId){

    }

    public void submitLogMsg(){

    }

}
