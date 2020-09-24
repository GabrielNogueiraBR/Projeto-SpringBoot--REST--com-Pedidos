package ga.nogueira.projects.ac1.repository;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ga.nogueira.projects.ac1.models.Pedido;


@Component
public class PedidoRepository {
    private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    private int nextIndice = 1;

    @PostConstruct
    public void inicializarLista(){
        final Pedido p1 = new Pedido();

        p1.setCodPedido(nextIndice++);
        p1.setDescricao("Pedido de mouse gamer");
        p1.setValor(15.3);
        p1.setCliente("João Pedro");
        p1.setDataPedido("24-09-2020");

        listaPedidos.add(p1);
    }

    public Pedido cadastarPedido(Pedido pedido){
        pedido.setCodPedido(nextIndice++);
        listaPedidos.add(pedido);
        return pedido;
    }

    public ArrayList<Pedido> getAllPedidos(){
        return listaPedidos;
    }

    public Pedido getPedidoByCodigo(int codigo){
        
        for (Pedido pedido : listaPedidos) {
            if(pedido.getCodPedido() == codigo){
                return pedido;
            }
        }

        return null;
    }

    public void deletePedido(Pedido pedido){
        listaPedidos.remove(pedido);
    }

	public void atualizaPedido(Pedido pedido) {
        
        Pedido p = getPedidoByCodigo(pedido.getCodPedido());

        if(p != null){
            p.setCliente(pedido.getCliente());
            p.setDataPedido(pedido.getDataPedido());
            p.setDescricao(pedido.getDescricao());
            p.setValor(pedido.getValor());
        }

	}
}
