package com.projeto.domain;

import com.projeto.domain.item.Produto;
import com.projeto.domain.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor @Getter @Setter
@Entity
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

     public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
         id.setPedido(pedido);
         id.setProduto(produto);
         this.desconto = desconto;
         this.quantidade = quantidade;
         this.preco = preco;
     }
    @JsonIgnore
     public Pedido getPedido(){
         return  id.getPedido();
     }

     public Produto getProduto(){
         return  id.getProduto();
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido pedido = (ItemPedido) o;
        return id.equals(pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
