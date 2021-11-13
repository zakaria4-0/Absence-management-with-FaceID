package ABC;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import ABC.DBConnection;
import ABC.User;
import ABC.students;

public class UserDAO {
	Connection conn=null;
	public UserDAO() {
		conn=DBConnection.ConnectDB();
	}
	public int saveUser(User user)  {
		int set=0;
		
		try {
			//insert register data to database
			String query="insert into faceidreg(NAME,EMAIL,PASSWORD)values(?,?,?)";
			
			PreparedStatement pt=conn.prepareStatement(query);
			pt.setString(1, user.getName());
	           pt.setString(2, user.getEmail());
	           pt.setString(3, user.getPassword());
	           
	            set=pt.executeUpdate();
	           
	          
	           
	           
	           
	           
		}catch(SQLException e){
            e.printStackTrace();
	}
		
		return set;

}
	public boolean Userver(User user) {
		try {
			String query="select * from faceidreg where NAME=? and EMAIL=? ";
			
			   PreparedStatement pt=conn.prepareStatement(query);
			   pt.setString(1, user.getName());
	           pt.setString(2, user.getEmail());
	           
	           
               ResultSet set=pt.executeQuery();
	           
	           if(set.next()) {
	        	   return true;
	           }
			
		}catch(SQLException e){
            e.printStackTrace();
	}
		
		
		
		return false;
	}
	public int userlog(User user) {
	
		ResultSet set=null;
		
		String query="select * from faceidreg where NAME=? and PASSWORD=?";
		
		try {
			PreparedStatement pt=conn.prepareStatement(query);
			
			pt.setString(1, user.getName());
			pt.setString(2, user.getPassword());
			
			set=pt.executeQuery();
			
			if(set.next()) {
				String email=set.getString("email");
				int n=email.length();
				String c =email.substring(n - 12);
				
				if (c.equals(".p@esith.net")) {
	        	   return 1;
					
				}
				if(c.equals(".s@esith.net")) {
					return 2;
					
				}
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 3;
	}
public boolean updatepass(User user) {
		
		
		
		
		String sql1="update faceidreg set PASSWORD=? where NAME=? and EMAIL=?";
		
		try {
			PreparedStatement pt1=conn.prepareStatement(sql1);
			
			pt1.setString(1, user.getPassword());
			pt1.setString(2, user.getName());
			pt1.setString(3, user.getEmail());
			
			
			if(pt1.executeUpdate()!=0) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

public  List<students> selectIMS3(students st) {
	List<students> users = new ArrayList<>();
	
	try {
		String query1="update IMS3 set option=? , module=?";
		
		PreparedStatement pt1=conn.prepareStatement(query1);
		pt1.setString(1, st.getOption());
		pt1.setString(2, st.getModule());
		pt1.executeUpdate();
		String q1="select * from IMS3";
		PreparedStatement qt1=conn.prepareStatement(q1);
		ResultSet qs1=qt1.executeQuery();
		while(qs1.next()) {
			String q2="insert into students(ID,name,module,date)values(?,?,?,?)";
			PreparedStatement pt2=conn.prepareStatement(q2);
			    pt2.setInt(1, qs1.getInt("ID"));
				pt2.setString(2, qs1.getString("name"));
				pt2.setString(3, qs1.getString("module"));
				pt2.setString(4, qs1.getString("date"));
				pt2.executeUpdate();
			
			int id = qs1.getInt("ID");
			String name = qs1.getString("name");
			String option = qs1.getString("option");
			String module = qs1.getString("module");
			String date = qs1.getString("date");
			users.add(new students(id, name, option, module,date));
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return users;
}
public  List<students> selectIMS2(students st) {
	List<students> users = new ArrayList<>();
	
	try {
		String query1="update IMS2 set option=? , module=?";
		
		PreparedStatement pt1=conn.prepareStatement(query1);
		pt1.setString(1, st.getOption());
		pt1.setString(2, st.getModule());
		pt1.executeUpdate();
		String q1="select * from IMS2";
		PreparedStatement qt1=conn.prepareStatement(q1);
		ResultSet qs1=qt1.executeQuery();
		while(qs1.next()) {
			
			String q2="insert into students(ID,name,module,date)values(?,?,?,?)";
			PreparedStatement pt2=conn.prepareStatement(q2);
			    pt2.setInt(1, qs1.getInt("ID"));
				pt2.setString(2, qs1.getString("name"));
				pt2.setString(3, qs1.getString("module"));
				pt2.setString(4, qs1.getString("date"));
				pt2.executeUpdate();
			
			int id = qs1.getInt("ID");
			String name = qs1.getString("name");
			String option = qs1.getString("option");
			String module = qs1.getString("module");
			String date = qs1.getString("date");
			users.add(new students(id, name, option, module,date));
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return users;
}

public  List<students> selectIMS1(students st) {
	List<students> users = new ArrayList<>();
	
	try {
		String query1="update IMS1 set option=? , module=?";
		
		PreparedStatement pt1=conn.prepareStatement(query1);
		pt1.setString(1, st.getOption());
		pt1.setString(2, st.getModule());
		pt1.executeUpdate();

		String q1="select * from IMS1";
		PreparedStatement qt1=conn.prepareStatement(q1);
		ResultSet qs1=qt1.executeQuery();
		
		
		
		while(qs1.next()) {
			
			String q2="insert into students(ID,name,module,date)values(?,?,?,?)";
		PreparedStatement pt2=conn.prepareStatement(q2);
		    pt2.setInt(1, qs1.getInt("ID"));
			pt2.setString(2, qs1.getString("name"));
			pt2.setString(3, qs1.getString("module"));
			pt2.setString(4, qs1.getString("date"));
			pt2.executeUpdate();
			
			int id = qs1.getInt("ID");
			String name = qs1.getString("name");
			String option = qs1.getString("option");
			String module = qs1.getString("module");
			String date = qs1.getString("date");
			users.add(new students(id, name, option, module,date));
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return users;
}

public  List<students> Consulter(User us) {
	List<students> users = new ArrayList<>();
	
	try {
		
		String q1="select * from students where name=?";
		PreparedStatement qt1=conn.prepareStatement(q1);
		qt1.setString(1,us.getName());
		ResultSet qs1=qt1.executeQuery();
		while(qs1.next()) {
			
			
			
			int id = qs1.getInt("ID");
			String name = qs1.getString("name");
			String module = qs1.getString("module");
			String date = qs1.getString("date");
			users.add(new students(id, name,  module,date));
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return users;
}




}
