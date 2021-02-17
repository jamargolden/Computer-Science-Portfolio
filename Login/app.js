/*
create table users(
	id int(11) not null PRIMARY KEY AUTO_INCREMENT,
    firstName varchar(15) not null,
    lastName varchar(15) not null,
    email varchar(25) not null,
    password varchar(20) not null
);
*/

function hover(id){
    var button = document.getElementById(id);
    document.getElementsByClassName("animateBtn")[0].style.backgroundColor = "lightgray";
}
function hoverOff(id){
    var button = document.getElementById(id);
    button.classList.remove("animateBtn");
    void button.offsetWidth;
    button.classList.add("animateBtn");
    document.getElementsByClassName("animateBtn")[0].style.backgroundColor = 'white';
}
function loginLink(){
    console.log("HELLLO");
    window.location.replace("index.php")
}