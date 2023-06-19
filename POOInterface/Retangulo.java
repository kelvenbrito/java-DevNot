package POOInterface;

public class Retangulo implements FiguraGeometrica{
    int base;
    int altura;
    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        int area  = base * altura;
        return area;
    }
    @Override
    public String getNomeFigura() {
        // TODO Auto-generated method stub
        return "Retangulo";
    }
    @Override
    public double getPerimetro() {
        // TODO Auto-generated method stub
        int perimetro = base*2 + altura*2;
        return perimetro;
    }
    
}
