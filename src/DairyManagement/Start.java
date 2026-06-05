package DairyManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Start extends JFrame {

    public Start() {

        setLayout(null);
        setSize(700, 600);
        //setLocation(300, 100);
        setLocationRelativeTo(null);
        setTitle("Dairy Management Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/dairy.png"));
        JLabel label = new JLabel(backgroundIcon);
        label.setBounds(0,0,700,600);
        add(label);

        JLabel shadowLabel = new JLabel("Dairy Management");
        shadowLabel.setFont(new Font("Serif", Font.BOLD, 50));
        shadowLabel.setForeground(new Color(250, 200, 1));
        shadowLabel.setBounds(142, 52, 500, 60);
        label.add(shadowLabel);

        JLabel h1Label = new JLabel("Dairy Management");
        h1Label.setFont(new Font("Serif", Font.BOLD, 50));
        h1Label.setForeground(new Color(0, 73, 9, 187));
        h1Label.setBounds(140, 50, 500, 60);
        label.add(h1Label);

        JLabel h2Label = new JLabel("(Select Animal For Detail)");
        h2Label.setFont(new Font("Serif", Font.BOLD, 32));
        h2Label.setForeground(new Color(0, 73, 9, 187));
        h2Label.setBounds(170, 120, 500, 40);
        label.add(h2Label);

        ImageIcon cowIcon = new ImageIcon(getClass().getResource("/images/cow.png"));
        JLabel cowLabel = new JLabel(cowIcon);
        cowLabel.setBounds(170,220,150,150);
        cowLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CowDetails();
            }
        });
        label.add(cowLabel);

        JLabel cowText = new JLabel("Cow Details");
        cowText.setBounds(180, 380, 300,30 );
        cowText.setFont(new Font("Serif",Font.BOLD,25));
        cowText.setForeground(new Color(0, 73, 9, 187));
        cowText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CowDetails();
            }
        });
        label.add(cowText);

        ImageIcon bufaloIcon = new ImageIcon(getClass().getResource("/images/buffalow.png"));
        JLabel bufaloLabel = new JLabel(bufaloIcon);
        bufaloLabel.setBounds(370,220,150,150);
        bufaloLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new BuffaloDetails();
            }
        });
        label.add(bufaloLabel);

        JLabel bufaloText = new JLabel("Buffalo Details");
        bufaloText.setBounds(370, 380, 300,30 );
        bufaloText.setFont(new Font("Serif",Font.BOLD,25));
        bufaloText.setForeground(new Color(0, 73, 9, 187));
        bufaloText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new BuffaloDetails();
            }
        });
        label.add(bufaloText);


        setVisible(true);
    }

    public static void main(String[] args) {
    new Start();

    }
}