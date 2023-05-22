import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level3Page extends JFrame implements ActionListener {
    private JLabel titleLabel, subjectLabel;
    private JButton nextButton;

    public Level3Page() {
        setTitle("Level 3 - CSE 3rd Year");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);

        // background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("C:\\Users\\VARUN PANDEY\\Desktop\\finalbg.png").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setOpaque(false); 
        p.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(37, 150, 200));
        p1.setPreferredSize(new Dimension(100, 120));

        titleLabel = new JLabel("Welcome to the 3rd year of college.");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("SERIF", Font.BOLD, 24));
        p.add(titleLabel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\VARUN PANDEY\\Desktop\\vitlogo.png");
        Image image = imageIcon.getImage();
        int width = 250;
        int height = 120;
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        p1.add(label);
        p.add(p1, BorderLayout.NORTH);

        subjectLabel = new JLabel("<html><div style='text-align: center;'>You have finally made it to third year, which is going to be the most crucial year of your college life. This is the year that will determine your future, as the placement season would be coming up.<br><br>You have to work harder than ever before if he wanted to land a good job. Be determined to make the most of this year, attending all your classes, completing all your assignments on time,<br>and participating in various extracurricular activities to boost your resume. <br><br>The pressure is high, but Are you ready to face this challenge?<br><br><br><br>Are you ready to eliminate your Distractions and Disturbance, avoid Social media to increase your efficiency? Enhance your skills by learning DSA and core subjects like CN? <br><br> Click on the Next Button to begin the journey of your 3rd Year</div></html>");
        subjectLabel.setFont(new Font("Arial", Font.BOLD, 12));
        subjectLabel.setForeground(Color.BLACK);
        p.add(subjectLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);
        p.add(buttonPanel, BorderLayout.SOUTH);

        backgroundPanel.add(p);
        add(backgroundPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            Level3Page2 l = new Level3Page2();
            dispose();
        }
    }

    public static void main(String[] args) {
        Level3Page level3Page = new Level3Page();
    }
}
