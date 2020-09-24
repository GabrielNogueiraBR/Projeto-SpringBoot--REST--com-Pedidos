package ga.nogueira.projects.ac1.controllers;

import org.springframework.web.bind.annotation.RestController;

import ga.nogueira.projects.ac1.models.Pedido;
import ga.nogueira.projects.ac1.repository.PedidoRepository;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedidos")
    public ArrayList<Pedido> getAllPedidos(){
        return pedidoRepository.getAllPedidos();
    }

    @GetMapping("/pedidos/{codigo}")
    public ResponseEntity<Pedido> getPedidoByCodigo(@PathVariable final int codigo){
        
        Pedido pedido = pedidoRepository.getPedidoByCodigo(codigo);
        if(pedido != null)
            return ResponseEntity.ok(pedido);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Void> cadastrarPedido(@RequestBody Pedido pedido){
        
        pedido = pedidoRepository.cadastarPedido(pedido);

        URI uri;
        uri= URI.create("http://localhost:8080/pedidos/" + pedido.getCodPedido());
        return ResponseEntity.created(uri).build();
    }
    
    @DeleteMapping("/pedidos/{codigo}")
    public ResponseEntity<Void> deletarPedido(@PathVariable final int codigo){
        
        Pedido pedido = pedidoRepository.getPedidoByCodigo(codigo);

        if(pedido != null)
        {
            pedidoRepository.deletePedido(pedido);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();

    }

    @PutMapping("/pedidos/{codigo}")
    public ResponseEntity<Pedido> atualizaPedido(@PathVariable final int codigo, @RequestBody Pedido pedido)
    {
        Pedido p = pedidoRepository.getPedidoByCodigo(codigo);

        if(p != null){
            pedido.setCodPedido(p.getCodPedido());
            pedidoRepository.atualizaPedido(pedido);
            return ResponseEntity.ok(pedido);
        }
        else
            return ResponseEntity.notFound().build();


    }
    

}
