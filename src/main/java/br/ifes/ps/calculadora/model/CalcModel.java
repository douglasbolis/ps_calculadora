package br.ifes.ps.calculadora.model;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CalcModel {
    private final Map<String, IOperacao> operacoes = new HashMap<>();

    public CalcModel() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("br.ifes.ps.calculadora.model");
        Set<Class<? extends IOperacao>> modelOperacoes = reflections.getSubTypesOf(IOperacao.class);

        for(Class<? extends IOperacao> modelOperacao : modelOperacoes) {
            IOperacao operacao = modelOperacao.getDeclaredConstructor().newInstance();
            this.operacoes.put(operacao.getOperador(), operacao);
        }
    }

    public double calcula(String operacao, double valorA, double valorB) throws NullPointerException, ArithmeticException {
        IOperacao operacaoCalc = this.operacoes.get(operacao);

        if (operacaoCalc == null) throw new NullPointerException("Operação inválida!");

        return operacaoCalc.resolva(valorA, valorB);
    }
}