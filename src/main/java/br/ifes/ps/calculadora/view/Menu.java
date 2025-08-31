package br.ifes.ps.calculadora.view;

import br.ifes.ps.calculadora.controller.CalcController;
import br.ifes.ps.calculadora.model.IOperacao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.reflections.Reflections;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CalcController calculadora = new CalcController();
    private final List<String> operadores = new ArrayList<>();

    private void showMenu() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Calculadora\n");
        System.out.println("Operações suportadas:");

        Reflections reflections = new Reflections("br.ifes.ps.calculadora.model");
        Set<Class<? extends IOperacao>> modelOperacoes = reflections.getSubTypesOf(IOperacao.class);

        for(Class<? extends IOperacao> modelOperacao : modelOperacoes) {
            IOperacao operacao = modelOperacao.getDeclaredConstructor().newInstance();
            String operador = operacao.getOperador();
            this.operadores.add(operador);

            System.out.println(operador + " => " + modelOperacao.getSimpleName());
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
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException error) {
            System.out.println("Ocorreu um erro ao instanciar uma das operações usando Java Reflections...");
        } catch (ArithmeticException | NullPointerException error) {
            System.out.println(error.getMessage());
        }
    }
}
