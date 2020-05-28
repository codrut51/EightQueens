## Description

A while back I heard of a problem about chess and it intrigued me. The problem states:

On a chess board 8 x 8, how many queens (we are going to refer to them as a x number of queens) can you put on the board without them being able to attack each other.
To make the problem a bit more complex how many possible arrangements/combinations of the found x number of queens can be computed for a 8 x 8 grid/board.

Additionally for any given number (n >= 4) calculate the number of possible arrangements of n queens on a table of n x n
(**Optionally**: A visual representation can be given of the possible arrangements )  

### My method of approach
I think someone out there can find an even better way to do this but I will choose a very popular approach to this problem.
##### __[Backtracking](https://en.wikipedia.org/wiki/Backtracking)__ #####

#### Getting started with providing input to the current program
##### Build 
In the command line/terminal run: `./gradlew build`
##### Running the program
In the command line/terminal run: `java -jar build/libs/EightQueens-0.0.1.jar`
By playing with the program and inputting all kinds of numbers it will be noticed that a StackOverflow message will appear for any number (n > 5).
To see all result for a number n > 5 the following command needs to be ran:
`java -jar -Xss1024m build/libs/EightQueens-0.0.1.jar` <= This command increases the stack of the current run of the java program to 1024mb.
The -Xss attribute can have multiple values e.g.:<br/>
`java -jar -Xss4m <path_to_jar>` <br/>
`java -jar -Xss8m <path_to_jar>`<br/>
`java -jar -Xss16m <path_to_jar>`<br/>
`java -jar -Xss32m <path_to_jar>`<br/>
`java -jar -Xss64m <path_to_jar>`<br/>
`java -jar -Xss128m <path_to_jar>`<br/>
`java -jar -Xss256m <path_to_jar>`<br/>
`java -jar -Xss512m <path_to_jar>`<br/>
`java -jar -Xss1024m <path_to_jar>`<br/>

#### ToDo 
* [x] Add main class
* [x] Add backtracking class
* [x] Add simple logic of backtracking class (all possible permutation for a number n)
* [x] Improving logic for the problem at hand 
* [x] Create visual representation
* [x] Build, documentation, & getting started <br/>
** Optionally **: 
    * [ ] Create API to compute visual representation of the created boards on a front-end.
