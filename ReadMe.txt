RAJEEV SINGH NARUKA
2017A7PS0010P
---------------------------------------------------
SUBMISSION FOR OOP ASSIGNMENT
---------------------------------------------------

EVALUATION CRITERIA

1. MULTI-THREADING
> This program makes use of multi-threading in Java. There is a moderator thread
  and N-number of player threads running concurrently.
> All of them run in parallel, and synchronize with each other using locks, until the game is finished.

---------------------------------------------------

2. GENERICS AND COLLECTIONS
> This program uses List (implements Collections) and ArrayList<Integer> (uses generics).

---------------------------------------------------

3. ARRAYS
> This program makes use of a boolean array to keep track of all threads whether they have
  checked the latest announced number or not.

---------------------------------------------------

4. PROPER EXCEPTION HANDLING
> Implemented try-catch exception to handle exceptions while dealing with threads
  from moderator and player classes.
> Implemented a throwable InterruptedException in the main function of the Game class.

---------------------------------------------------

5. Input/Output (use general libraries and not standard I/O)

> Used java.io.PrintStream to print relevant information in the console.
> Used ANSI color-coding for better readability.

---------------------------------------------------

6. DESIGN PATTERNS (at least 2)

> Singleton Pattern - This pattern makes sure that only one object is created for the class.
  This program uses this pattern to restrict creation of gamedata object, as multiple gamedata
  object is not needed and can lead to undesirable effect. [wiki: https://en.wikipedia.org/wiki/Singleton_pattern] 

> Monitor (synchronization) Pattern - This concurrent program uses the Monitor design pattern which 
is a synchronization construct. It allows our player and moderator threads to run mutually exclusive.
The threads have the the ability to wait (block) for a certain condition (verifying if the current number
has been checked) to become false. [wiki: https://en.wikipedia.org/wiki/Monitor_(synchronization)] 

