

TIC-TAC-TOE WITH AI (MINIMAX ALGORITHM)
============================================================

Authors:
  - Demir Sicim (2252880)
  - Jorge Prado (2334690)

Project Title:
  Tic-Tac-Toe with Minimax AI

------------------------------------------------------------
HIGH PRIORITY FEATURES
------------------------------------------------------------

1. Game Board Display
   - When running the application, a 3x3 grid with empty cells appears.
   - The window title should be "Tic-Tac-Toe".

2. Player Can Place "X"
   - Clicking an empty cell places a blue "X" on that cell.
   - Clicking again on the same cell does nothing.

3. Win Detection: Columns and Rows
   - When three "X"s are placed in a row or column, display message:
     "Player Wins!"
   - All rows and columns are checked after each move.

4. Win Detection: Diagonals
   - When three "X"s are placed diagonally, display message:
     "Player Wins!"

5. Draw Detection
   - If all 9 cells are filled and no one has won, display message:
     "It’s a Draw!"

6. Basic AI
   - After the player places "X", the AI places "O" in a different empty cell.

7. Minimax Algorithm Implementation
   - The AI makes optimal moves using the minimax algorithm.
   - The AI never loses — the player can only lose or draw.
   - The AI blocks the player from winning immediately.

8. Turn Indicator
   - Top of the window displays:
       • "Your Turn" when it’s the player’s turn.
       • "AI is thinking..." when it’s the AI’s turn.

9. New Game Button
   - After the game ends, a "New Game" button appears below the window.


------------------------------------------------------------
MEDIUM PRIORITY FEATURES
------------------------------------------------------------

1. Visual Feedback – Colours
   - "X" appears in blue, "O" appears in red.
   - Winning line cells are highlighted.

2. Game Status Messages
   - Status label updates dynamically:
       • "Your Turn"
       • "AI Wins"
       • "Draw"

3. Prevent Invalid Moves
   - Clicking on an occupied cell does nothing.
   - Clicking on any cell after the game ends does nothing.


------------------------------------------------------------
TOPICS OF CHOICE
------------------------------------------------------------

- Algorithms: Minimax Algorithm
- Version Control: GitHub


