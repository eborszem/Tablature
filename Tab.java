import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tab implements ActionListener {

    int count = 0;
    private JLabel label;
    private JFrame frame;
    private JButton button;


    public Tab() {
        System.out.println("Hello world");

        frame = new JFrame();
        button = new JButton("click!");
        button.addActionListener(this);
        label = new JLabel("num clicks: " + count);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OUR GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tab();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Num clicks: " + count);
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}