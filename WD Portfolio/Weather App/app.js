var long //Holds Longitude Value of User
var lat //Holds Latitude Value of User
var currentTime = new Date(); // Gets Date Info from Usser
var hours = currentTime.getHours(); //Holde the current hour of User
var api; //Holds Api Link
var zip; //Holde User Inputed Zip Code
var id = "522be8f9819c40c46ea43492a7c5a0b3"; //My Api ID

//function that runs if Geolocation retrieval is successful
const successCallback = (position) =>{
    //Sets Longitude Value
    long = position.coords.longitude;
    //Sats Latitude Value
    lat = position.coords.latitude;
    //FIlls Api link date in
    api = `http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${id}&units=imperial`
    //Runs getWeather()
    getWeather();
}
//function that fetchs information from API and updates the page with the information provided
async function getWeather(){
    //Fetches info from api link
    const response = await fetch(api);
    //assigns data to #info and converts information to json format
    const info = await response.json();
    //console print testing purposes
    console.log(info);
    
    //gets city name from info and places that text into the specified element
    const {name} = info;
    document.getElementById("currentLocal").textContent = name;

    //gets weather description from info and places it into the specified element
    const {description} = info.weather[0];
    document.getElementById("description").textContent = description;

    //gets temperature from info and p;aces it into the specified element
    const{temp} = info.main;
    document.getElementById("temperature").textContent = Math.floor(temp) + "°F";

    const {feels_like} = info.main;
    document.getElementById("fLike").textContent = Math.floor(feels_like) + "°F";

    const {temp_min} = info.main;
    const {temp_max} = info.main;
    document.getElementById("minMaxTemp").textContent = Math.floor(temp_min) + "°F" + "/" + Math.floor(temp_max) + "°F";

    //Runs Icon checker funcion
    iconChecker(description, info);
    //Runs timeChenger function
    timeChanger();
}
//Function that runs if an error occurs when trying to get Geolocation
const errorCallback = (error) =>{
    console.log("error")
    console.log(error);
}
//Calls for user Geolocation
navigator.geolocation.getCurrentPosition(successCallback, errorCallback);

//Function that changes background color based on current time of the user
function timeChanger(){
    //Checks if current hour is between 6am and 6pm
    if(hours >= 6 && hours <= 18){
        //gets the body tag and sets its background image
        document.getElementsByTagName("body")[0].style.backgroundColor = 'skyblue';
    }
    else{
        document.getElementsByTagName("body")[0].style.backgroundColor = 'black';
    }
}
/*Function that grabs the weather description from #info and asigns a icon that best describes the 
current weather conditions using a series of if and else if statements
*/
function iconChecker(desc, info){
    const {main} = info.weather[0];
    console.log(main);
    if(desc == "clear sky"){
        document.getElementById("weatherIcon").src = "img/Clear.png";
    }
    else if(desc == "few clouds"){
        document.getElementById("weatherIcon").src = "img/Few Clouds Day.png";
    }
    else if(desc == "broken clouds"){
        document.getElementById("weatherIcon").src = "img/Scattered Clouds2.png";
    }
    else if(desc == "scattered clouds"){
        document.getElementById("weatherIcon").src = "img/Scattered Clouds2.png";
    }
    else if(desc == "shower rain"){
        document.getElementById("weatherIcon").src = "img/Shower Rain.png";
    }
    else if(desc == "rain"){
        document.getElementById("weatherIcon").src = "img/Rain Night.png";
    }
    else if(desc == "thunderstorm"){
        document.getElementById("weatherIcon").src = "img/Thunderstorm.png";
    }
    else if(desc == "snow"){
        document.getElementById("weatherIcon").src = "img/Snow.png";
    }
    else if(desc == "mist"){
        document.getElementById("weatherIcon").src = "img/Mist.png";
    }
    else{
        
        if(main == "Clouds"){
            document.getElementById("weatherIcon").src = "img/Scattered Clouds2.png";
        }
        else if(main == "Thunderstorm"){
            document.getElementById("weatherIcon").src = "img/Thunderstorm.png";
        }
        else if(main == "Rain" || main == "Drizzle"){
            document.getElementById("weatherIcon").src = "img/Shower Rain.png";
        }
        else if(main == "Snow"){
            document.getElementById("weatherIcon").src = "img/Snow.png";
        }
    }
}
//Function that allows the user to search for the weather of a location using its Zip Code
//Also handles the button click functionality which shows ans hides the search bar and submits search
function makeSearch(){
    //Gets text Input Element
    const box = document.getElementById("searchBox");
    //Gets style of text input
    var boxStyle = window.getComputedStyle(box);
    //gets value of opacity
    var o = boxStyle.getPropertyValue("opacity");
    //gets the text entered into the text input by user
    var text = box.value;

    console.log(text);

    //If the input is not visible then it changes the opacity making it visible
    if(o == '0'){
        box.style.opacity = "1";
    }
    //If input is visible but text field is empty then opacity is set to 0
    else if(o == '1' && text == ""){
        box.classList.remove("searchBox");
        void box.offsetWidth;
        box.classList.add("searchBox");
        box.style.opacity = "0";
    }
    //if input is visible and text field not embty then getweather runs with entered zipcode and input is hidden again
    else if(o == '1' && text != ""){
        zip = box.value;
        box.value = "";
        box.classList.remove("searchBox");
        void box.offsetWidth;
        box.classList.add("searchBox");
        box.style.opacity = "0";
        api = `http://api.openweathermap.org/data/2.5/weather?zip=${zip},us&appid=${id}&units=imperial`
        getWeather();
    }
}
//Function that allows user to also press enter when typing zipcode to search by zipcode
window.onload = function(){
    document.getElementById("searchBox").addEventListener('keypress', function(event){
        if (event.keyCode === 13) {
            makeSearch();
        }
    });
}
