import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class AWTEventListenerExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        EventQueue eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();

        AWTEventListener listener = new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if (event instanceof KeyEvent) {
                    KeyEvent keyEvent = (KeyEvent) event;
                    System.out.println("Key event: " + keyEvent.getKeyChar());
                }
            }
        };

        // Registra o AWTEventListener para ouvir os eventos de teclado
        toolkit.addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);

        // Crie um JFrame simples para que o evento AWT tenha algo a observar
        JFrame frame = new JFrame("AWT Event Listener Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
