package br.ifes.ps.calculadora.model;

public interface IOperacao {
    String getOperador();
    double resolva(double a, double b);
}
