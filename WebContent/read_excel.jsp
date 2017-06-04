<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.io.*,javax.servlet.http.HttpServletRequest,javax.servlet.ServletInputStream"%>
<%@ page import="java.io.FileWriter,java.io.IOException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b><%= request.getParameter("address") %></b>
	<%
String file = "c:\\servlet\\identifier_mappings.csv";
String line;

int count = 0;
int i = 0;

FileInputStream fis = new FileInputStream(file);
DataInputStream dis = new DataInputStream(fis);
%>
	<table border=0>
		<%
    while((line = dis.readLine())!=null) {
%>
		<tr>
			<% 
String[] str = line.split(",");
for(int j=0; j<str.length; j++) {
%>
			<td>
				<%          
    out.print(" " + str[j] + " ");
%>
			</td>
			<%
    }
%>
		</tr>
		<%
    //out.println("<br>");
    i++;
}
%>
	</table>
</body>
</html>
</html>