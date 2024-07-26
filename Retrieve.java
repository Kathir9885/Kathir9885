package rhd1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Records")
public class Retrieve extends HttpServlet {

	//public static void main(String[] args) {
		public void doPost(HttpServletRequest req,HttpServletResponse res)  
				throws ServletException,IOException  
				{  
				res.setContentType("text/html");  
				PrintWriter pw=res.getWriter();	
      String Contact=req.getParameter("Relation_Number");
      try {
  		// TODO Auto-generated method stub
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rhd1","root","root");
     Statement stmt=con.createStatement();
     String sql="select *  from rhd2";
     ResultSet rs=stmt.executeQuery(sql);
     while(rs.next()) 
     {
  	  int A= rs.getInt("slno");
  	  
   		  String names= rs.getString("rhd_names");
  		  
  	  String location= rs.getString("address");
  		  
    String Phone_Number= rs.getString("Phone_number");
    System.out.println(A +"\t" +names +"\t"+location+"\t"+Phone_Number);
  		  
     }
     
     rs.close();
     stmt.close();
    
    con.close();
  	}
  				
  catch (Exception e)
  	{
  	  System.out.println(e);
  	}
  	pw.close();
  	{
  }
				}
}
  	