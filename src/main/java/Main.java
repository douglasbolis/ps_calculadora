import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a, b, res;
        String op;

        System.out.println("Calculadora\n");
        System.out.println("Operações permitidas: +, -, * e /\n");

        System.out.print("Informe o primeiro número: ");
        a = Double.parseDouble(s.nextLine());

        System.out.print("Informe a operação: ");
        op = s.nextLine();

        System.out.print("Informe o segundo número: ");
        b = Double.parseDouble(s.nextLine());

        System.out.println();

        switch (op) {
            case "+" -> {
                res = a + b;
                System.out.println(a + " + " + b + " = " + res);
            }
            case "-" -> {
                res = a - b;
                System.out.println(a + " - " + b + " = " + res);
            }
            case "*" -> {
                res = a * b;
                System.out.println(a + " * " + b + " = " + res);
            }
            case "/" -> {
                if (b == 0) {
                    System.out.println("Não é possível realizar divisões por 0");
                } else {
                    res = a / b;
                    System.out.println(a + " / " + b + " = " + res);
                }
            }
            default -> System.out.println("Operação inválida");
        }
    }
}