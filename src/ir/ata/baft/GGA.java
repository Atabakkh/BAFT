package ir.ata.baft;

import ir.baft.databasehelper.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class GGA extends HttpServlet {

	static DatabaseConnection dbConn;
	static Connection conn;

	public GGA() {
//		dbConn = new DatabaseConnection();
//		conn = dbConn.mySqlConnection();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		String name = request.getParameter("gene");
		if (name != null) {
			List<String> protrinRS = new ArrayList<String>();
			protrinRS = compareNeighbourSequences(name);
			request.setAttribute("proteinData", protrinRS);
		}
		System.out.print("Done");
	}
	
	private List<String> compareNeighbourSequences(String GeneName) {

		String query = "select gs.sequence FROM fitness f inner JOIN gene_sequence gs on f.fitness = gs.gene where f.`name` = '" + GeneName + "' ";

		List<String> compareList= new ArrayList<String>();
		try {
			ResultSet rs = conn.createStatement().executeQuery(query);
			
			while (rs.next()) {
				compareList.add(rs.getString(1));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compareList;
	}

	
}