public class miniMaxAI {
    private static final String PLAYER = "X";  // Human player
    private static final String AI = "O";      // AI player
    
    // check if a player won
    private boolean isWinner(String[][] board, String player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) && 
                board[i][1].equals(player) && 
                board[i][2].equals(player)) {
                return true;
            }
        }
        
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(player) && 
                board[1][i].equals(player) && 
                board[2][i].equals(player)) {
                return true;
            }
        }
        
        // check diagonals
        if (board[0][0].equals(player) && 
            board[1][1].equals(player) && 
            board[2][2].equals(player)) {
            return true;
        }
        
        if (board[0][2].equals(player) && 
            board[1][1].equals(player) && 
            board[2][0].equals(player)) {
            return true;
        }
        
        return false;
    }
    
    // check if board is full
    private boolean isBoardFull(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // almighty minimax
    private int minimax(String[][] board, int depth, boolean isMaximizing) {

        if (isWinner(board, AI)) {
            return 10 - depth; 
        }
        if (isWinner(board, PLAYER)) {
            return depth - 10; 
        }
        if (isBoardFull(board)) {
            return 0; 
        }
        
        if (isMaximizing) {

            int bestScore = Integer.MIN_VALUE;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = AI;  
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = " "; 
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
            
        } else {
            // player's turn - try to minimize score (assume player plays optimally)
            int bestScore = Integer.MAX_VALUE;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals(" ")) {
                        board[i][j] = PLAYER;  // Try this move
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = " ";  // Undo move
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
    
    // find the best move for AI
    public int[] findBestMove(String[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[]{-1, -1};
        
        // try all possible moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    board[i][j] = AI; 
                    int score = minimax(board, 0, false);
                    board[i][j] = " ";  // ndo move
                    
                    // check is this move better than what we've seen?
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        
        return bestMove; 
    }
}
