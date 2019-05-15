package com.erick;

import com.erick.exception.AlunoException;
import com.erick.service.ProgramaNotas;
import com.erick.model.Resultado;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class NotasTeste {
    private ProgramaNotas programa;

    public NotasTeste() {
        programa = new ProgramaNotas();
    }

    @Test
    public void testarNumeroMaximoNotasExcedido() {
        final double NOTA_QUALQUER = 8.0;

        List<Double> notasAluno = Collections.nCopies(ProgramaNotas.NUMERO_MAXIMO_NOTAS + 1, NOTA_QUALQUER);

        Throwable throwable = catchThrowable(() -> programa.calcularNotasDoAluno(notasAluno));

        assertThat(throwable).isInstanceOf(AlunoException.class);

        AlunoException alunoException = (AlunoException) throwable;

        assertThat(alunoException.getCodigoErro()).isEqualTo(AlunoException.QUANTIDADE_NOTAS_INVALIDA.getCodigoErro());
    }

    @Test
    public void testarCalcularListaComNenhumaNota() {
        List<Double> listaComNenhumaNota = new ArrayList<>();

        Throwable throwable = catchThrowable(() -> programa.calcularNotasDoAluno(listaComNenhumaNota));

        assertThat(throwable).isInstanceOf(AlunoException.class);

        AlunoException alunoException = (AlunoException) throwable;

        assertThat(alunoException.getCodigoErro()).isEqualTo(AlunoException.QUANTIDADE_NOTAS_INVALIDA.getCodigoErro());
    }

    @Test
    public void testarNotaNegativa() {
        List<Double> listaComNotaNegativa = Arrays.asList(8.0, 9.0, 10.0, -1.0);

        Throwable throwable = catchThrowable(() -> programa.calcularNotasDoAluno(listaComNotaNegativa));

        assertThat(throwable).isInstanceOf(AlunoException.class);

        AlunoException alunoException = (AlunoException) throwable;

        assertThat(alunoException.getCodigoErro()).isEqualTo(AlunoException.VALOR_NOTA_INVALIDA.getCodigoErro());
    }

    @Test
    public void testarNotaAcimaDoValorMaximo() {
        List<Double> listaComNotaAcimaDoMaximo = Arrays.asList(8.0, 9.0, 10.0, ProgramaNotas.MEDIA_MAXIMA + 1);

        Throwable throwable = catchThrowable(() -> programa.calcularNotasDoAluno(listaComNotaAcimaDoMaximo));

        assertThat(throwable).isInstanceOf(AlunoException.class);

        AlunoException alunoException = (AlunoException) throwable;

        assertThat(alunoException.getCodigoErro()).isEqualTo(AlunoException.VALOR_NOTA_INVALIDA.getCodigoErro());
    }

    @Test
    public void testarNotaPassado() {
        double mediaNecessaria = ProgramaNotas.NOTA_PASSADO;

        List<Double> listaComNotaNegativa = Arrays.asList(mediaNecessaria + 1, mediaNecessaria - 1, mediaNecessaria - 2, mediaNecessaria + 2);

        Resultado resultadoAluno = programa.calcularNotasDoAluno(listaComNotaNegativa);

        assertThat(resultadoAluno).isEqualByComparingTo(Resultado.APROVADO);
    }

    @Test
    public void testarNotaEmRecuperacao() {
        double mediaNecessaria = ProgramaNotas.NOTA_PASSADO;

        List<Double> listaComNotaNegativa = Arrays.asList(mediaNecessaria - 1, mediaNecessaria - 1, mediaNecessaria - 2, mediaNecessaria + 2);

        Resultado resultadoAluno = programa.calcularNotasDoAluno(listaComNotaNegativa);

        assertThat(resultadoAluno).isEqualByComparingTo(Resultado.EM_RECUPERACAO);
    }

    @Test
    public void testarNotaReprovado() {
        List<Double> listaComNotaNegativa = Arrays.asList(0D, 1D, 0D, 0D);

        Resultado resultadoAluno = programa.calcularNotasDoAluno(listaComNotaNegativa);

        assertThat(resultadoAluno).isEqualByComparingTo(Resultado.REPROVADO);
    }
}
