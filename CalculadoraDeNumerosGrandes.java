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

        for(int i = 0; i < num1.length(); i++){

        }

        scanner.close();
    }
}