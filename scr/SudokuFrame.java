package soduko;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SudokuFrame extends JFrame {
    private JPanel sudokuPanel;
    private JTextField[][] sudokuFields;
    private int[][] sudokuGrid;

    public SudokuFrame() {
        super("Sudoku");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sudokuPanel = new JPanel();
        sudokuPanel.setLayout(new GridLayout(9, 9));
        sudokuFields = new JTextField[9][9];
        sudokuGrid = SudokuGenerator.generate();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sudokuFields[i][j] = new JTextField();
                sudokuFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                if (sudokuGrid[i][j] != 0) {
                    sudokuFields[i][j].setText(Integer.toString(sudokuGrid[i][j]));
                    sudokuFields[i][j].setEditable(false);
                }
                sudokuPanel.add(sudokuFields[i][j]);
            }
        }

        add(sudokuPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SudokuFrame();
    }
}