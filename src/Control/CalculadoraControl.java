package Control;

import Model.*;

public class CalculadoraControl {
    public double calcular(double num1, double num2, String operacao) {
        Operacao operacaoMatematica = null;

        switch (operacao) {
            case "soma":
                operacaoMatematica = new Soma();
                break;
            case "subtracao":
                operacaoMatematica = new Subtracao();
                break;
            case "multiplicacao":
                operacaoMatematica = new Multiplicacao();
                break;
            case "divisao":
                operacaoMatematica = new Divisao();
                break;
            default:
                throw new IllegalArgumentException("Operação inválida!");
        }

        return operacaoMatematica.calcular(num1, num2);
    }
}