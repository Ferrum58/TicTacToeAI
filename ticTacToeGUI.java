import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ticTacToeGUI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private String[][] board = new String[3][3];
    private String currentPlayer = "X";
    private boolean gameOver = false;
;    
    public ticTacToeGUI() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLayout(new GridLayout(3,3));

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
                add(buttons[i][j]);
            }
        }

        setLocationRelativeTo(null);
    }
    
    private void handleClick(int row, int col) {

        if (board[row][col].equals(" ") && !gameOver) {
            board[row][col] = currentPlayer;
            buttons[row][col].setText(currentPlayer);

            if (checkWinner(currentPlayer)) {
                JOptionPane.showMessageDialog(this, currentPlayer + " WINS!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                gameOver = true;
                return;
            }

            if (checkDraw()) {
                JOptionPane.showMessageDialog(this, "It's a DRAW!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                gameOver = true;
                return;
            }
            if (currentPlayer.equals("X")) {
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }
        }
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
                    return false; // found empty space (not a draw)
                }
            }
        }
        return true;
    }
}
