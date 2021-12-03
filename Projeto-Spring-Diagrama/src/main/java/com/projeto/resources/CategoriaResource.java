package com.projeto.resources;

import com.projeto.domain.item.Categoria;
import com.projeto.services.CategoriaServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@RequestMapping(path = "/categorias")
public class CategoriaResource {

    private final CategoriaServices categoriaServices;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
    System.out.println("deu bom");
        return new ResponseEntity<>(categoriaServices.findById(id), HttpStatus.OK);
    }
}
