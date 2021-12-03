package com.projeto.domain.local;

import com.projeto.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteEndereco;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;


}
