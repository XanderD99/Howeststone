document.addEventListener("DOMContentLoaded", function() {
    console.log("PAGE LOADED!");
    qs(".login").addEventListener("click", checkValidityOfUsername);
});

let checkValidityOfUsername = (e) => {
    e.preventDefault();
    let nameInput = qs("#name").value;
    nameInput === undefined ||nameInput === "" ? alert("Login was incorrect please give a real username! ") :
    loc("html-pages/mainPage.html");
    typeof(Storage) !== "undefined" ? localStorage.setItem("name", nameInput) : alert("localStorage isn't supported");
};