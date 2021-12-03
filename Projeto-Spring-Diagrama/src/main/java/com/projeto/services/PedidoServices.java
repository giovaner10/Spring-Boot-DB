package com.projeto.services;

import com.projeto.domain.item.Categoria;
import com.projeto.domain.pedido.Pedido;
import com.projeto.repositories.PedidoRepository;
import com.projeto.services.excessoes.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class PedidoServices {

    private final PedidoRepository pedidoRepository;

    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException
                        ("Objeto não encontrado! ID: " + id + ", Tipo"+ Categoria.class.getName()));
    }
}
