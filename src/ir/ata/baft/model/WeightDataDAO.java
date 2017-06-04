package ir.ata.baft.model;

import ir.baft.databasehelper.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeightDataDAO {
	
	static DatabaseConnection dbConn;
	static Connection conn;

	public WeightDataDAO() {
		dbConn = new DatabaseConnection();
		conn = dbConn.mySqlConnection();
	}
	
	public List<Weights> getWeightData(){
		List<Weights> myDataList = new ArrayList<Weights>();
		ResultSet resultSet = null;
		Statement statement = null;
		try{
			String name ="TM4SF6";
			String query = "select w.* from mapping m INNER JOIN weights w on m.preferred_name = w.gene_a where `name` LIKE '%"
					+ name + "%' ;";
			ResultSet rs = conn.createStatement().executeQuery(query);
			while(resultSet.next())
			{
				Weights weightData = new Weights();
				weightData.setId(resultSet.getInt("id"));
				weightData.setGeneA(resultSet.getString("gene_a"));
				weightData.setGeneB(resultSet.getString("gene_b"));
				weightData.setWeight(resultSet.getInt("weight"));
					
				myDataList.add(weightData);
			}
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		finally {
			if (resultSet != null) { try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (statement != null) { try { statement.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
			
		}
		return myDataList;
	}

}
