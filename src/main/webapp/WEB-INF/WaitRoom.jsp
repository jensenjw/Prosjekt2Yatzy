<%@page import="no.hvl.dat109.proj2.yatzy.entities.Player"%>
<%@page import="no.hvl.dat109.proj2.yatzy.entities.Lobby"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
	<% Lobby lobby = (Lobby) request.getAttribute("lobby"); %>
	<% Player player = (Player) request.getSession(false).getAttribute("player"); %>
	<h1><% out.println( lobby.getLobbyName() ); %></h1>
	<div id="players">
		
	</div>
	<div id="controllers">
		<button id="start_game">Start Game</button>
		<form method="post" action="WaitRoom">
			<input type="hidden" name="act" value="leave">
			<button type="submit">Leave Lobby</button>
		</form>
	</div>
	<script src="<%out.println(request.getContextPath());%>/JavaScript/yatzybrett/WaitRoom.js"></script>
	<script type="text/javascript">
		start("<% out.print(player.getUsername()); %>");
	</script>
</body>
</html>