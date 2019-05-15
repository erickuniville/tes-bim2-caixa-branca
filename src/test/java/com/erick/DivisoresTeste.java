package com.erick;

import com.erick.service.ProgramaDivisores;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisoresTeste {
    private ProgramaDivisores programa;
    private final static long NUMERO_PRIMO = 104_723;

    public DivisoresTeste() {
        programa = new ProgramaDivisores();
    }

    @Test
    public void testarObterDivisoresDeZero() {
        List<Long> divisores = programa.obterDivisores(0);

        assertThat(divisores).hasSize(0);
    }

    @Test
    public void testarObterDivisoresDeUm() {
        List<Long> divisores = programa.obterDivisores(1);

        assertThat(divisores)
                .hasSize(1)
                .contains(1L);
    }

    @Test
    public void testarObterDivisoresDeUmNumeroPrimo() {
        List<Long> divisores = programa.obterDivisores(NUMERO_PRIMO);

        assertThat(divisores)
                .hasSize(2)
                .contains(1L)
                .contains(NUMERO_PRIMO);
    }

    @Test
    public void testarObterDivisoresDeUmNumeroComMuitosDivisores() {
        final int numeroComposto = 72;
        final int quantidadeDeDivisores = 12;

        List<Long> divisores = programa.obterDivisores(numeroComposto);

        assertThat(divisores).hasSize(quantidadeDeDivisores);
    }
}
