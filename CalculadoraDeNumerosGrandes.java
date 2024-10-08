import java.util.Scanner;

public class CalculadoraDeNumerosGrandes{
    public static void main(String[] args){

        // Inicializar Scanner.
        Scanner scanner = new Scanner(System.in);

        // Pedir valores.
        System.out.println("Ingrese num1: ");
        String num1 = scanner.nextLine();
        System.out.println("Ingrese num2: ");
        String num2 = scanner.nextLine();

        // Variables para los acarreos y resultado final.
        int acarreo = 0;
        StringBuilder resultado = new StringBuilder();

        // Guardar el largo de los numeros como variable
        int lenght1 = num1.length();
        int lenght2 = num2.length();

        // Hacer que los 2 numeros tengan el mismo largo, si no es asi añadir ceros al principio del menor.
        if(lenght1 > lenght2){
            num1 = "0".repeat(lenght1-lenght2) + num1;
        }
        else if(lenght2 > lenght1){
            num2 = "0".repeat(lenght2-lenght1) + num2; 
        }

        for (int i = num1.length() - 1; i >= 0; i--) {

            int digit1 = num2.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int sum = digit1 + digit2 + acarreo;

            acarreo = sum / 10;
            int digitResult = sum % 10;

            resultado.insert(0, digitResult);
        }

        if (acarreo > 0) {
            resultado.insert(0, acarreo);
        }

        System.out.println(resultado.toString());

        scanner.close();
    }
}