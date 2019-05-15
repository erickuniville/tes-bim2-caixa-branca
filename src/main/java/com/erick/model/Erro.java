package com.erick.model;

public class Erro {
    private String codigoErro;
    private String nomeErro;

    public Erro(String codigoErro, String nomeErro) {
        this.codigoErro = codigoErro;
        this.nomeErro = nomeErro;
    }

    public String getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(String codigoErro) {
        this.codigoErro = codigoErro;
    }

    public String getNomeErro() {
        return nomeErro;
    }

    public void setNomeErro(String nomeErro) {
        this.nomeErro = nomeErro;
    }
}
