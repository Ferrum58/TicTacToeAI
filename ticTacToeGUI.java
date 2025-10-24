import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ticTacToeGUI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private String[][] board = new String[3][3];
    private String currentPlayer = "X"
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

        if (board[row][col].equals(" ")) {

            board[row][col] = currentPlayer;
            buttons[row][col].setText(currentPlayer);

            if (currentPlayer.equals("X")) {
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }
        }
    }
}
