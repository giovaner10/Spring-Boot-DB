package com.projeto.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String descricao;

   private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }


    public static TipoCliente toEnum(Integer cod){
       TipoCliente tipoCliente = null;

       for(TipoCliente tipoCliente1 : TipoCliente.values()){
           if(cod.equals(tipoCliente1.getCod())){
               tipoCliente =   tipoCliente1;
           }
       }
       return tipoCliente;


    }
}
