package duolayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Library.Model.Library;

public class DuolayerLib {
	String username="root";
	String pwd="Raju@123";
	String url="jdbc:mysql://localhost:3306/libaray_management";
	String inqry="insert into libaray_man_system(name,author,price,quantity)values(?,?,?,?)";
	String upqry="update libaray_man_system set name=?,author=?,price=?,quantity=? where id=?";
	public String insertLib(Library abc){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn=DriverManager.getConnection(url,username,pwd);
			PreparedStatement pr=conn.prepareStatement(inqry);
			pr.setString(1, abc.getName());
			pr.setString(2, abc.getAuthor());
			pr.setInt(3, abc.getPrice());
			pr.setInt(4, abc.getQuantity());
			int result=pr.executeUpdate();
			conn.close();
			pr.close();
			if(result>0) {
				return "values inserted sucessfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "something went wrong";
		}
	public String updateLib(Library abc) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection(url,username,pwd);
			PreparedStatement pr=con.prepareStatement(upqry);
			pr.setString(1, abc.getName());
			pr.setString(2, abc.getAuthor());
			pr.setInt(3, abc.getPrice());
			pr.setInt(4, abc.getQuantity());
			pr.setInt(5, abc.getId());
			int res=pr.executeUpdate();
			if(res>0) {
				return "updated sucessfully";
			}
//			con.close();
//			pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "something went wrong";
		
	}

}
