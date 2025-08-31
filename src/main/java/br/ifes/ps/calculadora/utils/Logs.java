package br.ifes.ps.calculadora.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logs {
    private final Logger logs;

    public Logs(Class<?> localClass) {
         this.logs = LoggerFactory.getLogger(localClass);
    }

    public void info (String message) {
        logs.info(message);
    }

    public void error (String message) {
        logs.info(message);
    }
}
