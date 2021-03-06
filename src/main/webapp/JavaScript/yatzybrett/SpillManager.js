function start(players){
    const ROUND_NAMES = [
        "En-ere",
        "To-ere",
        "Tre-ere",
        "Fir-ere",
        "Fem-ere",
        "Seks-ere",
        "Bonus",
        "1 Par",
        "2 Par",
        "3 Like",
        "4 Like",
        "Liten Straight",
        "Stor Straight",
        "Sjanse",
        "Yatzy",
        "Sum"
    ]
    function create_game_board(){
        const player_count = players.length;

        const board_body = document.getElementById("game_board");
        board_body.appendChild(create_header_row(players));
        for (const x in ROUND_NAMES){
            const name = ROUND_NAMES[x];
            const row = document.createElement("tr");
            const title = row.appendChild(document.createElement("td"));
            title.innerText = name;

            for (let i = 0; i < player_count; i++){
                const cell = row.appendChild(document.createElement("td"));
                cell.id = "score_" + players[i] + "_" + x;
            }
            
            board_body.appendChild(row);
        }
    }

    function create_header_row(players){
        const row = document.createElement("tr");
        row.classList.add("header");
        const title = row.appendChild(document.createElement("td"));
        title.innerText = "Spillere";
        for (const x of players){
            const player = row.appendChild(document.createElement("td"));
            player.innerText = x;
        }
        return row;
    }

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
                throw new Error("Recieved " + xhttp.status + ": " + xhttp.statusText + " from server");
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

    function fetch_game_state(){
        const json = send_http_request("GET","game");

        const obj = JSON.parse(json);

        for (const x in obj.scores){
            for (const y in obj.scores[x]){
                const id = "score_" + x + "_" + y;

                const cell = document.getElementById(id);
                if (!!cell){
                    const value = obj.scores[x][y];
                    cell.innerText = value >= 0 ? value.toString() : "";
                }
            }
        }
    }

    function get_keep_checkbox(name){
        /**
         * @type {HTMLInputElement}
         */
        const x = document.getElementsByName(name)[0];
        return x;
    }

    function get_keep_states(){
        return [
            get_keep_checkbox("keep_1").value,
            get_keep_checkbox("keep_2").value,
            get_keep_checkbox("keep_3").value,
            get_keep_checkbox("keep_4").value,
            get_keep_checkbox("keep_5").value,
        ]
    }

    function roll_dices(){
        send_http_request("POST","game?act=roll",{
            keep: get_keep_states()
        });
    }

    //MAIN LOGIC

    create_game_board();
    
    fetch_game_state();

    document.getElementById("roll").onclick = roll_dices;

    let old = performance.now();
    function runner(){
        let cur = performance.now();
        if (cur - old > 2000){
            old = cur;
            fetch_game_state();
        }

        requestAnimationFrame(runner);
    }
    runner();

}