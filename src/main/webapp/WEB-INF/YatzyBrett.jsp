<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Yatzy</title>
    	<style>
    		td{
    			min-width: 100px;
    			border 1px solid black;
    		}
    	</style>
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