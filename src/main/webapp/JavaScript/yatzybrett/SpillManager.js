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
        for (const x of ROUND_NAMES){
            const row = document.createElement("tr");
            const title = row.appendChild(document.createElement("td"));
            title.innerText = x;
            for (let i = 0; i < player_count; i++){
                const cell = row.appendChild(document.createElement("td"));
            }
            
            board_body.appendChild(row);
        }
    }

    function create_header_row(players){
        const row = document.createElement("tr");
        row.classList.add("game_board_header");
        const title = row.appendChild(document.createElement("td"));
        title.innerText = "Spillere";
        for (const x of players){
            const player = row.appendChild(document.createElement("td"));
            player.innerText = x;
        }
        return row;
    }



    //MAIN LOGIC

    create_game_board();


}