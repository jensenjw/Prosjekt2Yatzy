function start(playerName){
   
	const player_container = document.getElementById("players");
	
	const start_game_button = document.getElementById("start_game");
	
    /**
     * 
     * @param {string} method GET eller POST
     * @param {string} url endepunktet vi skal snakke med
     * @param {string?} body json som skal sendes med hvis det er en post
     * @returns {string | null}
     */
    function send_http_request(method, url, body = null){
        var xhttp = new XMLHttpRequest();
        xhttp.open(method, url,false);

        let content = null;

        xhttp.onload = (e) => {
            if ((~~(xhttp.status / 100)) != 2){
                console.error("Recieved " + xhttp.status + ": " + xhttp.statusText + " from server");
            }
            else{
                content = xhttp.responseText;
            }
        }
        if (body != null || body != undefined)
        {
            xhttp.send(body);
        }
        else{
            xhttp.send();
        }
        return content;
    }

	function poll_changes(){
		const json = send_http_request("POST","WaitRoom?act=poll");
		const data = JSON.parse(json);
		
		if (data.started){
			location.replace("YatzyBrettServlet");
			return;
		}
		
		player_container.innerHTML = "";
		
		for (const x of data.players){
			const list = document.createElement("div");
			list.innerText = x;
			if (data.owner == x){
				list.innerText += " owner";
			}
			
			player_container.appendChild(list);
		}
		
		if (playerName == data.owner){
			start_game_button.style.display = "block";
		}
		else{
				start_game_button.style.display = "none";	
		}
		
	}

    //MAIN LOGIC
	
	start_game_button.onclick = _ => {
		send_http_request("POST","WaitRoom?act=start")
	}
	
    let old = performance.now();
    function runner(){
        let cur = performance.now();
        if (cur - old > 2000){
            old = cur;
            poll_changes();
        }

        requestAnimationFrame(runner);
    }
    runner();
}