package com.erick.exception;

import com.erick.model.Erro;

public class AlunoException extends RuntimeException {
    public static final Erro QUANTIDADE_NOTAS_INVALIDA = new Erro("ERRO_ALUNO_01", "Quantidade de notas inválida");
    public static final Erro VALOR_NOTA_INVALIDA = new Erro("ERRO_ALUNO_02", "Valor da nota inválida");

    private String codigoErro;
    private String nomeErro;
    private String detalhes;

    public AlunoException(Erro erro) {
        super();
        codigoErro = erro.getCodigoErro();
        nomeErro = erro.getNomeErro();
    }

    public AlunoException(Erro erro, String detalhes) {
        super(detalhes);
        codigoErro = erro.getCodigoErro();
        nomeErro = erro.getNomeErro();
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

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
