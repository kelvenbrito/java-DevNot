package Model;

public class Vendas {
    // =============Atributos=============
     private String idSerial;
    private String cpf;
    private String totalCompra;
    private String dataHora;
   

    // =============Construtor=============
    public Vendas(String idSerial, String cpf, String totalCompra, String dataHora) {
         this.idSerial = idSerial;
        this.cpf = cpf;
        this.totalCompra = totalCompra;
        this.dataHora = dataHora;
       
    }

    // =============Get and Set=============
      public String getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(String idSerial) {
        this.idSerial = idSerial;
    }

        public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(String totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

  

}
