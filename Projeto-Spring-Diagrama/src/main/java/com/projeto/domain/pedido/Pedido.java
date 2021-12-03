package com.projeto.domain.pedido;

import com.projeto.domain.Cliente;
import com.projeto.domain.ItemPedido;
import com.projeto.domain.local.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instante;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clientePedido;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(Integer id, Date instante, Cliente clientePedido, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instante = instante;
        this.clientePedido = clientePedido;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
}
