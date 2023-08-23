import javax.swing.JFrame;

public class JFrameSwing extends JFrame{
    public JFrameSwing(){
        super("Minha primeira janela JFrame Swing");
        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
