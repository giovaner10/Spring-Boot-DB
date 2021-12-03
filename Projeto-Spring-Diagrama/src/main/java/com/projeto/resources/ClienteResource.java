package com.projeto.resources;

import com.projeto.domain.Cliente;
import com.projeto.services.ClienteServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@RequestMapping(path = "/clientes")
public class ClienteResource {

    private final ClienteServices clienteServices;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
    System.out.println("deu bom");
        return new ResponseEntity<>(clienteServices.findById(id), HttpStatus.OK);
    }
}
