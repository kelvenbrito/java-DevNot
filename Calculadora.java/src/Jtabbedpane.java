import javax.swing.JTabbedPane;

public class Jtabbedpane extends JTabbedPane{
    public Jtabbedpane() {
        super();
        this.add("Calculadora no Estilo do Windows 11",new CalculadoraCompleta());
        this.add("Calculadora de conversão de moeda",new CalculadoraConversaoDeMoeda());
        this.add("Calculadora Salario Liquido",new CalculadoraSalarioLiquido());
    }
}
