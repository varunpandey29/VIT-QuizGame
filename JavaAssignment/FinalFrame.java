import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinalFrame extends JFrame implements ActionListener {
    private JLabel title;
    private JLabel subtitle;
    private JButton exit;

    public FinalFrame() {
        setTitle("Final Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\VARUN PANDEY\\Desktop\\placed.jpg");
                Image image = backgroundIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        title = new JLabel("Congratulations!");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.GREEN);
        

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(title);

        subtitle = new JLabel("You have completed your Graduation!!");
        subtitle.setFont(new Font("Arial", Font.BOLD, 24));
        

        JPanel subtitlePanel = new JPanel();
        subtitlePanel.setBackground(Color.WHITE);
        subtitlePanel.add(subtitle);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(50, 10, 0, 10);
        p.add(titlePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 10, 50, 10);
        p.add(subtitlePanel, gbc);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        p.add(exit, gbc);

        add(p);

        setVisible(true);
        setSize(1100, 600);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new FinalFrame();
    }
}
