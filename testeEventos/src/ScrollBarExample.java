import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollBarExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ScrollBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JScrollBar scrollBar = new JScrollBar();
        JLabel label = new JLabel("Valor: ");

        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                label.setText("Valor: " + scrollBar.getValue());
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(scrollBar);
        panel.add(label);

        frame.add(panel);
        frame.setVisible(true);
    }
}
