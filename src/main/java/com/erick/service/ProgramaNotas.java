package com.erick.service;

import com.erick.exception.AlunoException;
import com.erick.model.Chaiene;
import com.erick.model.Resultado;

import java.util.List;
import java.util.Optional;

public class ProgramaNotas {
    public static final int NUMERO_MAXIMO_NOTAS = 4;
    public static final double NOTA_PASSADO = 7.0;
    public static final double NOTA_REPROVADO = 3.0;
    public static final double MEDIA_MAXIMA = 10.0;

    @Chaiene("EXERCÍCIO 2")
    public Resultado calcularNotasDoAluno(List<Double> notasAluno) {
        verificarQuantidadeNotas(notasAluno);
        verificarNotasNegativas(notasAluno);
        verificarNotasAlemLimite(notasAluno);

        double notaMedia = notasAluno.stream()
                .mapToDouble(x -> x)
                .average()
                .getAsDouble();

        if (notaMedia >= NOTA_PASSADO) {
            return Resultado.APROVADO;
        } else if (notaMedia > NOTA_REPROVADO) {
            return Resultado.EM_RECUPERACAO;
        } else {
            return Resultado.REPROVADO;
        }
    }

    private void verificarQuantidadeNotas(List<Double> notas) {
        if (notas.size() > NUMERO_MAXIMO_NOTAS || notas.size() == 0) {
            throw new AlunoException(AlunoException.QUANTIDADE_NOTAS_INVALIDA);
        }
    }

    private void verificarNotasNegativas(List<Double> notas) {
        Optional<Double> notaNegativa = notas.stream().filter(nota -> nota < 0).findAny();

        if (notaNegativa.isPresent()) {
            throw new AlunoException(AlunoException.VALOR_NOTA_INVALIDA);
        }
    }

    private void verificarNotasAlemLimite(List<Double> notas) {
        Optional<Double> notaNegativa = notas.stream().filter(nota -> nota > MEDIA_MAXIMA).findAny();

        if (notaNegativa.isPresent()) {
            throw new AlunoException(AlunoException.VALOR_NOTA_INVALIDA);
        }
    }
}
