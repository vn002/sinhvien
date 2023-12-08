package context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
public  static  Connection getConnection()
{
   final String url="jdbc:mysql://localhost:3306/Svien?useUnicode=true&characterEncoding=UTF-8";
   final String user = "root";
   final String password ="anhnam202";
		   
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user,password);
		
		
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	
	
	return null;
}

public static void main(String[] args)
{
	Connection connection = getConnection();
	if(connection != null)
	{
	 System.out.println("Ket noi thanh cong");
	}
	else {
		
		 System.out.println("Ket noi that bai");
	}
}



}