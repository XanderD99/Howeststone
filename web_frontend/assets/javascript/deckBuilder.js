"use strict";

document.addEventListener("DOMContentLoaded", function () {
    console.log("loaded");
    getAllCards();

    qs("#saveDeck").addEventListener("click", saveDeck);

    qs("#chooseClass").addEventListener("change", getAllCards);
    qs("#chooseDeck").addEventListener("change", setDeck);
});

let selectedClass;
let selectedDeck;

function saveDeck(e) {
    e.preventDefault();
    let cardsInDeck = [];
    qsa('#chosenCards img').forEach((item) => cardsInDeck.push(item.getAttribute('data-card')));

    let obj = {"class": document.getElementById("chooseClass").value, "deck": document.getElementById("chooseDeck").value, "ids": cardsInDeck};
    fetch("http://localhost:4242/API/deckbuilder/saveDeck", {
        body: JSON.stringify(obj),
        method: 'POST'
    }).then(function (res) {
        if (400 === res.status) {
            getDeck();
            alert("invalid deck!");
        }
		else{
			alert("deck saved");
		}
    }).catch(function (err) {
        console.log(err);
    });
}

function swap(e) {
    let target = e.target;
    let selected = qs(".selected");

    if (selected && allowedToSwap(target)) {
        selected.setAttribute("src", target.getAttribute("src"));
        selected.setAttribute("data-card", target.getAttribute("data-card"));
        removeSelected(selected);
    }
    else {
        alert("can't switch card(s)");
    }
}

function allowedToSwap(card) {
    let selectedId = card.getAttribute("data-card");
    let appearences = 0;
    qsa("#chosenCards img").forEach(function (e) {
        if (e.getAttribute("data-card") === selectedId) {
            appearences++;
        }
    });

    return appearences < 2;
}

function selectCard(e) {
    if (qs(".selected")) {
        removeSelected(qs(".selected"));
    }

    e.target.classList.add("selected");
}

function removeSelected(target) {
    target.classList.remove("selected");
}

function error(e) {
    e.style.display = 'none';
}

function swapClassImg(classImg) {
    document.getElementById("classImg").setAttribute("src", "../images/" + classImg + ".png");
}

function displayCards(cards, cardtarget) {
    document.getElementById(cardtarget).innerHTML = "";
    cards.forEach(function (card) {
        let imgUrl = card.img;
        let cardid = card.id;
        document.getElementById(cardtarget).innerHTML += `<img src="${imgUrl}" class="playingCard" data-card="${cardid}"/>`;
    });
}

//fetch from java object
function getAllCards() {
    selectedClass = document.getElementById("chooseClass").value;

    swapClassImg(selectedClass);

    fetch('http://localhost:4242/API/deckbuilder/getAllCards', {
        method: "get"
    }).then(function (responds) {
        return responds.json();
    }).then(function (data) {
        let arrayOfAllCards = [];
        let allCards = data.cards;

        allCards.forEach(card => {
            if (card.playerClass === selectedClass || card.playerClass === "Neutral") arrayOfAllCards.push(card);
        });

        displayCards(sortArray(arrayOfAllCards), "cardsToChose");

        setDeck();
    }).catch(function (err) {
        // Error :(
        console.log(err);
    });
}

function getDeck() {
    fetch('http://localhost:4242/API/deckbuilder/getDeck', {
        method: "get"
    }).then(function (responds) {
        return responds.json();
    }).then(function (data) {

        let arrayOfAllCards = [];
        let allCards = data.cards;

        allCards.forEach(card => {
            if (card.playerClass === selectedClass || card.playerClass === "Neutral") arrayOfAllCards.push(card);
        });

        displayCards(sortArray(arrayOfAllCards), "chosenCards");

        setImgFunctions();
    }).catch(function (err) {
        // Error :(
        console.log(err);
    });
}

function setDeck() {
    let deckname = document.getElementById("chooseDeck").value;

    let obj = {"class": selectedClass, "deck": deckname};

    fetch('http://localhost:4242/API/deckbuilder/chooseDeck', {
        method: "post",
        body: JSON.stringify(obj)
    }).then(function(res){
        getDeck();
    });
}

function sortArray(array) {
    array.sort(function (a, b) {
        let nameA = a.playerClass.toUpperCase(); // ignore upper and lowercase
        let nameB = b.playerClass.toUpperCase(); // ignore upper and lowercase

        if (nameA < nameB) return -1;
        if (nameA > nameB) return 1;
        //names must be equal
        if (nameA === nameB) return a.manaCost - b.manaCost;
    });
    return array;
}

function setImgFunctions() {
    qsa("#cardsToChose img").forEach((item) => item.addEventListener('dblclick', swap));
    qsa("#chosenCards img").forEach((item) => item.addEventListener('click', selectCard));
}
