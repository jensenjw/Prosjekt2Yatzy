<%@page import="no.hvl.dat109.proj2.yatzy.entities.Player"%>
<%@page import="no.hvl.dat109.proj2.yatzy.daos.PlayerDAO"%>
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
    	<div class="container">
	    	<div>
		   		<table>
		            <tbody id="game_board">
		            </tbody>
		        </table>
	    	</div>
	    	<div id="game_panel">
	    		<h1>Runde: <span id="round_title">En-ere</span></h1>
	    		<h2 ><span id="cur_player"></span> <span>spiler runden sin</span></h2>
	    		<div id="game_controllers">
	    	
	    			<div id="dice_container">
	    				<div class="dice" id="1">
	    				<p id="d1"></p>
	    				<label for="keep_1">behold?</label>
	    				<input type="checkbox" name="keep_1">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="2">
	    				<p id="d2"></p>
	    				<label for="keep_2">behold?</label>
	    				<input type="checkbox" name="keep_2">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="3">
	    				<p id="d3"></p>
	    				<label for="keep_3">behold?</label>
	    				<input type="checkbox" name="keep_3">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="4">
	    				<p id="d4"></p>
	    				<label for="keep_4">behold?</label>
	    				<input type="checkbox" name="keep_4">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="5">
	    				<p id="d5"></p>
	    				<label for="keep_5">behold?</label>
	    				<input type="checkbox" name="keep_5">
	    				</div>
	    			</div>
	    			
	    			<div>
	    				<button id = "roll">
	    					Rull terninger
	    				</button>
	    			</div>
	    		</div>
	    	</div>		
    	</div>
    	<script src="<%out.println(request.getContextPath());%>/JavaScript/yatzybrett/SpillManager.js"></script>
        <script>
        	start(
			[<%
			 for (final String x : (ArrayList<String>)request.getAttribute("players")){
				out.println('"' + x + "\",");
			 }
			 %>],"<% out.print(((Player)request.getSession(false).getAttribute("player")).getUsername());%>"
        	);
        </script>
    </body>
</html>