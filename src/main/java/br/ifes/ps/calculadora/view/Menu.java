package br.ifes.ps.calculadora.view;

import br.ifes.ps.calculadora.controller.CalcController;
import br.ifes.ps.calculadora.model.IOperacao;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> operadores = new ArrayList<>();
    private Map<String, IOperacao> operacoes = new HashMap<>();
    private CalcController calculadora;

    public Menu() {
        try {
            this.calculadora = new CalcController();
            this.operacoes = this.calculadora.getOperacoes();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException error) {
            System.out.println("Ocorreu um erro ao instanciar uma das operações usando Java Reflections...");
        }
    }

    private void showMenu() {
        System.out.println("Calculadora Simples");
        System.out.println("Operações suportadas:");

        for(String operador : this.operacoes.keySet()) {
            this.operadores.add(operador);
            IOperacao operacao = this.operacoes.get(operador);
            System.out.println(operador + " => " + operacao.getClass().getSimpleName());
        }

        this.operadores.add("0");
        System.out.println("0 => Sair\n");
    }

    private String getOperacao() {
        boolean operacaoValida = false;
        String operador = "";

        while (!operacaoValida) {
            System.out.print("Informe a operação: ");
            operador = scanner.nextLine();

            if (this.operadores.contains(operador)) {
                operacaoValida = true;
            } else {
                System.out.println("Operação inválida! Informe-a novamente.");
            }
        }

        return operador;
    }

    private double getNumero(String mensagem) {
        boolean numeroValido = false;
        double numero = 0.0;

        while (!numeroValido) {
            try {
                System.out.print(mensagem);
                numero = Double.parseDouble(scanner.nextLine());
                numeroValido = true;
            } catch (NumberFormatException error) {
                System.out.println("Número inválido! Informe-o novamente.");
            }
        }

        return numero;
    }

    public void start() {
        try {
            this.showMenu();

            String operacao = getOperacao();

            if (!operacao.equals("0")) {
                double valorA = getNumero("Informe o primeiro número: ");
                double valorB = getNumero("Informe o segundo número: ");
                double resultado = calculadora.calcular(operacao, valorA, valorB);

                System.out.println("Resultado:");
                System.out.println(valorA + " " + operacao + " " + valorB + " = " + resultado);
            } else {
                System.out.println("Calculadora encerrada!");
            }
        } catch (ArithmeticException | NullPointerException error) {
            System.out.println(error.getMessage());
        }
    }
}
