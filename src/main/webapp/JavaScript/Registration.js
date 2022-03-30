
function showUsernameInfo() {
    
    console.log("Working")
    const usernameInfo = document.getElementById("username").contains("\s") ? 
        "Username cannot contain spaces" : "";

    alert(usernameInfo)
    console.log(usernameInfo)
    document.getElementById("usernameInfo").innerHTML = usernameInfo;
}