<b>TicTacToe Command Line</b>

To build project, the commend below should be executed.
<pre>gradlew clean build</pre>

Mockito and JUnit 4 used for unit test purpose.

<b>Configuration</b>

The program could be configurated to initiliaze game and includes;

<pre>
battlefieldSize:5
player1Name:Player1
player1Mark:X
player2Name:Player2
player2Symbol:Y
playerAiSymbol:O
</pre> 

<b>Rules</b>

Basic game rules could be found at : https://en.wikipedia.org/wiki/Tic-tac-toe 
But this is different you can play with;
 <ul>
 <li>3 human player and 0 AI</li>
 <li>2 Human player and 1 AI</li>
 <li>1 Human player and 2 AI</li>
 <li>3 AI player plays and you can watch :)</li>
 </ul>
 at the same time.
 
<b>Design</b>

There are 2 types of player AIPlayer and HumanPlayer. And both of them extends abstract Player class which
is responsible to make new moves.

Main where the game is initialized with settings.
GameController manages how to play game and keep rules and dispatch responbility to other classes.
Gameboard responsible to manage board features.