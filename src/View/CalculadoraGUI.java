package View;

import Control.CalculadoraControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame {
    private JTextField campoNum1, campoNum2, campoResultado;
    private JButton botaoSoma, botaoSubtracao, botaoMultiplicacao, botaoDivisao;
    private CalculadoraControl control;

    public CalculadoraGUI() {
        // Configurações da janela
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Inicializa o controlador
        control = new CalculadoraControl();

        // Cria os componentes da interface
        campoNum1 = new JTextField();
        campoNum2 = new JTextField();
        campoResultado = new JTextField();
        campoResultado.setEditable(false); // Resultado não pode ser editado

        botaoSoma = new JButton("Somar");
        botaoSubtracao = new JButton("Subtrair");
        botaoMultiplicacao = new JButton("Multiplicar");
        botaoDivisao = new JButton("Dividir");

        // Adiciona os componentes à janela
        add(new JLabel("Número 1:"));
        add(campoNum1);
        add(new JLabel("Número 2:"));
        add(campoNum2);
        add(new JLabel("Resultado:"));
        add(campoResultado);
        add(botaoSoma);
        add(botaoSubtracao);
        add(botaoMultiplicacao);
        add(botaoDivisao);

        // Configura os listeners dos botões
        botaoSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacao("soma");
            }
        });

        botaoSubtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacao("subtracao");
            }
        });

        botaoMultiplicacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacao("multiplicacao");
            }
        });

        botaoDivisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacao("divisao");
            }
        });
    }

    private void calcularOperacao(String operacao) {
        try {
            double num1 = Double.parseDouble(campoNum1.getText());
            double num2 = Double.parseDouble(campoNum2.getText());
            double resultado = 0;

            switch (operacao) {
                case "soma":
                    resultado = control.calcular(num1, num2, "soma");
                    break;
                case "subtracao":
                    resultado = control.calcular(num1, num2, "subtracao");
                    break;
                case "multiplicacao":
                    resultado = control.calcular(num1, num2, "multiplicacao");
                    break;
                case "divisao":
                    resultado = control.calcular(num1, num2, "divisao");
                    break;
            }

            campoResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida! Digite números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Executa a interface gráfica na thread de eventos do Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraGUI().setVisible(true);
            }
        });
    }
}