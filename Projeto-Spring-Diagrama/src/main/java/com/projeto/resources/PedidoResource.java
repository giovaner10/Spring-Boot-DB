package com.projeto.resources;

import com.projeto.domain.pedido.Pedido;
import com.projeto.services.PedidoServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@RequestMapping(path = "/pedidos")
public class PedidoResource {

    private final PedidoServices pedidoServices;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id){
    System.out.println("deu bom");
        return new ResponseEntity<>(pedidoServices.findById(id), HttpStatus.OK);
    }
}
