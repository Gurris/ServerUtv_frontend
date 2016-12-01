package beans;


import BO.Log;
import BO.Log_handler;
import BO.User;
import BO.User_handler;

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
        ArrayList<Log> log = Log_handler.getUserLogFromUId(user.getId());
        if(log != null)
            setLogs(log);
        return logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public void init(int uId){
        user = User_handler.getUserById(uId);
    }

    public void submitLogMsg(){
        System.out.println("awdagsrg in bean");
        if(submitMsg != null){
            if(submitMsg.length() <= 254){
                User toUser = User_handler.findUserByName(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userKey").toString());
                Log_handler.addToUserLog(user.getId(), toUser.getId(), submitMsg);
            }else{
                System.out.println("Message is too long!");
            }
        }
    }

}
