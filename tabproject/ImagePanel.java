package tabproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ImagePanel extends JPanel {
    ImageIcon originalImg = new ImageIcon("./images/1.png");
    Image tmpImg = originalImg.getImage();
    Image tmpNewImg = tmpImg.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
    ImageIcon img = new ImageIcon(tmpNewImg);

    final int IMG_WIDTH = img.getIconWidth();
    final int IMG_HEIGHT = img.getIconHeight();

    Point imgCorner;
    Point prevPoint;

    ImagePanel() {
        System.out.println("ImagePanel Reached!");
        //imgCorner = new Point(tab.getButtonX(), tab.getButtonY());

        imgCorner = new Point(Tab.buttonX, Tab.buttonY);

        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);

        DragListener dragListener = new DragListener();
        this.addMouseMotionListener(dragListener);

    }
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("PaintComp Reached!");
        super.paintComponent(g);
        img.paintIcon(this, g, (int) imgCorner.getX(), (int) imgCorner.getY());
    }

    public class ClickListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            System.out.println("Press event!");
            prevPoint = event.getPoint();
        }
    }

    public class DragListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent event) {
            System.out.println("Drag event!");
            Point currentPoint = event.getPoint();

            imgCorner.translate((int) (currentPoint.getX() - prevPoint.getX()),
                                (int) (currentPoint.getY() - prevPoint.getY()));
            prevPoint = currentPoint;
            repaint();
        }
    }
    
    

    
}
