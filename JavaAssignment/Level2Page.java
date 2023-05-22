import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level2Page extends JFrame implements ActionListener {
    private JLabel title, subjectLabel, questionLabel;
    private JTextField answerField;
    private JButton submitButton, nextButton;
    private JComboBox<String> subjectComboBox;
    private int numCorrect = 0;

    private final String[] SUBJECTS = {"Choose a subject", "DBMS", "C++", "Operating System"};
    private final String[] QUESTIONS = {"", "The ability to query data, as well as insert, delete, and alter tuples, is offered by ____________", "Which of the following symbol is used to declare the preprocessor directives in C++?", "For real time operating systems, interrupt latency should be ____________"};
    private final String[] ANSWERS = {"", "Data manipulation language", "#", "minimal"};

    public Level2Page() {
        setTitle("Level 2 - CSE 2nd Year");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(10, 10)); 
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(37, 150, 200));
        p1.setPreferredSize(new Dimension(100, 120));

        title = new JLabel("Welcome to the 2nd year of your college!");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("SERIF", Font.BOLD, 24));

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\VARUN PANDEY\\Desktop\\vitlogo.png");
        Image image = imageIcon.getImage();
        int width = 250;
        int height = 120;
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        p1.add(label);   
        add(p1, BorderLayout.NORTH);
        p.add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout()); 
        subjectLabel = new JLabel("Choose your subject:");
        centerPanel.add(subjectLabel);
        
        subjectComboBox = new JComboBox<String>(SUBJECTS);
        subjectComboBox.setPreferredSize(new Dimension(150, 30)); 
        subjectComboBox.addActionListener(this);
        centerPanel.add(subjectComboBox);
        
        JPanel leftPanel = new JPanel(); // for centerPanel
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(Box.createVerticalGlue()); 
        leftPanel.add(centerPanel);
        leftPanel.add(Box.createVerticalGlue()); 
        
        p.add(leftPanel, BorderLayout.WEST);
        

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));

        questionLabel = new JLabel("Your Question will appear here!");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16)); 
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        answerField = new JTextField(15);
        answerField.setMaximumSize(new Dimension(300, 30)); 
        answerField.setAlignmentX(Component.CENTER_ALIGNMENT); 

        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // to allign it in center
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = subjectComboBox.getSelectedIndex();
                String answer = answerField.getText();
                if (answer.equalsIgnoreCase(ANSWERS[selectedIndex])) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    numCorrect++;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect.");
                }
            }
        });

        nextButton = new JButton("Next");
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT); // centered next button
        nextButton.addActionListener(this);

        JPanel centerPanel2 = new JPanel();
        centerPanel2.setLayout(new BoxLayout(centerPanel2, BoxLayout.Y_AXIS));
        centerPanel2.add(Box.createVerticalGlue()); 
        centerPanel2.add(questionLabel);
        centerPanel2.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel2.add(answerField);
        centerPanel2.add(Box.createRigidArea(new Dimension(0, 10))); 
        centerPanel2.add(submitButton);
        centerPanel2.add(Box.createRigidArea(new Dimension(0, 10))); 
        centerPanel2.add(Box.createVerticalGlue()); 

        p.add(centerPanel2, BorderLayout.CENTER);

        add(p);
        setVisible(true);
        setSize(1100, 600);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == subjectComboBox) {
            int selectedIndex = subjectComboBox.getSelectedIndex();
            questionLabel.setText(QUESTIONS[selectedIndex]);
            answerField.setText("");
        } else if (e.getSource() == nextButton) {
            if (numCorrect == 3) {
                JOptionPane.showMessageDialog(null, "Congratulations! You have cleared Level 2 - Second Year of your College.");
                Level3Page l = new Level3Page();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please answer all questions correctly before proceeding.");
            }
        }
    }


    public static void main(String[] args) {
        Level2Page level2Page = new Level2Page();
    }
}