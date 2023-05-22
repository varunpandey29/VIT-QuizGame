import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level4Page extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JButton dreamCompanyButton, superDreamCompanyButton;
    private JPanel questionPanel;
    private JLabel questionLabel,codeLabel;
    private JTextField answerField;
    private JButton onlineCompilerButton, submitButton;
    private int questionNumber;
    
    public Level4Page() {
        setTitle("Level 4 - CSE 4th Year");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
    
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
    
        titleLabel = new JLabel("Welcome to the 4th year of your college!");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("SERIF", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
    
        JPanel buttonPanel = new JPanel(new FlowLayout());
        dreamCompanyButton = new JButton("Dream company");
        dreamCompanyButton.addActionListener(this);
        buttonPanel.add(dreamCompanyButton);
        superDreamCompanyButton = new JButton("Super Dream company");
        superDreamCompanyButton.addActionListener(this);
        buttonPanel.add(superDreamCompanyButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    
        setContentPane(mainPanel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dreamCompanyButton || e.getSource() == superDreamCompanyButton) {
        
            questionPanel = new JPanel();
            questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.PAGE_AXIS));
    
            if (e.getSource() == dreamCompanyButton) {
                questionNumber = 1;
                questionLabel = new JLabel("Question "+questionNumber+" : What is the output of the following code?");
                codeLabel = new JLabel("<html><pre>public class Main {\n    public static void main(String[] args) {\n        int x = 5;\n        int y = 10;\n        int z = x + y;\n        System.out.println(z);\n    }\n}</pre></html>");
                
            } else {
                questionNumber = 2; 
                questionLabel = new JLabel("Question "+questionNumber+" : What is the output of the following code?");
                codeLabel = new JLabel("<html><pre>public class Main {\n    public static void main(String[] args) {\n  for (int i = 0; i < 5; i++) {\n" +
                "    if (i == 3) {\n" +
                "        continue;\n" +
                "    }\n" +
                "    System.out.print(i + \" \");\n" +
                "}\n    }\n}</pre></html>");
                
                
            }
            questionPanel.add(questionLabel);
            questionPanel.add(codeLabel);
            answerField = new JTextField(20);
            JPanel answerPanel = new JPanel(new FlowLayout());
            answerPanel.add(new JLabel("Answer:"));
            answerPanel.add(answerField);
            questionPanel.add(answerPanel);
    
            onlineCompilerButton = new JButton("Online Compiler");
            onlineCompilerButton.addActionListener(this);
            submitButton = new JButton("Submit");
            submitButton.addActionListener(this);
            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(onlineCompilerButton);
            buttonPanel.add(submitButton);
            questionPanel.add(buttonPanel);
    
            JPanel mainPanel = (JPanel) getContentPane();
            mainPanel.add(questionPanel, BorderLayout.CENTER);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
        else if(e.getSource() == onlineCompilerButton){
        
                    String url = "https://www.onlinegdb.com/online_java_compiler";
                    try {
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                    } catch (java.io.IOException ex) {
                        System.out.println(ex.getMessage());
                    }

        }
        else if(e.getSource() == submitButton){
            String answer = answerField.getText();
    
                    if ( answer.equals("15") || answer.equals("0 1 2 4")) {
                        JOptionPane.showMessageDialog(questionPanel, "Congratulations, you have cleared the placement test!");
                        FinalFrame f=new FinalFrame();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(questionPanel, "Sorry, your answer is incorrect. Please try again.");
                    }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Level4Page();
            }
        });
    }
}