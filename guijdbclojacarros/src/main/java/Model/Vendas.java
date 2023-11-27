package Model;

public class Vendas {
    // atributos
    private String dataVenda;
    private String carrosVendidos;
    private String nomeClientes;
    private String valorTotal;
    private String codVenda;
    private String CPFCliente;

    // contrutor
    public Vendas(String dataVenda, String carrosVendidos, String nomeClientes, String valortotal, String codVenda,
            String CPFCliente) {
        this.dataVenda = dataVenda;
        this.carrosVendidos = carrosVendidos;
        this.nomeClientes = nomeClientes;
        this.valorTotal = valortotal;
        this.codVenda = codVenda;
        this.CPFCliente = CPFCliente;
    }

    // getters and setters

    public String getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(String codVenda) {
        this.codVenda = codVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCarrosVendidos() {
        return carrosVendidos;
    }

    public void setCarrosVendidos(String carrosVendidos) {
        this.carrosVendidos = carrosVendidos;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String cPFCliente) {
        CPFCliente = cPFCliente;
    }

    public String getnomeClientes() {
        return nomeClientes;
    }

    public void setnomeClientes(String nomeClientes) {
        this.nomeClientes = nomeClientes;
    }

    public String getValortotal() {
        return valorTotal;
    }

    public void setValortotal(String valortotal) {
        this.valorTotal = valortotal;
    }

    public Object getPlacaCarroVendido() {
        return null;
    }
}
