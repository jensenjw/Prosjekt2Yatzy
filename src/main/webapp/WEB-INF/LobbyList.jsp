<%@page import="java.util.List"%>
<%@page import="no.hvl.dat109.proj2.yatzy.entities.json.LobbyListEntry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	#lobby_container{
		margin: auto;
		max-width: 400px;
	}
	
	.room_entry{
		font-size: large;
	}
	
	.room_name{
		display: inline;
		font-weight: bold;
	}
</style>
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
					out.println("<div class=\"room_entry\" > <span class=\"room_name\">" + entry.getGameId() +"</span><form action=\"WaitRoom\"><input type=\"hidden\" name=\"name\" value =\""+ entry.getGameId() + "\"><button type=\"submit\"> Join </button></div>");
				}
			}
		%>
	</div>
	 
	<a href="Html/MenuPage.html">  Back to Menu</a>
</body>
</html>