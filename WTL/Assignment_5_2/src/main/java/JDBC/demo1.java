package JDBC;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;



/**
 * Servlet implementation class demo1
 */
public class demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newlearningv0","root","wzjHAorNhWrknT2");
			
			PreparedStatement ps=con.prepareStatement("select *from books where sno=?");
			ps.setInt(1,bookid);
			out.print("<table width=75% border=1>");
			out.print("<caption>Book: </caption>");
			
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			
			int totalColumn=rsmd.getColumnCount();
			
			out.print("<tr>");
			for(int i=1;i<=totalColumn;i++)
			{
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			
			
			out.print("<tr>");
			while(rs.next())
			{
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td></tr>");
			}
			out.print("</table>" );
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
