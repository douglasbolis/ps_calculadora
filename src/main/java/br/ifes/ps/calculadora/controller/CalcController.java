package br.ifes.ps.calculadora.controller;

import br.ifes.ps.calculadora.model.CalcModel;
import br.ifes.ps.calculadora.model.IOperacao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CalcController {
    private final CalcModel calculadora;

    public CalcController() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.calculadora = new CalcModel();
    }

    public double calcular(String operacao, double valor1, double valor2) {
        return calculadora.calcula(operacao, valor1, valor2);
    }

    public Map<String, IOperacao> getOperacoes() {
        return this.calculadora.getOperacoes();
    }
}