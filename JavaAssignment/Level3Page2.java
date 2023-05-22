import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Level3Page2 extends JFrame implements ActionListener {
    private JFrame gameFrame;
    private JButton nextButton1;
    private JLabel textLabel;

    public Level3Page2() {
        gameFrame = new JFrame("Level 3 - Third Year");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1100, 600);
        gameFrame.setLayout(null); 

   
        JPanel p = new JPanel(new BorderLayout());
        textLabel = new JLabel("To Complete your course and eliminate all Distractions, Click on the buttons 3 times !!");
        p.add(textLabel, BorderLayout.CENTER);
        gameFrame.add(p, BorderLayout.NORTH);

     
        nextButton1 = new JButton("Next");
        nextButton1.addActionListener(this);
        gameFrame.add(nextButton1);
        nextButton1.setBounds(950, 500, 100, 40); 

        Random rand = new Random();
        String[] buttonLabels = {"Disturbance", "Distractions", "Data Structures", "Computer Networks", "Social Media", "Enhance Skills"};
        int numberOfButtons = buttonLabels.length;
        for (int i = 0; i < numberOfButtons; i++) {
            int x = rand.nextInt(900) + 50; 
            int y = rand.nextInt(400) + 50; 
            JButton button = new JButton(buttonLabels[i]); 
            button.addActionListener(new ActionListener() {
                int numberOfClicks = 0;

                public void actionPerformed(ActionEvent e) {
                    numberOfClicks++;
                    if (e.getSource() == nextButton1) {
                        JOptionPane.showMessageDialog(null, "Congratulations! You have cleared Level 3 - Third Year of your College.");
                        Level4Page l = new Level4Page();
                        gameFrame.dispose();
                    } else if (numberOfClicks == 3) {
                        button.setVisible(false); 
                    }

                }
            });
            gameFrame.add(button); 
            button.setBounds(x, y, 200, 50); 
        }

        gameFrame.setVisible(true); 
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton1) {
            Level4Page l = new Level4Page();
            gameFrame.dispose();
        }
    }

    public static void main(String[] args) {
        new Level3Page2();
    }
}
