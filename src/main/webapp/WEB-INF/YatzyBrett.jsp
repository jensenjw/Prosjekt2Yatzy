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
	    		<h2 id="cur_player">Kåre</h2>
	    		<div id="game_controllers">
	    	
	    			<div id="dice_container">
	    				<div class="dice" id="1">
	    				<p>2</p>
	    				<label for="keep_1">behold?</label>
	    				<input type="checkbox" name="keep_1">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="2">
	    				<p>2</p>
	    				<label for="keep_1">behold?</label>
	    				<input type="checkbox" name="keep_1">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="3">
	    				<p>2</p>
	    				<label for="keep_1">behold?</label>
	    				<input type="checkbox" name="keep_1">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="4">
	    				<p>2</p>
	    				<label for="keep_1">behold?</label>
	    				<input type="checkbox" name="keep_1">
	    				</div>
	    			</div>
	    			
	    			<div id="dice_container">
	    				<div class="dice" id="5">
	    				<p>2</p>
	    				<label for="keep_1">behold?</label>
	    				<input type="checkbox" name="keep_1">
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
			 %>]
        	);
        </script>
    </body>
</html>