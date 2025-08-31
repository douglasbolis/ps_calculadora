package br.ifes.ps.calculadora.model;

public class Subtrair implements IOperacao {
    public String getOperador() {
        return "-";
    }

    public double resolva(double a, double b) {
        return a - b;
    }
}
