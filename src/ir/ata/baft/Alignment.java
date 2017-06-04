package ir.ata.baft;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ir.baft.databasehelper.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class Alignment extends HttpServlet {

	static DatabaseConnection dbConn;
	static Connection conn;
	private static final long serialVersionUID = 1L;

	public Alignment() {
		dbConn = new DatabaseConnection();
		conn = dbConn.mySqlConnection();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		// PrintWriter out = response.getWriter();

		String geneName = request.getParameter("geneName");
		String similarity = request.getParameter("similarity");
		String nonSimilarity = request.getParameter("nonSimilarity");
		String gap = request.getParameter("gap");
		if(!geneName.isEmpty() && !similarity.isEmpty() &&  !nonSimilarity.isEmpty() && !gap.isEmpty()){
			List<Article> articles = align(geneName, similarity, nonSimilarity, gap);
			System.out.print("Done");
			// response.sendRedirect("Graph.jsp?searchGene=" + name.toString());
	
	//		Article[] articles = new Article[] { new Article(1, "Article one"),
	//				new Article(2, "Article two") };
			request.setAttribute("articles", articles);
					
	//		request.setAttribute("jsonServlet", cells);
	
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/AlignmentResult.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("required", "false");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Alignment.jsp");
			dispatcher.forward(request, response);
			System.out.print("Value(s) are required");
		}

	}

	private String[][] findFitness(String geneName) {
		OptimizedSearch os = new OptimizedSearch();
		return os.greedySearch(geneName);
	}

	private String getSequence(String geneName) throws SQLException {
		String query = "select sequence from gene_sequence where `gene` = '"
				+ geneName + "' limit 1 ";
		ResultSet rs = conn.createStatement().executeQuery(query);
		rs.first();
		return (rs.getString(1) != null) ? rs.getString(1) : "";
	}

	private List<Article> align(String geneName, String similarity,
			String nonSimilarity, String _gap) {

		//JSON object
		JSONObject json = new JSONObject();
		List<Article> articles = new ArrayList<Article>();
		
		// Lists That Holds Alignments
		List<Character> SeqAlign1 = new ArrayList<Character>();
		List<Character> SeqAlign2 = new ArrayList<Character>();
		String[][] network = findFitness(geneName);
		String Seq1 = null;
		try {
			Seq1 = getSequence(geneName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sim = Integer.valueOf(similarity);
		int nonSim = Integer.valueOf(nonSimilarity);
		int gap = Integer.valueOf(_gap);
		if (Seq1 != null) {
			for (int i = 0; i < network.length; i++) {
				if (network[i][1] != null) {
					String Seq2 = null;
					try {
						Seq2 = getSequence(network[i][1]);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (Seq2 != null) {
						Cell[][] Matrix = DynamicAlignment.initalization(Seq1, Seq2,
								sim, nonSim, gap);

						// Trace back matrix from end cell that contains max
						// score {
						// from end cell [SeqAlign2.Count - 1,SeqAlign1.Count -
						// 1]
						// to initial cell [0,0]}
						
											
						///  DON'T LEAVE IT LIKE THAT IT SHOULD BE UNCOMMENTED.
						
//						DynamicAlignment.Traceback_Step(Matrix, Seq1, Seq2,
//								SeqAlign1, SeqAlign2);

						
						
						
						// // Display Result of alignments
						// //note the trace in matrix done in reverse manner
						// (trace
						// back)
						// for (int j = SeqAlign1.Count - 1; j >= 0; j--)
						// {
						// this.richTextBox1.AppendText(SeqAlign1[j].ToString());
						//
						// }
						// this.richTextBox1.AppendText('\n'.ToString());
						// for (int f = SeqAlign2.Count - 1; f >= 0; f--)
						// {
						// this.richTextBox1.AppendText(SeqAlign2[f].ToString());
						// }
						
						
						
						int M = Seq1.length();//Length+1//-AAA
				        int N = Seq2.length();//Length+1//-AAA
						for (int j = 1; j < N; j++)
				        {
				            for (int k = 1; k < M; k++)
				            {
				            	Article ar=new Article();
								 ar.setId(k);
								 ar.setTitle(String.valueOf(Matrix[j][k].getCellScore()));
								 articles.add(ar);
				            }
				            if(j==20)break;
				        }
						
						
//						json.put("articles", articles);
						
//
//						 int total=0;
//						 						
//						 total=Matrix.length;
//						
//						 //put total no records in json object with total key
//						 //json.put("total",total);
//						
//						 //put arraylist in json with rows key
//						// json.put("rows", Matrix);
//						 
//						 
//						 
//							 // //Create List to store all objects
//							  
//							
//							  System.out.print(Matrix[1][1]);
//													 
//							  //put total no records in json object with total key
//							  json.put("total",total);
//							 //
//						
////							  while(rs.next())
////							  {
////							 
////							  //create every time a new object to store rows data
////							  World wd=new World();
////							  wd.setCode(rs.getString("code"));
////							  wd.setContinent(rs.getString("continent"));
////							  wd.setName(rs.getString("name"));
////							  wd.setRegion(rs.getString("region"));
////							  worlds.add(wd);
////							  }
//							 //
//							 // //put arraylist in json with rows key
//							  json.put("rows", worlds);
						 
					}
				}
			}
		}
//		return json;
		return articles;
	}

	// public void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	//
	// response.setContentType("text/html");
	// // PrintWriter out = response.getWriter();
	// //
	// // //Get page and rows value from JSP page
	// // int page=Integer.parseInt(request.getParameter("page"));
	// // int rows=Integer.parseInt(request.getParameter("rows"));
	// //
	// // //Get Search box values
	// // String
	// cname=request.getParameter("cname")==null?"":request.getParameter("cname");
	// // String
	// region=request.getParameter("region")==null?"":request.getParameter("region");
	// //
	// // //Calculate offset value
	// // int offset = (page-1)*rows;
	// //
	// // //Define Database Connection & ResultSet
	// // DBUtil db=new DBUtil();
	// // Connection con=db.getConnect();
	// // ResultSet rs=null;
	// // PreparedStatement ps=null,ps1=null;
	// //
	// // //JSON object
	// // JSONObject json = new JSONObject();
	// //
	// // //Create List to store all objects
	// // List<World> worlds = new ArrayList<World>();
	// //
	// // //total Records
	// // int total=0;
	// //
	// // //where clause query for search
	// // String where =
	// "continent like '%"+cname+"%' and region like '%"+region+"%'";
	// //
	// // //your SQL query
	// // String
	// sql="select * from country where "+where+" limit "+offset+","+rows;
	// //
	// // //SQL query to count total no of records
	// // String count = "select count(*) from country where "+where;
	// //
	// // //Execute all queries here
	// // try {
	// // ps=con.prepareStatement(count);
	// // ResultSet rs2=ps.executeQuery();
	// // if(rs2.next())
	// // { total=rs2.getInt(1);}
	// //
	// // //put total no records in json object with total key
	// // json.put("total",total);
	// //
	// // ps1=con.prepareStatement(sql);
	// // rs=ps1.executeQuery();
	// //
	// // while(rs.next())
	// // {
	// //
	// // //create every time a new object to store rows data
	// // World wd=new World();
	// // wd.setCode(rs.getString("code"));
	// // wd.setContinent(rs.getString("continent"));
	// // wd.setName(rs.getString("name"));
	// // wd.setRegion(rs.getString("region"));
	// // worlds.add(wd);
	// // }
	// //
	// // //put arraylist in json with rows key
	// // json.put("rows", worlds);
	// //
	// // } catch (SQLException e1) {
	// // // TODO Auto-generated catch block
	// // e1.printStackTrace();
	// // }
	// // finally {
	// // try {if(rs!=null)rs.close();}catch(SQLException e)
	// {e.printStackTrace();}
	// // try {if(ps!=null)ps.close();}catch(SQLException e)
	// {e.printStackTrace();}
	// // try {if(ps1!=null)ps1.close();}catch(SQLException e)
	// {e.printStackTrace();}
	// // try {if(con!=null)con.close();}catch(SQLException e)
	// {e.printStackTrace();}}
	// //
	// // //return json data to JSP page
	// // out.print(json);
	// //
	// // out.flush();
	// // out.close();
	// }
}