package pkg_vista;

import java.util.Scanner;

public class EntradaSalidaDatos {
    private Scanner sc;

    public EntradaSalidaDatos() {
        sc = new Scanner(System.in);
    }
    
    public void mostrarResultado(int resultado) {
        mostrarCadena("Resultado: " + resultado);
    }
    
    public void mostrarCadena(String cadena) {
        System.out.println(cadena);
    }
    
    public String pedirCadena() {
        String cadena = sc.nextLine();
        return cadena;
    }
    
    public boolean pedirBoolean() {
        boolean b = sc.nextBoolean();
        return b;
    }
    
    public int pedirValorEnteroPositivo() {
        int valor = 0;
        boolean valido = false;
        do {
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor < 0) {
                    sc.nextLine();
                    System.out.println("¡Tiene que ser un valor positivo!");
                } else {
                    valido = true;
                }
            } else {
                sc.nextLine();
                System.out.println("¡Tiene que ser un valor entero!");
            }
        } while (!valido);
        return valor;
    }
}
