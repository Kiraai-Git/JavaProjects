import java.util.Arrays;
import java.lang.Math;

public class BigNum {
    private int[] num;
    private int size;
    private boolean sign;

    // Clase BigNum cuando solo se recibe el entero.
    public BigNum(int x){
        String stringSize = Integer.toString(Math.abs(x));
        this.size = stringSize.length();
        this.num = new int[size];

        if(x >= 0){
            this.sign = true;
        } else {
            this.sign = false;
        }

        for (int i = 0; i < size; i++) {
            this.num[i] = stringSize.charAt(i) - '0';
        }
    }

    // Clase BigNum cuando se recibe como string junto a su boolean de signo.
    public BigNum(String x, boolean sign){
        this.size = x.length();
        this.sign = sign;
        this.num = new int[size];

        for (int i = 0; i < size; i++) {
            this.num[i] = x.charAt(i) - '0';
        }
    }

    // BigNum Add 
    public static BigNum add(BigNum x, BigNum y){
        // Se crean 2 booleanos para decidir si es resta y el signo final
        boolean esResta = (x.sign != y.sign);
        boolean signoResultado = true; 

        // Variables necesarias para la suma o resta
        int tamano = Math.max(x.size, y.size);
        int[] sum = new int[tamano + 1];
        int dig1 = 0, dig2 = 0, carry = 0, total = 0;

        // Se verifica el signo del resultado final, si x > y sera positivo en caso contrario sera negativo.
        if (esResta) {
            if (x.size < y.size) {
                BigNum temp = x;
                x = y;
                y = temp;
                signoResultado = false;
            } else if (x.size == y.size) {
                for (int i = 0; i < x.size; i++) {
                    if (x.num[i] < y.num[i]) {
                        BigNum temp = x;
                        x = y;
                        y = temp;
                        signoResultado = false;
                        break;
                    } else if (x.num[i] > y.num[i]) {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < tamano; i++) {
            // Se llena la cadena con los valores del BigNum del dig1(x).
            if(i < x.size){
                dig1 = x.num[x.size - 1 - i];
            } else {
                dig1 = 0;
            }

            // Se llena la cadena con los valores del BigNum del dig2(y).
            if(i < y.size){
                dig2 = y.num[y.size - 1 - i];
            } else {
                dig2 = 0;
            }

            // Se verifica el booleano "esResta" para saber la operacion a seguir; sumar o restar.
            if(esResta){
                total = dig1 - dig2 - carry;
            } else {
                total = dig1 + dig2 + carry;
            }

            // Se verifica el booleano "esResta" para saber la operacion a seguir; pedir prestado y/o sacar carry junto a sumar el total.
            if (esResta) {
                if (total < 0) {
                    total += 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
            } else {
                carry = total / 10;
                total = total % 10;
            }   

            // Se rellena la cadena con el total; total < 10.
            sum[tamano - i] = total;
        }

        // Se rellena el primer espacio de la cadena si el numero sumado en la ultima iteracion era total > 10.
        if (!esResta) {
            sum[0] = carry;
        }

        // Se asegura de construir el numero final sin ceros a la izquierda.
        StringBuilder resultadoSumaResta = new StringBuilder();
        boolean esCero = true;

        for (int i = 0; i < sum.length; i++) {
            if (!(resultadoSumaResta.length() == 0 && sum[i] == 0)) {
                resultadoSumaResta.append(sum[i]);
            }

            if (sum[i] != 0) {
                esCero = false;
            }
        }

        if (esCero) {
            return new BigNum("0", true);
        }

        // Retorna el resultado de la suma/resta.
        return new BigNum(resultadoSumaResta.toString(), signoResultado);
    }

    // BigNum Multiply
    public static BigNum multiply(BigNum x, BigNum y){
        int[] sum = new int[x.size + y.size];
        Arrays.fill(sum, 0);

        for (int i = 0; i < x.size; i++) {
            int carry = 0;
            for (int j = 0; j < y.size; j++) {
                int prod = x.num[x.size - 1 - i] * y.num[y.size - 1 - j] + sum[sum.length - 1 - (i + j)] + carry;
                sum[sum.length - 1 - (i + j)] = prod % 10;
                carry = prod / 10;
            } 
            sum[sum.length - 1 - (i + y.size)] += carry;
        } 

        // Se asegura de construir el numero final sin ceros a la izquierda.
        StringBuilder sumproducto = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            int digit = sum[i];
            if (!(sumproducto.length() == 0 && digit == 0)) {
                sumproducto.append(digit);
            }
        }
        
        // Se asegura del signo de la multiplicacion. 
        boolean signo = (x.sign == y.sign);

        // Retorna el resultado de la multiplicacion.
        return new BigNum(sumproducto.toString(), signo);
    }

    public String toString() {
    StringBuilder resultadofinal = new StringBuilder();
    
        // Verificar el signo
        if (sign) {
            resultadofinal.append("");
        } else {
            resultadofinal.append("-");
        }

        for (int i = 0; i < num.length; i++) {
            int digit = num[i];
            resultadofinal.append(digit);
        }

        return resultadofinal.toString();
    }

    public static void main(String[] args) {

        BigNum num1 = new BigNum("224", false);
        BigNum num2 = new BigNum("324", true);

        // Benchmark para la suma
        long InicioDeLaSuma = System.nanoTime();
        BigNum suma = BigNum.add(num1, num2);
        long FinDeLaSuma = System.nanoTime();
        System.out.println("Suma: " + suma);
        System.out.println("Tiempo de ejecucion de la suma: " + (FinDeLaSuma - InicioDeLaSuma) + " ns");

        // Benchmark para la multiplicación
        long InicioDeLaMul = System.nanoTime();
        BigNum multiplicacion = BigNum.multiply(num1, num2);
        long FinDeLaMul = System.nanoTime();
        System.out.println("Producto: " + multiplicacion);
        System.out.println("Tiempo de ejecución de la multiplicación: " + (FinDeLaMul - InicioDeLaMul) + " ns");
    }
}