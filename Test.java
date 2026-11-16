import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        System.out.println("Probando VSCode...");

        int suma = 0;
        for (int i = 1; i <= 10; i++) {
            suma += i;
        }
        System.out.println("Suma del 1 al 10: " + suma);

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("funciona");
        lista.add("bien");

        for (String palabra : lista) {
            System.out.println(palabra);
        }

        int[] numeros = {5, 3, 8, 1, 9};
        int max = numeros[0];
        for (int n : numeros) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println("El numero mayor es: " + max);
    }
}