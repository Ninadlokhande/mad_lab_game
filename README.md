Mad Libs Game — Java Console Edition

A simple, fun, and fully interactive Mad Libs game written in Java.
The player fills in blanks, tries to guess the correct words, and earns credits for correct answers.
Includes difficulty levels, input validation, and a clean modular structure.

🚀 Features

✔ Multiple difficulty levels

Easy

Medium

Hard

Each difficulty includes a unique story with its own correct answers.

✔ Credit system

Start with 100 credits

Each round costs 5 credits

Win the round → +10 credits

✔ Input validation

No empty inputs allowed

Case-insensitive answer checking

✔ Clean and modular Java design

Story class for structured story management

Separate functions for input, gameplay, scoring, and printing

🕹 How to Play

Run the program.

Choose whether you want to play.

Pick your difficulty:

1 → Easy

2 → Medium

3 → Hard

You’ll see a story with blanks (________).

Fill each blank with a word.

The game will:

Insert your words back into the story

Check if your answers match the correct words

Reward credits if you got everything right

Continue playing as long as you have credits and choose “Y”.

🧩 Example Gameplay
WELCOME TO ADVANCED MAD LIBS!
Credits: 100

Play game? (Y/N): Y
Each play costs 5 credits. Remaining: 95

Choose Difficulty:
1) Easy
2) Medium
3) Hard
Enter choice (1/2/3): 1

Fill in the blanks:
A boy and a girl went to a ________...
Enter word 1: Park
Enter word 2: Tree
Enter word 3: Cute
Enter word 4: They

===== YOUR STORY =====
A boy and a girl went to a Park...
======================

Correct! You WON +10 credits!
Credits Left: 105

🧱 Project Structure
MadLibsGame/
 ├── src/
 │   └── MadLibsGame.java
 ├── README.md

⚙ How It Works
Story Class

This holds:

The story text

The correct answers

Main Components

selectDifficulty()
Lets the user pick Easy/Medium/Hard.

playStory()
Handles full round: input → story fill → scoring.

getInput()
Ensures valid, non-empty inputs.

evaluateStory()
Awards credits if user gets all answers right.

printCompletedStory()
Replaces blanks with the user’s words.
