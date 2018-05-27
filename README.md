# HowestStone
---
## Powered by:
>[![howest](http://letstalk.howest.be/wp-content/uploads/2017/11/howest-colour.png)](https://www.howest.be/nl)
##### Made by: Jelle Vermeulen , Michiel Vanwymeersch , Robbe Senesael , Xander Denecker
<img src="https://scontent.fbru1-1.fna.fbcdn.net/v/t1.15752-9/s2048x2048/33653503_1627645994017910_92484372598358016_n.jpg?_nc_cat=0&oh=fa4bb4d1343fba0c51a44e7b1305d748&oe=5B877C7E" width="600" height="450"/>

>"On the photo from left to right : Robbe, Michiel, Xander and Jelle"

>"Er zijn maar 2 programmeertalen, die waar iedereen over zaagt en die dat niet meer gebruikt worden" - Robbe

>"smiet doar ki e generator up" - Michiel

>"programmer: a person who fixed a problem that you didn't know you had, in a way you don't understand" - Xander

>"Da lukt niiii kan jij het doen anders?" - Jelle

## 1. Project description and featurelist
### Description
>HowestStone is a simulation made as end project of the online card game Hearthstone by Activison Blizzard written in Java. HowestStone tries to re-implement some mechanisms and rules from the original game as accurately as possible.

### Features
#### Chosen Classes 
---
|Class|         
|-|
|Mage|
|Hunter|

#### Hero powers
---
|Hero|Power|What does it do|          
|-|-|-|
|Mage|Fireblast|Deal 1 damage|
|Hunter|Steady Shot|Deal 2 damage to the enemy hero|  

#### Deckbuilder
---
> In the Deckbuilder you can choose a class and a deck. After you have chosen a class and a deck you can change the deck with the specific cards you want. 

**Be Aware** : you can only have 2 of the same cards in your deck! 

##### How to use the deckbuilder:
* **Step 1. Choose a class**
* **Step 2. Choose a deck**
* **Step 3. Single click a card that you want to change from your deck section (so it's selected)**
* **Step 4. Double click on the card you want in the all cards section to change the selected card with your new card** 
* **Final step. if you are satisfied with your new deck press save and your new deck is set!** 
    
#### Abilities
---

##### Easy
---
|Ability|What does it do|          
|-|-|
|Charge| ability allowing a minion to attack the same turn.|
|Divine Shield|ability which causes a minion to ignore the next damage it receives. Upon receiving any damage the Divine Shield is removed, and that damage is reduced to 0.|
|Windfury|ability which allows a character to attack twice per turn. |

##### Medium
---
|Ability|What does it do|          
|-|-|
|Taunt|ability which forces the opposing player to direct any melee attacks toward enemy targets with this ability. Minions with Taunt (commonly referred to as Taunts) serve to protect their allies by forcing the enemy to deal with them first, preventing them from attacking other friendly minions or the controlling hero until the Taunts are removed.|
|Poisonous|ability that causes any minion damaged by them to be destroyed.|


##### Hard
---
|Ability|What does it do|          
|-|-|
|Stealth|ability which prevents that minion from being the target of enemy attacks, spells and effects until they attack.|

##### Battlecries / spells
---
|What works|
|-|
|All spells|
|All damage battlecries
|All draw battlecries|
|Health battlecry|
|Polymorph battlecry|
|Insta kill battlecry|
|Gain health battlecry|
|Gain attack battlecrt|


## 2. How to install and run
**NOTE JDK 1.8 is required!**

**1. Clone this repository:**
* `git clone https://172.21.22.52/TI/Project-I/2018-Group-34 howeststone`

**2.Change directory to repository:**
  * `cd howeststone`

**3.Go to the master branche**
  * `git checkout master`

**4.Add needed database**
  * Start `WAMP`
  * Go to `http://localhost/phpmyadmin/` login with user `root` and let the password empty server choice is `MySQL`
  * If you are logged in press `New` in the left sidebar
  * In the textbox Database name you type `howeststone` and then press create
  * Now press `import` in the bar above 
  * Click on the button `Choose file`
  * Add the database `howeststone.sql`which is locatated in `\howeststone\java_backend\src\main\resources\database`
  * Finally press `Go` at the bottom of the screen and normally you now have created the database `howeststone` which you can see in the left sidebar

**5.Final**
  * Start `InteliJ` and  (`WAMP` if it isn't already started)
  * Press `open `
  * Locate to the `java_backend` directory and open it
  * in the pop-up window check the `Use auto-import`checkbox and then press the `Ok` button
  * Wait until the gradle is build
  * When it's opened go to the `Server` class which is located in `\src\main\java\api`
  * Run the `Server` class
  * If the `Server` class is running open the `index.html` file which is located in `\howeststone\web_frontend`
  * If you see the game you can play!
**Be Aware** : Be sure `WAMP` and the `Server` class must be running otherwise you don't get the cards   
 
## 3.Code overview
>Some of the most important classes in our project are:
* **Game**

>The Game class is needed to initialize the settings of the entire game. Like the players , coinflip , turns , etc..
* **ReusableMethods**

>The ReusableMethods class is needed to prevent duplicate codes
* **Routes**

>The Routes class is needed to do all the connections between the game and the server
* **Cards**

>The Cards class is needed to initialize the cards. Like Id , Name , img , etc.. 
* **Player** 

>The Player class is needed to keep track of the individual settings for the player. Like attack , placecard , etc..
* **Minion**

>The Minion class is needed to keep track of the settings of the minion itself. Like losehealth , attack , etc..

## 4. Unittests
>Some of the tests we made:
* **the `abilities` package**

>In the `abilities` package we put al our tests for the abilities to check if the ability works.  
* **the `api` package**

>In the `api` package we have a test to check if the Javalin server works
* **the `cardLogic` package**

>In the `cardLogic`package is a test for the full card settings like addCard and removeCard and in the `cardLogic` package is also another package named `card` and there we put al the test for the settings from the minion cards , spell cards and weapon cards
* **the `heroLogic` package**

>In the `heroLogic` package we put al our tests to check if the hero powers work.
