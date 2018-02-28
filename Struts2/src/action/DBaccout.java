package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBaccout {
	private static String dbdriver = "com.mysql.jdbc.Driver";
	private static String dburl = "jdbc:mysql://127.0.0.1:3306/cmxDatabaseName?&useSSL=false";
	private static String username = "root";
	private static String userpassword = "dhj19951018";
	public static Connection conn = null;
	
	private static Connection getConn(String myProjName) {
        Connection conn = null;
        try {
            Class.forName(dbdriver);            
            String myjdbcUrl = dburl.replace("cmxDatabaseName", myProjName);
            //System.out.println("myjdbcurl:"+myjdbcUrl);
            conn = DriverManager.getConnection(myjdbcUrl, username, userpassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
	
	
	private static void closeAll(ResultSet rs, PreparedStatement ps,
            Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn == null)
            return;
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void insert(String ProjName,String sql) {
    	Connection conn = getConn(ProjName);
    	PreparedStatement ps = null;
    	try {
            ps = conn.prepareStatement(sql);
             ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, ps, conn);
        }
    	
    }

}
