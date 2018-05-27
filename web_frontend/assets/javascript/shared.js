"use strict";

function loc(link){
    return window.location.assign(link);
}

document.addEventListener("DOMContentLoaded", function(){
    qsa(".goToOtherPage").forEach((item) => item.addEventListener("click", switchTargetPage)
);
    if(document.contains(document.querySelector(".ownName")))retrieveFromStorage();
});

let switchTargetPage = (e) => {
    e.preventDefault();
    let dataPage = e.currentTarget.getAttribute("data-page");
    !(dataPage === "index") ? loc(dataPage + ".html") : loc("../" + dataPage + ".html");
}
let retrieveFromStorage = () => document.querySelector(".ownName").innerHTML = localStorage.getItem("name");

function qs(element){
    return document.querySelector(element);
}

function qsa(element){
    return document.querySelectorAll(element);
}