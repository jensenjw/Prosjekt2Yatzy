<%@page import="java.util.List"%>
<%@page import="no.hvl.dat109.proj2.yatzy.entities.json.LobbyListEntry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lobby List</h1>
	<div id="lobby_container">
		<%
			List<LobbyListEntry> entries = (List<LobbyListEntry>)request.getAttribute("lobbies");
			if (entries.size() == 0){
				out.println("<p>No lobbies available</p>");
			}
			else{
				for (LobbyListEntry entry : entries){
					out.println("<div>" + entry.getGameId() +"<form action=\"waitroom?name="+ entry.getGameId() + "\"><button type=\"submit\"> Join </button></div>");
				}
			}
		%>
	</div>
	
	<a href="Html/MenuPage.html">  Back to Menu</a>
</body>
</html>