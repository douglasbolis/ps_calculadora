package br.ifes.ps.calculadora.controller;

import br.ifes.ps.calculadora.model.CalcModel;

import java.lang.reflect.InvocationTargetException;

public class CalcController {
    public double calcular(String operacao, double valor1, double valor2){
        double resultado = 0;

        try {
            CalcModel calculadora = new CalcModel();
            resultado = calculadora.calcula(operacao, valor1, valor2);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException error) {
            System.out.println("Ocorreu um erro ao instanciar uma das operações usando Java Reflections...");
        }
        
        return resultado;
    }
}