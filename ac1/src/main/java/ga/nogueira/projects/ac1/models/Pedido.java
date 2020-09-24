package ga.nogueira.projects.ac1.models;

public class Pedido {
    private int codPedido;
    private double valor;
    private String descricao;
    private String cliente;
    private String dataPedido;

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", codPedido=" + codPedido + ", dataPedido=" + dataPedido + ", descricao="
                + descricao + ", valor=" + valor + "]";
    }

    public Pedido(int codPedido, double valor, String descricao, String cliente, String dataPedido) {
        this.codPedido = codPedido;
        this.valor = valor;
        this.descricao = descricao;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
    }
    
    public Pedido(){}
    
}
