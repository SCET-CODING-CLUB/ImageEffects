import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class App {

    final static int WIDTH = 700;
    final static int HEIGHT = 475;
    public static void main(String[] args) throws Exception {

        // frame
        JFrame frame = new JFrame("Image Effects");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable((false));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); 

        // image panel
        ImageProcessor imgPro = new ImageProcessor();
        imgPro.requestFocus();

        // effect selector
        JComboBox<Object> effectDropDown = new JComboBox<>(imgPro.getEffectNames());
        effectDropDown.setPreferredSize(new Dimension(WIDTH, 30));
        effectDropDown.setSelectedItem(imgPro.selectedEffect);
        effectDropDown.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (arg0.getStateChange() == ItemEvent.SELECTED){
                    imgPro.selectedEffect = arg0.getItem().toString();
                    imgPro.repaint();
                }
            }
        });
        
        frame.add(imgPro);
        frame.add(effectDropDown);
        frame.pack();
        frame.setVisible(true);

    }
}
