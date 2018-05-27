let paused = false;
let id = 0;

document.addEventListener("DOMContentLoaded", function () {
    startGame();

    setCardsWidth();

    qs(".player .cardsHand").addEventListener("dblclick", placeCard);
    qs(".player .playedCards").addEventListener("click", selectCard);

    qs("#spellPlayer").addEventListener("click", selectCard);

    document.addEventListener("mouseover", displayCardDetail);

    qs(".opponent .playedCards").addEventListener("click", attack);

    qs("#endGame").addEventListener("click", endGame);
    qs("#endTurn").addEventListener("click", endTurn);

    getGameInfo();

    setInterval(function () {
        if (!paused) {
            getGameInfo();
        }
    }, 500);
});

function endTurn() {
    fetch('/API/gameSql/endTurn', {
        method: "post",
    });
}

function startGame() {
    fetch('/API/gameSql/startGame', {
        method: "post",
    });
}

function updateFields(player) {
    displayCards(player.cardsInHand.cards, player.name, "cardsHand");
    displayCards(player.cardsOnField.cards, player.name, "playedCards");

    if (player.name === "player") {
        cardsLeft(player.cards.cards.length);
    }
}

function displayCards(cards, player, position) {
    qs("." + player + " ." + position).innerHTML = "";

    if (cards) {
        cards.forEach(function (e) {
            qs("." + player + " ." + position).innerHTML += createCard(e, player, position);
        });
    }
}

function cardsLeft(length) {
    qs(".amountLeft").innerHTML = length;
}

function createCard(card, player, position) {
    let cardId = card.id;
    let cardImg = card.img;
    if (player === "opponent" && position === "cardsHand") {
        return `<img class="playingcard" src="/images/cardback.png" data-cardId="${cardId}"/>`;
    } else {
        return `<img class="playingcard" src="${cardImg}" data-cardId="${cardId}"/>`;
    }
}

function updateHeros(player) {
    displayHero(player.hero.heroClass, player.name);
    setHeroData(player.hero.health, player.name);
}

function setHeroData(health, position) {
    qs("." + position + " .healthLeft").innerHTML = health;
}

function displayHero(hero, position) {
    let heroimg = qs("." + position + " .hero img");
    let heroSpell = qs("." + position + " .heroSpell img");

    heroimg.setAttribute("src", `/images/${hero}.png`);
    heroSpell.setAttribute("src", `/images/${hero}Power.png`);
    heroSpell.setAttribute("data-hero", `${hero}`);
}

function updatePlayers(player) {
    qs("." + player.name + " .manaLeft").innerHTML = player.availableMana;
    qs("." + player.name + " .manaAvailable").innerHTML = player.manaLimit;
}

function getGameInfo() {
    fetch('/API/gameSql/gameInfo', {
        method: "get"
    }).then(function (responds) {
        return responds.json();
    }).then(function (data) {
        console.log(data);
        data.forEach(function (e) {
            updateFields(e);
            updateHeros(e);
            updatePlayers(e);
        });
    }).catch(function (err) {
        // Error :(
        console.log(err);
    });
}

function removeSelected() {
    if (qs(".selected")) {
        qs(".selected").classList.remove("selected");
    }
}

function setCardsWidth() {
    let imgwidth = (100 / id + 2);

    if (imgwidth < 25) {
        qsa(".cardsHand img").forEach((img) => img.style.width = imgwidth + "%")
    }
}

function displayCardDetail(e) {
    removeCardDetail();
    let target = e.target;

    if (target.getAttribute("class") === "playingcard" || target.getAttribute("id") === "spellPlayer") {
        let img = e.target.cloneNode();

        img.setAttribute("style", "");
        img.setAttribute("id", "");

        if (target.getAttribute("id") === "spellPlayer") {
            let hero = target.getAttribute("data-hero");
            img.setAttribute("src", "/images/" + hero + "powercard.png");
        }

        qs(".displaySelectedCard").appendChild(img);
    }
}

function removeCardDetail() {
    qs(".displaySelectedCard").innerHTML = "";
}

function selectCard(e) {
    if (e.target.localName === "img") {
        if (qs(".selected")) {
            removedSelected(qs(".selected"));
        }

        e.target.classList.add("selected");

        paused = true;
    }
}

function removedSelected(target) {
    target.classList.remove("selected");
    paused = false;
}

function attack(e) {
    let attacker = qs(".selected");
    if (attacker) {
        let attackedCard = e.target;

        alert(attacker.getAttribute("data-cardId") + " attacks " + attackedCard.getAttribute("data-cardId"));

        postAttack(attacker.getAttribute("data-cardId"), attackedCard.getAttribute("data-cardId"));

        removedSelected(attacker);
    }
}

function endGame(e) {
    e.preventDefault();
    if (confirm("Are you sure you want to end the game?")) {
        switchTargetPage(e);
    }
}

function placeCard(e) {
    let card = e.target;
    /*card.remove();
    document.querySelector(".player.playedCards").appendChild(card);*/

    let cardId = card.getAttribute("data-cardId");
    let player = localStorage.getItem("name");

    postCardInField(cardId, player);
}

function postAttack(attackId, attackedId) {

    let obj = {"attacker": attackId, "attacked": attackedId};

    fetch('http://localhost:4242/API/gameSql/attack', {
        method: "post",
        body: JSON.stringify(obj)
    });
}

function postCardInField(cardId) {
    fetch('http://localhost:4242/API/gameSql/cardField', {
        method: "post",
        body: cardId
    });
}