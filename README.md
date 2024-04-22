# MastermindGame_Java: command line version of Mastermind
### Group: [Cabriel Lorenzo](https://github.com/lcabriel) [SM3500518] | [Da Vinchie Lisa](https://github.com/LisaDaVinchie) [SM3500574] | [Marsich Gaia](https://github.com/gmarsich) [SM3500600] | [Munini Matteo](https://github.com/mmunini99) [SM3600006]

This repository contains the command line version of Mastermind. The game has been implemented in Java and the testing part has been developed using Gradle. The free version of CircleCI as Continuous Integration tool was used.


## Usage

To play Mastermind on your device a Java distribution is required. To run the file from terminal you first need to compile it. Follow these instructions on a command prompt:

* Locate yourself into `~\MasterMind-Game-Java-cmd\app\src\main\java\`

* Compile the classes using:

If you have a Windows OS, work with: 
```bash
javac mastermindgame_java\LetGameRun\Play.java mastermindgame_java\Settings\*.java
```

Insetad if you have Linux or MacOS: 
```bash
javac mastermindgame_java/LetGameRun/Play.java mastermindgame_java/Settings/*.java
```

* Then run it:

If you have a Windows OS, work with: 
```bash
java  mastermindgame_java/LetGameRun/Play
```

Insetad if you have Linux or MacOS: 
```bash
java mastermindgame_java/LetGameRun/Play mastermindgame_java/Settings/*
```

* Play and Enjoy!!!


## To test the code

 To test the code with Gradle (junit5) you need to install Gradle at first. 

 Then you have to build the project:

 * Locate yourself into "~\MasterMind-Game-Java-cmd"

Then, if you have a Windows OS, work with:

```bash
.\gradlew build
```
instead if you have Linux or MacOS:

```bash
gradle build
```
Now, you can run the tests and play:

* in a Windows OS:
  
```bash
.\gradlew run
```
* in Linux or MacOS:

```bash
gradle run
```


## Rules of the table game

The codemaker creates a secret code respecting a certain degree of difficulty, defined by the length of the secret code, the number of available colors and the amount of possible trials. Remark that a secret code could be created using multiple times the same color. 

You have to give a guess using the colored pegs (in our implementation numbers replace colors). When the guess is submitted, the codemaker will provide a feedback that will be displayed on the board, near the guess.

Each peg of the guess receives a feedback, one of the following three:
- **white peg**: the color is present in the secret code and it is in the correct position
- **black peg**: the color is present in the secret code but was placed in the wrong position
- **hole**: the color is not present in the secret code
However, you are just given the amount of white pegs, black pegs and holes, not the exact correspondence between a peg of the guess and its feedback.

The goal of the game is to guess the secret code before the number of trials expires.


## Our implementation

Firstly, the user must choose a level of difficulty:
- *EASY*: 4-digit secret code, 3 colors, 15 trials
- *MEDIUM*: 4-digit secret code, 6 colors, 12 trials
- *HARD*: 4-digit secret code, 6 colors, 7 trials

In the command line version, for a better user experience, the colors have been substituted by integer numbers. So, the secret guess is a combination of numbers!

The user can type anytime *EXIT* to quit the game.


While playing from command line the following tools will be used:

* *COLORED PEGS*: each color peg is represented by a number. The user will type a sequence of numbers to define a guess
* *FEEDBACK PEGS*: these are special pegs which can be  **OK** (white peg), **N-OK** (black peg) and  **NO** (hole). The codemaker will provide the feedback on the user guess reporting the count for each type of feedback peg
* *BOARD*: here there are the history of the guesses and the related feedbacks


