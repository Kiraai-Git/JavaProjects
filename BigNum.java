import java.util.Arrays;

public class BigNum {
    private int[] num;
    private int size;
    private boolean sign;

    public BigNum(int x){
        String strSize = Integer.toString(Math.abs(x));
        this.size = strSize.length();
        this.num = new int[size];  // Revisar si es size o size - 1

        if(x >= 0){
            this.sign = true;
        } else {
            this.sign = false;
        }

        for (int i = 0; i < size; i++) {
            this.num[i] = strSize.charAt(i) - '0';
        }
    }

    public BigNum(String x, boolean sign){
        this.size = x.length();
        this.sign = sign;
        this.num = new int[size];

        for (int i = 0; i < size; i++) {
            this.num[i] = x.charAt(i) - '0';
        }
    }

    public static BigNum add(BigNum x, BigNum y){
        int tamano = Math.max(x.size, y.size);
        int[] sum = new int[tamano + 1];
        int carry = 0;
        int dig1, dig2;

        for (int i = 0; i < tamano; i++) {
            if(i < x.size){
                dig1 = x.num[x.size - 1 - i];
            } else {
                dig1 = 0;
            }

            if(i < y.size){
                dig2 = y.num[y.size - 1 - i];
            } else {
                dig2 = 0;
            }

            int total = dig1 + dig2 + carry;
            sum[tamano - i] = total % 10;
            carry = total / 10;
        }
        sum[0] = carry;

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            int digit = sum[i];
            
            if (resultado.length() == 0 && digit == 0) {
                // No hacer nada si es un cero inicial
            } else {
                resultado.append(digit);
            }
        }

        return new BigNum(resultado.toString(), true);
    }

    /*
    public static BigNum multiply(BigNum x, BigNum y){
        int tamano = Math.max(x.size, y.size);
        int[] sum = new int[tamano + 1];
        int carry = 0;
        Arrays.fill(sum, 0);

        for (int i = 0; i < x.size; i++) {
            for (int j = 0; j < y.size; j++) {          //Hacer esto fuera de el programa y entenderlo

            }
        }  
    }
    */

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
        BigNum num1 = new BigNum("12345678901234567890", true);
        BigNum num2 = new BigNum("98765432109876543210", true);

        BigNum suma = BigNum.add(num1, num2);
        BigNum multiplicacion = BigNum.multiply(num1, num2);

        System.out.println("Suma: " + suma);
        System.out.println("Producto: " + multiplicacion);
    }
}