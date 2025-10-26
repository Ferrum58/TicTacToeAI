import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ticTacToeGUI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private String[][] board = new String[3][3];
    private String currentPlayer = "X";
    private boolean gameOver = false;
    private miniMaxAI ai = new miniMaxAI();  
    private boolean playerTurn = true;       
    
    public ticTacToeGUI() {
        setTitle("Tic-Tac-Toe vs AI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,450);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
                buttons[i][j] = new JButton(board[i][j]);
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));

                //final variables for lambda
                final int row = i;
                final int col = j;
                //click handler
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        handleClick(row, col);
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JButton resetButton = new JButton("New Game");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        add(resetButton, BorderLayout.SOUTH); // add reset button to bottom

        setLocationRelativeTo(null);
    }
    
    private void handleClick(int row, int col) {

        if (board[row][col].equals(" ") && !gameOver && playerTurn) {  
            board[row][col] = "X";  
            buttons[row][col].setText("X"); 

            if (checkWinner("X")) {  
                JOptionPane.showMessageDialog(this, "YOU WIN!", "Game Over", JOptionPane.INFORMATION_MESSAGE);  // CHANGE THIS LINE
                gameOver = true;
                return;
            }

            if (checkDraw()) {
                JOptionPane.showMessageDialog(this, "It's a DRAW!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                gameOver = true;
                return;
            }
            
            playerTurn = false;
            Timer timer = new Timer(500, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    makeAIMove();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    
    private void makeAIMove() {
        int[] move = ai.findBestMove(board);
        
        if (move[0] != -1) {
            board[move[0]][move[1]] = "O";
            buttons[move[0]][move[1]].setText("O");
            
            if (checkWinner("O")) {
                JOptionPane.showMessageDialog(this, "AI WINS!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                gameOver = true;
                return;
            }
            
            if (checkDraw()) {
                JOptionPane.showMessageDialog(this, "It's a DRAW!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                gameOver = true;
                return;
            }
        }
        
        playerTurn = true;
    }

    private boolean checkWinner(String player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) &&
                board[i][1].equals(player) &&
                board[i][2].equals(player)) {
                return true;
                }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(player) &&
                board[1][i].equals(player) &&
                board[2][i].equals(player)) {
                    return true;
                }
        }

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

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
                buttons[i][j].setText(" ");
            }
        }
        currentPlayer = "X"; // reset game state
        gameOver = false;
        playerTurn = true;  
    }
}