package com.erick.service;

import com.erick.model.Chaiene;

import java.util.ArrayList;
import java.util.List;

public class ProgramaDivisores {
    @Chaiene("EXERCÍCIO 1")
    public List<Long> obterDivisores(long numero) {
        List<Long> divisores = new ArrayList<>();

        for (long i=1; i<=numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }

        return divisores;
    }
}
