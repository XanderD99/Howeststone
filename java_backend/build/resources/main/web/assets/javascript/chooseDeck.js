

document.addEventListener("DOMContentLoaded", function () {
    qsa(".classes input").forEach((item) => item.addEventListener('click', enableDeckSelector));
    qsa(".deck input").forEach((item) => item.addEventListener("click", selectDeck));
    qs(".createGame").addEventListener("click", getClassAndDeck);
});



//region
function enableDeckSelector(e) {
    e.preventDefault();
    let targetVal = qs("#" + e.target.value.toLowerCase()).classList;
    if(qs(".enabled") !== null){
        let enabled = qs('.enabled').classList;
        enabled.add("disabled");
        enabled.remove("enabled");
        qsa(".disabled input").forEach((item) => item.disabled = true)
    }
    if(qs(".disabled") !== null){
        targetVal.remove("disabled");
        targetVal.add("enabled");
        qsa(".enabled input").forEach((item) => item.disabled = false)
    }
    qsa(".deck div").forEach((item) => item.classList = "overlay")

}

function selectDeck(e) {
    e.preventDefault();
    qsa(".deck div").forEach((item) => item.classList = "overlay");
    e.target.parentNode.classList.add("selected");

    //TODO: sent to game page
}

function getClassAndDeck() {
    let playerClass = qs(".enabled").getAttribute("id");
    let deck = qs(".selected input").value;

    let deckId = generate(playerClass , deck);

    createGame(deckId , playerClass);
    console.log( playerClass + " " + deck);
}

function generate(playerClass , Deck) {

    let deckId = "";

    if (playerClass === "mage") {deckId += "MD_";
    } else {deckId += "HD_";
    }if (Deck === "Deck 1") {deckId += "01";
    } else if (Deck === "Deck 2")
    {deckId += "02";
    } else {deckId += "03";}

    console.log(deckId);

    return deckId;
}

function createGame(deckId , playerClass) {

    let obj = {"class": capitalizeFirstLetter(playerClass), "deck": deckId, "playername": localStorage.getItem("name")};

    fetch('http://localhost:4242/API/gameSql/createNewGame', {
        method: "post",
        body: JSON.stringify(obj)
    }).then(function(res){
        if (res.ok) {
            loc("/html-pages/game.html");
        }
    });
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}