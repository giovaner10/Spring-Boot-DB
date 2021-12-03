package com.projeto.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "PENDENTE"),
    QUITADO(2, "QUITADO"),
    CANCELADO(3, "CANCELADO");

    private int cod;
    private String descricao;

   private EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }


    public static EstadoPagamento toEnum(Integer cod){
       EstadoPagamento estado = null;

       for(EstadoPagamento estadoPagamento : EstadoPagamento.values()){
           if(cod.equals(estadoPagamento.getCod())){
               estado =  estadoPagamento;
           }
       }
       return estado;


    }
}
