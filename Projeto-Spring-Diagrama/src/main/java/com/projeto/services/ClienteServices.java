package com.projeto.services;

import com.projeto.domain.Cliente;
import com.projeto.domain.item.Categoria;
import com.projeto.repositories.ClienteRepository;
import com.projeto.services.excessoes.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class ClienteServices {

    private final ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException
                        ("Objeto não encontrado! ID: " + id + ", Tipo"+ Categoria.class.getName()));
    }
}
