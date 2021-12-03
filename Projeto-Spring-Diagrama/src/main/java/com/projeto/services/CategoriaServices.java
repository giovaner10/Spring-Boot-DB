package com.projeto.services;

import com.projeto.domain.item.Categoria;
import com.projeto.services.excessoes.ObjectNotFoundException;
import com.projeto.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class CategoriaServices {

    private final CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException
                        ("Objeto não encontrado! ID: " + id + ", Tipo"+ Categoria.class.getName()));
    }
}
