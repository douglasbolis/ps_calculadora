package br.ifes.ps.calculadora.controller;

import br.ifes.ps.calculadora.model.CalcModel;

import java.lang.reflect.InvocationTargetException;

public class CalcController {
    public double calcular(String operacao, double valor1, double valor2) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CalcModel calculadora = new CalcModel();
        return calculadora.calcula(operacao, valor1, valor2);
    }
}