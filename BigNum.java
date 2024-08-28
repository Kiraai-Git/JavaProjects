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
        boolean esResta = x.sign != y.sign;
        boolean esResultadoNegativo = false; 

        if (esResta && compareAbs(x, y) < 0) {
            BigNum temp = x;
            x = y;
            y = temp;
            isNegativeResult = true; // Indicar que el resultado final debe ser negativo
        }

        int tamano = Math.max(x.size, y.size);
        int[] sum = new int[tamano + 1];
        int dig1, dig2;
        int carry = 0;
        int total = 0;

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

            if(esResta){
                total = dig1 - dig2 - carry;
            } else {
                total = dig1 + dig2 + carry;
            }

            System.out.println(total);
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

            sum[tamano - i] = total;
        }

        if (!esResta) {
            sum[0] = carry;
        }

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

        StringBuilder sumproducto = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            int digit = sum[i];
            if (!(sumproducto.length() == 0 && digit == 0)) {
                sumproducto.append(digit);
            }
        }

        boolean signo = (x.sign == y.sign);

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

        BigNum num1 = new BigNum("123", false);
        BigNum num2 = new BigNum("321", true);

        BigNum suma = BigNum.add(num1, num2);
        BigNum multiplicacion = BigNum.multiply(num1, num2);

        System.out.println("Suma: " + suma);
        System.out.println("Producto: " + multiplicacion);
    }
}