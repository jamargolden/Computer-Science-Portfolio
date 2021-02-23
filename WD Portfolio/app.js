function slide(){
    const nav =  document.getElementById('navLinks');

    var aStyle = window.getComputedStyle(nav);
    var rStyle = aStyle.getPropertyValue('right');
    
    if(rStyle != '0px'){
        document.getElementsByClassName("animate")[0].style.right = '0px';
        for(var i = 0; i < 3; i++){
            document.getElementsByClassName("bColor")[i].style.backgroundColor = 'black';
        }
    }
    else{
        nav.classList.remove("animate");
        void nav.offsetWidth;
        nav.classList.add("animate");
        document.getElementsByClassName("animate")[0].style.right = '-50vw';
        for(var i = 0; i < 3; i++){
            document.getElementsByClassName("bColor")[i].style.backgroundColor = '#f3d380';
        }
    }
}
function hover(id){
    const button = document.getElementById(id);

    for(var i = 0; i < document.getElementsByClassName("inAnimation").length; i++){
        if (button == document.getElementsByClassName("inAnimation")[i]){
            document.getElementsByClassName("inAnimation")[i].style.border = 'solid white';
            document.getElementsByClassName("inAnimation")[i+1].style.color = "white";
        }
    }
}
function offHover(id){
    const button = document.getElementById(id);
    button.classList.remove("inAnimation");
    void button.offsetWidth;
    button.classList.add("inAnimation");

    for(var i = 0; i < document.getElementsByClassName("inAnimation").length; i++){
        if (button == document.getElementsByClassName("inAnimation")[i]){
            document.getElementsByClassName("inAnimation")[i].style.border = 'solid #f3d380';
            document.getElementsByClassName("inAnimation")[i+1].style.color = "#f3d380";
        }
    }
}