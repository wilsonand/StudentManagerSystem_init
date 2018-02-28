package action;
import com.opensymphony.xwork2.ActionSupport;
public class toaction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
     public String execute()  
        {  
            if("admin".equals(this.username) && "123456".equals(this.password)) 
            	{System.out.print("success");
                return "success";  }
            else  
                return "fail";  
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
