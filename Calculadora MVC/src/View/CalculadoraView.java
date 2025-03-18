package View;



import java.util.Scanner;

public class CalculadoraView {
    private Scanner scanner;

    public CalculadoraView() {
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Escolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
    }

    public int lerOpcao() {
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public double lerNumero(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }

    public void exibirResultado(double resultado) {
        System.out.println("Resultado: " + resultado);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
