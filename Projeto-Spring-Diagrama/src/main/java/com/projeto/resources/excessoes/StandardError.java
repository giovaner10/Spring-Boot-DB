package com.projeto.resources.excessoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor @Getter @Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private  Integer statusErr;
    private String msgErr;
    private Long timeStampErr;
}
