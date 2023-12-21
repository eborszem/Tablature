package tabproject;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tab implements ActionListener {
    int count = 0;
    static boolean open = false;
    private JLabel label;
    private JFrame window;
    //private JButton button;
    public static Button[] buttonArr = new Button[5];
    static int index = 0;
    static int buttonX;
    static int buttonY;

    public Tab() {
        open = true;
        System.out.println("Hello world");
        window = new JFrame();
        window.setTitle("Tab to Music");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000, 800);
        window.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        //panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        //panel.setBackground(Color.GRAY);
        window.setLayout(new BorderLayout(5, 5));
        //window.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        for (int i = 0; i < 5; i++) {
            buttonArr[i] = new Button(Integer.toString(i));
            panel.add(buttonArr[i]);
            buttonArr[i].addActionListener(this);
        }
        window.add(panel, BorderLayout.SOUTH);  // CENTER makes it so it moves when screen moves, but also puts buttons NORTH

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
        if (open) {
            return;
        }
        new Tab();
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == buttonArr[0]) {
            System.out.println("button 0");
        } else if (arg.getSource() == buttonArr[1]) {
            System.out.println("button 1");

            index = 1;
            buttonX = buttonArr[index].getBounds().x + 25;
            buttonY = buttonArr[index].getBounds().y + 700;

            System.out.println(buttonX);
            System.out.println(buttonY);

            ImagePanel img_panel = new ImagePanel();
            window.add(img_panel);
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