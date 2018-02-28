package action;
import com.opensymphony.xwork2.ActionSupport;
public class UserLogup extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    
    private String getsql() {
    	String sql;
    	sql="insert accoutnum values('"+this.username+"','"+this.password+"')";
    	return sql;
    }
     public String execute()  
        {  
            DBaccout.insert("accout", getsql());
            
                return "success";  
    
        }  
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    

}
