import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level1Page extends JFrame implements ActionListener {
    private JLabel title, subtitle;
    private JButton nextButton, backButton;
    private JComboBox<String> subjectComboBox1, subjectComboBox2, subjectComboBox3;
    private int numCorrect = 0;

    public Level1Page() {
        setTitle("Level 1 - CSE 1st Year");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(37, 150, 200));
        p1.setPreferredSize(new Dimension(100, 120));

        title = new JLabel("Welcome to the 1st year of your college!");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("SERIF", Font.BOLD, 24));
    
        subtitle = new JLabel("Choose the midterm or tee for each subject");
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        subtitle.setFont(new Font("SERIF", Font.BOLD, 18));
        subtitle.setBounds(280, 0, 550, 300);
        
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
        p.add(subtitle);

        JPanel subjectPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        subjectPanel.add(new JLabel("Introduction to Python:"), c);
        c.gridx = 1;
        subjectComboBox1 = new JComboBox<>(new String[]{"MIDTERM", "TEE"});
        subjectComboBox1.addActionListener(this);
        subjectPanel.add(subjectComboBox1, c);
        c.gridx = 0;
        c.gridy = 1;
        subjectPanel.add(new JLabel("Environmental Science:"), c);
        c.gridx = 1;
        subjectComboBox2 = new JComboBox<>(new String[]{"MIDTERM", "TEE"});
        subjectComboBox2.addActionListener(this);
        subjectPanel.add(subjectComboBox2, c);
        c.gridx = 0;
        c.gridy = 2;
        subjectPanel.add(new JLabel("Integral Mathematics:"), c);
        c.gridx = 1;
        subjectComboBox3 = new JComboBox<>(new String[]{"MIDTERM", "TEE"});
        subjectComboBox3.addActionListener(this);
        subjectPanel.add(subjectComboBox3, c);
        p.add(subjectPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        backButton = new JButton("Back");
        nextButton = new JButton("Next");
        backButton.addActionListener(this);
        nextButton.addActionListener(this);
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        
        p.add(buttonPanel, BorderLayout.PAGE_END);
        add(p);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {            
            HomePage homePage = new HomePage();
            dispose(); 
        } 
        else if (e.getSource() == subjectComboBox1) {
            JComboBox<String> cb = (JComboBox<String>)e.getSource();
            String question = (String)cb.getSelectedItem();
            String message = "";
            if (question.equals("MIDTERM")) {
                message = "Which type of Programming does Python support?";
                Object[] options = {"A) object-oriented programming", "B) structured programming", "C) functional programming", "D) all of the mentioned"};
                int selectedOption = JOptionPane.showOptionDialog(this, message, "Python Quiz", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (selectedOption == 3) {
                    message = "Congratulations! Your answer is correct.";
                    numCorrect++;
                } else {
                    message = "Oops! Your answer is incorrect.";
                }
            } else if (question.equals("TEE")) {
                message = "Which keyword is used for function in Python language?";
                Object[] options = {"A) Function", "B) def", "C) func", "D) define"};
                int selectedOption = JOptionPane.showOptionDialog(this, message, "Python Quiz", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    if (selectedOption == 1) {
                    message = "Congratulations! Your answer is correct.";
                    numCorrect++;
                    } else {
                    message = "Oops! Your answer is incorrect.";
                    }
                    }
                    JOptionPane.showMessageDialog(this, message, "Python Quiz", JOptionPane.PLAIN_MESSAGE);
                    } 
            else if (e.getSource() == subjectComboBox2) {
                    JComboBox<String> cb = (JComboBox<String>)e.getSource();
                    String question = (String)cb.getSelectedItem();
                    String message = "";
                    if (question.equals("MIDTERM")) {
                    message = "How many total numbers of biodiversity hotspots are there in the world?";
                    String answer = JOptionPane.showInputDialog(this, message, "Environmental Science Quiz", JOptionPane.PLAIN_MESSAGE);
                    if (answer != null && answer.equalsIgnoreCase("36")) {
                    message = "Congratulations! Your answer is correct.";
                    numCorrect++;
                    } else {
                    message = "Oops! Your answer is incorrect.";
                    }
                    } else if (question.equals("TEE")) {
                    message = "Which of the following is a non-renewable resource?";
                    Object[] options = {"A) wind energy", "B) solar energy", "C) coal", "D) water"};
                    int selectedOption = JOptionPane.showOptionDialog(this, message, "Environmental Science Quiz", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    if (selectedOption == 2) {
                    message = "Congratulations! Your answer is correct.";
                    numCorrect++;
                    } else {
                    message = "Oops! Your answer is incorrect.";
                    }
                    }
                    JOptionPane.showMessageDialog(this, message, "Environmental Science Quiz", JOptionPane.PLAIN_MESSAGE);
                    } else if (e.getSource() == subjectComboBox3) {
                    JComboBox<String> cb = (JComboBox<String>)e.getSource();
                    String question = (String)cb.getSelectedItem();
                    String message = "";
                    if (question.equals("MIDTERM")) {
                    message = "What is the integration of 1/x?";
                    Object[] options = {"A) ln|x| + C", "B) 1/x + C", "C) x + C", "D) x^2/2 + C"};
                    int selectedOption = JOptionPane.showOptionDialog(this, message, "Integral Mathematics Quiz", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    if (selectedOption == 0) {
                    message = "Congratulations! Your answer is correct.";
                    numCorrect++;
                    } else {
                    message = "Oops! Your answer is incorrect.";
                    }
                    } else if (question.equals("TEE")) {
                    message = "What is the value of integral of sin(x)?";
                    Object[] options = {"A) -cos(x) + C", "B) cos(x) + C", "C) -sin(x) + C", "D) sin(x) + C"};
                    int selectedOption = JOptionPane.showOptionDialog(this, message, "Integral Mathematics Quiz", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    if (selectedOption == 0) {
                    message = "Congratulations! Your answer is correct.";
                    numCorrect++;
                    } else {
                    message = "Oops! Your answer is incorrect.";
                    }
                    }
                    JOptionPane.showMessageDialog(this, message, "Integral Mathematics Quiz", JOptionPane.PLAIN_MESSAGE);
                    }
        else if (e.getSource() == nextButton) {
            if (numCorrect == 6) {
                JOptionPane.showMessageDialog(null, "Congratulations! You have cleared Level 1 - 1st Year of your college.");
                Level2Page l = new Level2Page();
                dispose();
            } 
            else {
                JOptionPane.showMessageDialog(null, "Please answer all the questions correctly before proceeding.");
            }
        }
    
    }

public static void main(String[] args) {
    Level1Page level1Page = new Level1Page();
    }
}