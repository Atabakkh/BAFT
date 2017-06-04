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
public class Replace extends HttpServlet {

	static DatabaseConnection dbConn;
	static Connection conn;

	public Replace() {
		dbConn = new DatabaseConnection();
		conn = dbConn.mySqlConnection();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String name = request.getParameter("gene");
		if (name != null) {
			String protrinRS = new String();
			try {
				protrinRS = loadProteinSequence(name);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("proteinData", protrinRS);
			
			String geneRS = new String();
			try {
				geneRS = loadGeneSequence(name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("geneData", geneRS);
			
			List<String> fitnessRS = loadNeighbourSequences(name);
			request.setAttribute("fitnessData", fitnessRS);
			
			request.getRequestDispatcher("Detection.jsp").forward(request,
					response);
		}

		System.out.print("Done");
	}

	private String loadProteinSequence(String GeneName) throws SQLException {

		String query = "select protein_sequnce from gene_sequence where `name` = '"
				+ GeneName + "' ";

		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String)rs.getObject(0);
	}

	private String loadGeneSequence(String GeneName) throws SQLException {

		String query = "select sequnce from gene_sequence where `name` = '"
				+ GeneName + "' ";

		ResultSet rs = null;
		try {
			rs = conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String)rs.getObject(0);
	}

	private List<String> loadNeighbourSequences(String GeneName) {

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