package ir.ata.baft;

import ir.ata.baft.GEXF.core.Edge;
import ir.ata.baft.GEXF.core.EdgeType;
import ir.ata.baft.GEXF.core.Gexf;
import ir.ata.baft.GEXF.core.Graph;
import ir.ata.baft.GEXF.core.IntervalType;
import ir.ata.baft.GEXF.core.Mode;
import ir.ata.baft.GEXF.core.Node;
import ir.ata.baft.GEXF.core.data.Attribute;
import ir.ata.baft.GEXF.core.data.AttributeClass;
import ir.ata.baft.GEXF.core.data.AttributeList;
import ir.ata.baft.GEXF.core.data.AttributeType;
import ir.ata.baft.GEXF.core.dynamic.Spell;
import ir.ata.baft.GEXF.core.dynamic.TimeFormat;
import ir.ata.baft.GEXF.core.impl.GexfImpl;
import ir.ata.baft.GEXF.core.impl.SpellImpl;
import ir.ata.baft.GEXF.core.impl.StaxGraphWriter;
import ir.ata.baft.GEXF.core.impl.data.AttributeListImpl;
import ir.baft.databasehelper.DatabaseConnection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Search extends HttpServlet {

	static DatabaseConnection dbConn;
	static Connection conn;

	public Search() {
		dbConn = new DatabaseConnection();
		conn = dbConn.mySqlConnection();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		// PrintWriter out = response.getWriter();

		String name = request.getParameter("searchGene");

		createGEXFManual(name);
		System.out.print("Done");
		response.sendRedirect("Graph.jsp?searchGene=" + name.toString());

	}

	public void createGEXFManual(String name) {

		boolean isFirstNode = false;
		if (name != null) {
			String query = "select w.* from mapping m INNER JOIN weights w on m.preferred_name = w.gene_a where `name` = '"
					+ name + "' ";
			// String query =
			// "select w.* from mapping m INNER JOIN weights w on m.preferred_name = w.gene_a where `name` LIKE '%"
			// + name + "%'";
			try {
				// createGEXF();
				ResultSet rs = conn.createStatement()
						.executeQuery(query);

				// File f = new File("C:/servlet/" + name + ".gexf");
				// if (!f.exists()) {
				
				String absoluteUrl = getServletContext().getRealPath(
						"graphs/" + name + ".gexf");
				System.out.print(absoluteUrl);
				File f=new File(absoluteUrl);
				f.delete();
				FileWriter writer = new FileWriter(absoluteUrl, false);

				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
				writer.write("<gexf xmlns=\"http://www.gexf.net/1.1draft\" version=\"1.2\" xmlns:viz=\"http://www.gexf.net/1.1draft/viz\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.gexf.net/1.1draft http://www.gexf.net/1.1draft/gexf.xsd\">\n");

				writer.write("<meta lastmodifieddate=\"2011-09-05\">\n");
				writer.write("<creator>Gephi 0.8</creator>\n");
				writer.write("<description></description>\n");
				writer.write("</meta>");

				writer.write("<graph defaultedgetype=\"directed\" timeformat=\"double\" mode=\"dynamic\">\n");
				writer.write("<attributes class=\"node\" mode=\"static\">\n");

				writer.write("<attribute id=\"modularity_class\" title=\"Modularity Class\" type=\"String\">\n");
				writer.write("<default>0</default>\n");
				writer.write("</attribute>\n");
				writer.write("</attributes>\n");

				writer.write("<nodes>\n");

				while (rs.next()) {
					if (!isFirstNode) {
						writer.write("<node id=\"" + rs.getString(2)
								+ "\" label=\"" + rs.getString(2) + "\" >\n");
						writer.write("<attvalues>\n");
						writer.write("<attvalue for=\"modularity_class\" value=\"1\"></attvalue>\n");
						writer.write("</attvalues>\n");
						writer.write("<viz:size value=\"50\"></viz:size>\n");
						writer.write("<viz:position x=\"200.44444444444\" y=\"150.14285714286\"></viz:position>\n");
						writer.write("<viz:color r=\"255\" g=\"82\" b=\"158\"></viz:color>\n");
						writer.write("</node>\n");
						isFirstNode = true;
					}
					writer.write("<node id=\"" + rs.getString(3)
							+ "\" label=\"" + rs.getString(3) + "\" >\n");
					writer.write("<attvalues>\n");
					writer.write("<attvalue for=\"modularity_class\" value=\""
							+ rs.getRow() / 2 + "\"></attvalue>\n");
					writer.write("</attvalues>\n");
					writer.write("<viz:size value=\"" + randomInt(10, 70)
							+ "\"></viz:size>\n");
					writer.write("<viz:position x=\""
							+ randomDouble(-30.0f, 355.0f) + "\" y=\""
							+ randomDouble(-30.0f, 355.0f)
							+ "\" ></viz:position>\n");
					writer.write("<viz:color r=\"55\" g=\"112\" b=\"158\"></viz:color>\n");
					writer.write("</node>\n");

				}

				writer.write("</nodes>\n");
				rs.beforeFirst();
				writer.write("<edges>\n");

				while (rs.next()) {
					writer.write("<edge id=\"" + rs.getRow() + "\" source=\""
							+ rs.getString(2) + "\" target=\""
							+ rs.getString(3) + "\" weight=\""
							+ rs.getString(4) + "\" >\n");

					writer.write("<attvalues>\n");
					writer.write("<attvalue for=\"weight\" value=\""
							+ rs.getString(4) + "\"></attvalue>\n");
					writer.write("</attvalues>\n");
					writer.write("</edge>\n");
				}

				writer.write("</edges>\n");
				writer.write("</graph>\n");
				writer.write("</gexf>\n");

				writer.flush();
				writer.close();
				// }
				// writer.write(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4));
				conn.close();
				System.out.println("Disconnected from database");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void createGEXF() throws IOException {

		Gexf gexf = new GexfImpl();
		Calendar date = Calendar.getInstance();

		gexf.getMetadata().setLastModified(date.getTime())
				.setCreator("Gephi.org").setDescription("A Web network");

		Graph graph = gexf.getGraph();
		graph.setDefaultEdgeType(EdgeType.UNDIRECTED).setMode(Mode.DYNAMIC)
				.setTimeType(TimeFormat.XSDDATETIME);

		AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
		graph.getAttributeLists().add(attrList);

		Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING,
				"url");
		Attribute attIndegree = attrList.createAttribute("1",
				AttributeType.FLOAT, "indegree");
		Attribute attFrog = attrList.createAttribute("2",
				AttributeType.BOOLEAN, "frog").setDefaultValue("true");

		/** Node Gephi */
		Node gephi = graph.createNode("0");
		gephi.setLabel("Gephi").getAttributeValues()
				.addValue(attUrl, "http://gephi.org")
				.addValue(attIndegree, "1");

		Spell spellGephi = new SpellImpl();
		date.set(2012, 3, 28, 16, 10, 0);
		date.set(Calendar.MILLISECOND, 0);
		spellGephi.setStartValue(date.getTime());
		gephi.getSpells().add(spellGephi);

		/** Node Webatlas */
		Node webatlas = graph.createNode("1");
		webatlas.setLabel("Webatlas").getAttributeValues()
				.addValue(attUrl, "http://webatlas.fr")
				.addValue(attIndegree, "2");

		Spell spellWebatlas1 = new SpellImpl();
		date.set(Calendar.MINUTE, 15);
		spellWebatlas1.setStartValue(date.getTime());
		date.set(2012, 3, 28, 18, 57, 2);
		spellWebatlas1.setEndValue(date.getTime());
		webatlas.getSpells().add(spellWebatlas1);

		Spell spellWebatlas2 = new SpellImpl();
		date.set(2012, 3, 28, 20, 31, 10);
		spellWebatlas2.setStartValue(date.getTime()).setStartIntervalType(
				IntervalType.OPEN);
		date.set(Calendar.MINUTE, 45);
		date.set(Calendar.SECOND, 21);
		spellWebatlas2.setEndValue(date.getTime());
		webatlas.getSpells().add(spellWebatlas2);

		Spell spellWebatlas3 = new SpellImpl();
		date.set(2012, 3, 28, 21, 0, 0);
		spellWebatlas3.setStartValue(date.getTime());
		date.set(2012, 4, 11, 10, 49, 27);
		spellWebatlas3.setEndValue(date.getTime()).setEndIntervalType(
				IntervalType.OPEN);
		webatlas.getSpells().add(spellWebatlas3);

		/** Node RTGI */
		Node rtgi = graph.createNode("2");
		rtgi.setLabel("RTGI").getAttributeValues()
				.addValue(attUrl, "http://rtgi.fr").addValue(attIndegree, "1");

		Spell spellRtgi = new SpellImpl();
		date.set(2012, 3, 27, 6, 0, 0);
		spellRtgi.setStartValue(date.getTime());
		date.set(2012, 4, 19);
		spellRtgi.setEndValue(date.getTime());
		rtgi.getSpells().add(spellRtgi);

		/** Node BarabasiLab */
		Node blab = graph.createNode("3");
		blab.setLabel("BarabasiLab").getAttributeValues()
				.addValue(attUrl, "http://barabasilab.com")
				.addValue(attIndegree, "3").addValue(attFrog, "false");

		/** Node foobar */
		Node foobar = graph.createNode("4");
		foobar.setLabel("FooBar").getAttributeValues()
				.addValue(attUrl, "http://foo.bar").addValue(attIndegree, "1")
				.addValue(attFrog, "false");

		/** Edge 0 [gephi, webatlas] */
		Edge edge0 = gephi.connectTo("0", webatlas);

		Spell spellEdge0 = new SpellImpl();
		date.set(2012, 3, 28, 16, 15, 36);
		spellEdge0.setStartValue(date.getTime());
		date.set(2012, 3, 28, 17, 41, 5);
		spellEdge0.setEndValue(date.getTime());
		edge0.getSpells().add(spellEdge0);

		/** Edge 1 [gephi, rtgi] */
		Edge edge1 = gephi.connectTo("1", rtgi);

		Spell spellEdge1 = new SpellImpl();
		date.set(2012, 3, 30, 11, 16, 6);
		spellEdge1.setStartValue(date.getTime());
		date.set(2012, 4, 3, 11, 52, 6);
		spellEdge1.setEndValue(date.getTime());
		edge1.getSpells().add(spellEdge1);

		/** Edge 2 [rtgi, webatlas] */
		Edge edge2 = rtgi.connectTo("2", webatlas);
		Spell spellEdge2 = new SpellImpl();
		date.set(2012, 4, 1, 11, 0, 0);
		spellEdge2.setStartValue(date.getTime()).setStartIntervalType(
				IntervalType.OPEN);
		date.set(2012, 4, 5, 11, 9, 44);
		spellEdge2.setEndValue(date.getTime());
		edge2.getSpells().add(spellEdge2);

		/** Edge 3 [gephi, blab] */
		Edge edge3 = gephi.connectTo("3", blab);
		Spell spellEdge3 = new SpellImpl();
		date.set(2012, 3, 30, 12, 13, 22);
		spellEdge3.setStartValue(date.getTime());
		date.set(Calendar.MINUTE, 58);
		date.set(Calendar.SECOND, 24);
		spellEdge3.setEndValue(date.getTime());
		edge3.getSpells().add(spellEdge3);

		/** Edge 4 [webatlas, blab] */
		Edge edge4 = webatlas.connectTo("4", blab);
		Spell spellEdge4 = new SpellImpl();
		date.set(2012, 3, 30, 21, 2, 37);
		spellEdge4.setStartValue(date.getTime());
		date.set(Calendar.MINUTE, 13);
		spellEdge4.setEndValue(date.getTime());
		edge4.getSpells().add(spellEdge4);

		/** Edge 5 [foobar, blab] */
		foobar.connectTo("5", blab);

		StaxGraphWriter graphWriter = new StaxGraphWriter();
		File f = new File("c:/servlet/dynamic_graph_sample.gexf");
		Writer out;
		try {
			out = new FileWriter(f, false);
			graphWriter.writeToStream(gexf, out, "UTF-8");
			System.out.println(f.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Done");

	}

	private double randomDouble(double start, double end) {
		Random fRandom = new Random();
		return start + fRandom.nextGaussian() * end;
	}

	private double randomInt(int start, int end) {
		Random r = new Random();
		@SuppressWarnings("unused")
		int range = end - start + 1;
		return r.nextInt(end);
	}
}