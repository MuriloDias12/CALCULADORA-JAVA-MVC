package Control;

import Model.Operacao;
import Model.Soma;
import Model.Subtracao;
import Model.Multiplicacao;
import Model.Divisao;
import View.CalculadoraView;

public class CalculadoraControl {
    private CalculadoraView View;

    public CalculadoraControl(CalculadoraView view) {
        this.View = view;
    }

    public void iniciar() {
        View.exibirMenu();
        int opcao = View.lerOpcao();

        double num1 = View.lerNumero("Digite o primeiro número: ");
        double num2 = View.lerNumero("Digite o segundo número: ");

        Operacao operacao = null;

        switch (opcao) {
            case 1:
                operacao = new Soma();
                break;
            case 2:
                operacao = new Subtracao();
                break;
            case 3:
                operacao = new Multiplicacao();
                break;
            case 4:
                operacao = new Divisao();
                break;
            default:
                View.exibirMensagem("Opção inválida!");
                return;
        }

        try {
            double resultado = operacao.calcular(num1, num2);
            View.exibirResultado(resultado);
        } catch (ArithmeticException e) {
            View.exibirMensagem(e.getMessage());
        }
    }
}