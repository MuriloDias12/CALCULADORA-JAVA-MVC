package Application;


import View.CalculadoraView;
import Control.CalculadoraControl;

public class Main {
    public static void main(String[] args) {
        CalculadoraView view = new CalculadoraView();
        CalculadoraControl control = new CalculadoraControl(view);

        control.iniciar();
    }
}