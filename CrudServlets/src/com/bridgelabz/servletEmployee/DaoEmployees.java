package com.bridgelabz.servletEmployee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEmployees {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection conn=null;
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEES","root","root");
		return conn;
	}
	
		public static int save(PojoEmployee infoEmp){  
        int status=0;  
        try{  
            Connection con=DaoEmployees.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into employees values(?,?,?,?,?,?)");  
            ps.setString(1,infoEmp.getName());  
            ps.setString(2,infoEmp.getMail());  
            ps.setString(3,infoEmp.getCountry());  
            ps.setString(4,infoEmp.getId());  
            ps.setString(5,infoEmp.getAge());
            ps.setString(6,infoEmp.getNumber());                
            status=ps.executeUpdate();
//            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	  public static int update(PojoEmployee e) throws SQLException, ClassNotFoundException{  
	        int status=0;  
	        Connection con=DaoEmployees.getConnection();  
            PreparedStatement ps=con.prepareStatement( "update employees set name=?,mail=?,country=?,id=?,age=?,number=? where id=?");
            ps.setString(1,e.getName());  
            ps.setString(2,e.getMail());  
            ps.setString(3,e.getCountry());  
            ps.setString(4,e.getId());  
            ps.setString(5,e.getAge());
            ps.setString(6,e.getNumber());            
            status=ps.executeUpdate();           
            con.close(); 
            return status;
	        
	  }
	  
	  public static int delete(String id) throws SQLException, ClassNotFoundException{  
	        int status=0;  
	        Connection con=DaoEmployees.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from employees where id=?");
	        ps.setString(1,id);  
            status=ps.executeUpdate();       
            con.close();
        	return status;
	  }
	  
	  public static PojoEmployee getEmployeeById(String id) throws SQLException, ClassNotFoundException
	  {
		  PojoEmployee pojoEmp=new PojoEmployee();
		  Connection con=DaoEmployees.getConnection();  
          PreparedStatement ps=con.prepareStatement("select * from employees where id=?");  
          ps.setString(1,id);  
          ResultSet rs=ps.executeQuery(); 
          while(rs.next())
          {
        	  pojoEmp.setName(rs.getString(1));
        	  pojoEmp.setMail(rs.getString(2));
        	  pojoEmp.setCountry(rs.getString(3));
        	  pojoEmp.setId(rs.getString(4));
        	  pojoEmp.setAge(rs.getString(5));
        	  pojoEmp.setNumber(rs.getString(6));
          }
		  return pojoEmp;
	  }
	  
	  public static List<PojoEmployee> getAllEmployees() throws ClassNotFoundException, SQLException
	  {
		  List<PojoEmployee> list=new ArrayList<PojoEmployee>(); 
		  Connection con=DaoEmployees.getConnection();  
          PreparedStatement ps=con.prepareStatement("select * from employees");  
          ResultSet rs=ps.executeQuery();  
          while(rs.next()){  
        	  PojoEmployee pojoEmp=new PojoEmployee();
        	  pojoEmp.setName(rs.getString(1));
        	  pojoEmp.setMail(rs.getString(2));
        	  pojoEmp.setCountry(rs.getString(3));
        	  pojoEmp.setId(rs.getString(4));
        	  pojoEmp.setAge(rs.getString(5));
        	  pojoEmp.setNumber(rs.getString(6));
        	  list.add(pojoEmp);
          
          }
		  return list;
	  }


}
