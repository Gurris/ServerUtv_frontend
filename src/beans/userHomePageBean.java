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
 * Created by Gurris on 2016-11-17.
 */
@ManagedBean(name="homePage")
@SessionScoped
public class userHomePageBean {
    private User user;
    private ArrayList<Log> logs;
    private String submitMsg;

    public String getSubmitMsg() {
        return submitMsg;
    }

    public void setSubmitMsg(String submitMsg) {
        this.submitMsg = submitMsg;
    }

    public int getId() {
        return user.getId();
    }

    public void setId(int id) {
        user.setId(id);
    }

    public String getUsername() {
        System.out.println("osihefohuisefgouhisfge");
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginBean.AUTHENTICATION).toString());
        user = User_handler.findUserByName(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginBean.AUTHENTICATION).toString());
        setId(user.getId());
        setUsername(user.getUsername());

        System.out.println("awdoihafhsrg");

        if(user.getLog() != null){
            setLogs(user.getLog());
        }

        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
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
    public void submitLogMsg(){
        if(submitMsg != null){
            if(submitMsg.length() <= 254){
                Log_handler.addToUserLog(user.getId(), user.getId(), submitMsg);
            }else{
                System.out.println("Message is too long!");
            }
        }
    }
}
