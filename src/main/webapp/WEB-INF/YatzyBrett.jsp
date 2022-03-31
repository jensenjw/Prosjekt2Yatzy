<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Yatzy</title>
    	<link rel="stylesheet" href="<%out.println(request.getContextPath());%>/css/YatzySpill.css">
    </head>
    <body>
        <table>
            <tbody id="game_board">
            </tbody>
        </table>

        <script src="<%out.println(request.getContextPath());%>/JavaScript/yatzybrett/SpillManager.js"></script>
        <script>
        	start(
			[<%
			 for (final String x : (ArrayList<String>)request.getAttribute("players")){
				out.println('"' + x + "\",");
			 }
			 %>]
        	);
        </script>
    </body>
</html>