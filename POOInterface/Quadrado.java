package POOInterface;

public class Quadrado implements FiguraGeometrica{
    private int lado;

    public Quadrado(int lado) {//construtor
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        int area = 0;
        area = lado * lado;
        return area;
    }

    @Override
    public String getNomeFigura() {
        // TODO Auto-generated method stub
        return "quadrado";
    }

    @Override
    public double getPerimetro() {
        // TODO Auto-generated method stub
        int perimetro = lado*4;
        return perimetro;
    }
    
}
