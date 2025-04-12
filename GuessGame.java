import java.awt.event.ActionListener;

import java.util.Random;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

public class GuessGame extends JFrame {
   
    private int numberToGuess;
    private int numberOfTries;
    private JTextField guessField;
    private JLabel resultLabel;
    private JLabel numberofTriesLabel;

    public GuessGame(){
        setTitle("Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,1));

        //Genereate random number
        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1; // Random number between 1 and 100
        numberOfTries = 0;

        // Create UI components
        JLabel promptLable = new JLabel("Enter your guess (1-100): ");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("Enter your guess and press 'Guess'.");
        numberofTriesLabel = new JLabel("Number of tries: " + numberOfTries);

        //Add components to the frame
        add(promptLable);
        add(guessField);
        add(guessButton);
        add(resultLabel);
        add(numberofTriesLabel);

        //Add action listener to the button

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
            
        });
        System.out.println(numberOfTries);
        
    }
    
    private void checkGuess(){
        try{
            int userGuess = Integer.parseInt(guessField.getText());
            numberOfTries++;

            if(userGuess < 1 || userGuess > 100){
                resultLabel.setText("Please enter a number between 1 and 100.");
            }else if(userGuess < numberToGuess){
                resultLabel.setText("Too low! Try again.");
            }else if(userGuess > numberToGuess){
                resultLabel.setText("Too high! Try again.");
            }else{
                resultLabel.setForeground(Color.green);
                resultLabel.setText("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                //resultLabel.setText("<html>Text color: <font color='red'>"Congratulations! You guessed the number in " + numberOfTries + " tries."</font></html>");
            }
        }
        catch(NumberFormatException e){
            resultLabel.setText("Invalid input! Please enter a number.");
        }
        guessField.setText("");
        numberofTriesLabel.setText("Number of tries: " + numberOfTries);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessGame().setVisible(true);
            }
        });
        
    }
}