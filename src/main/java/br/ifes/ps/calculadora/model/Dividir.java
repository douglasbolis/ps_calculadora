package br.ifes.ps.calculadora.model;

public class Dividir implements IOperacao {
    public String getOperador() {
        return "/";
    }

    public double resolva(double a, double b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Divisão por 0 não suportada");

        return a / b;
    }
}
