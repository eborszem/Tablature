import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tab implements ActionListener {

    int count = 0;
    private JLabel label;
    private JFrame window;
    //private JButton button;
    Button[] buttonArr = new Button[5];


    public Tab() {
        System.out.println("Hello world");
        window = new JFrame();
        window.setTitle("Tab to Music");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.GRAY);
        for (int i = 0; i < 5; i++) {
            buttonArr[i] = new Button(Integer.toString(i));
            panel.add(buttonArr[i]);
            buttonArr[i].addActionListener(this);
            window.add(panel, BorderLayout.SOUTH);
        }

        label = new JLabel("num clicks: " + count);
        panel.add(label);

        window.setVisible(true);  // seemingly needs to be last
        

        /*JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(5, 7));
        panel.add(button);*/


        //window.add(panel, BorderLayout.CENTER);
        //window.pack();
        
    }

    public static void main(String[] args) {
        new Tab();
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == buttonArr[0]) {
            System.out.println("button 0");
        } else if (arg.getSource() == buttonArr[1]) {
            System.out.println("button 1");
        } else if (arg.getSource() == buttonArr[2]) {
            System.out.println("button 2");
        } else if (arg.getSource() == buttonArr[3]) {
            System.out.println("button 3");
        } else if (arg.getSource() == buttonArr[4]) {
            System.out.println("button 4");
        }
        count++;
        label.setText("Num clicks: " + count);
        //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}