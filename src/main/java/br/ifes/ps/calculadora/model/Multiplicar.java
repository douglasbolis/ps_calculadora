package br.ifes.ps.calculadora.model;

public class Multiplicar implements IOperacao {
    public String getOperador() {
        return "*";
    }

    public double resolva(double a, double b) {
        return a * b;
    }
}
