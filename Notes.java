// Accesos rapidos utiles

    /*
        -Para Seleccionar la linea
        CTRL + l 
    */

// Librerias utiles

    /*
        -java.util.Scanner

        Es una clase de Java que se utiliza para leer y procesar entradas de diversas fuentes, como la consola, archivos o cadenas.
    */

// Tutorial Video

    /*
        Video utilizado para aprender Java : https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1119s

        Me quede en el minuto: 3:24:15


        Minutos por aprender

        #19 (02:06:30)  ArrayList 🧾
        #20 (02:11:02)  2D ArrayList 📜
        #21 (02:17:35)  for-each loop 🔃
        #25 (02:49:25)  final keyword ⛔
        #26 (02:51:24)  objects (OOP) ☕
    */



// StringBuilder es una herramienta poderosa para manipular cadenas de manera eficiente en Java

    /*
        Metodos mas comunes de uso:

        append(): Añade una secuencia de caracteres al final del objeto.

            StringBuilder sb = new StringBuilder("Hola");
            sb.append(" Mundo");
            System.out.println(sb.toString()); // "Hola Mundo"

        insert(): Inserta una secuencia de caracteres en una posición específica.

            sb.insert(5, "Querido ");
            System.out.println(sb.toString()); // "Hola Querido Mundo"

        delete(): Elimina una subsecuencia de caracteres dentro del objeto.

            sb.delete(5, 12);
            System.out.println(sb.toString()); // "Hola Mundo"

        reverse(): Invierte la secuencia de caracteres.

            sb.reverse();
            System.out.println(sb.toString()); // "odnuM aloH"

        toString(): Convierte el contenido de StringBuilder a un String.

            String result = sb.toString();
    */

//Data Types

    /*
        data type       size        primitive/reference       value
        -------------------------------------------------------------
        boolean         1 bit       primitive                 true or false

        byte            1 byte      primitive                 -128 to 127

        short           2 bytes     primitive                 -32,768 to 32,767

        int             4 bytes     primitive                 -2 billion to 2 billion

        long            8 bytes     primitive                 -9 quintillion to 9 quintillion

        float           4 bytes     primitive                 fractional number up to 6-7 digits
                                                              ex. 3.141592f

        double          8 bytes     primitive                 fractional number up to 15 digits
                                                              ex. 3.141592653589793

        char            2 bytes     primitive                 single character/letter/ASCII value
                                                              ex. 'f'

        String          varies      reference                 a sequence of characters
                                                              ex. "Hello world!"
    */

//Primitive VS Reference


    /*
        primitive                           VS                            reference
        ---------------------------------------------------------------------------------
        • 8 types (boolean, byte, etc.)                            • unlimited (user defined)

        • stores data                                              • stores an address

        • can only hold 1 value                                    • could hold more than 1 value

        • less memory                                              • more memory

        • fast                                                     • slower
    */

// String methods

    /*
        1. length()
            Descripción: Devuelve la longitud de la cadena.
            Ejemplo:

                String str = "Hello";
                int len = str.length(); // len es 5    

        2. charAt(int index)
            Descripción: Devuelve el carácter en la posición especificada.
            Ejemplo:

                String str = "Hello";
                char c = str.charAt(1); // c es 'e'

            //Cabe recalcar que para obtener un numero se debe restar 0

        3. substring(int beginIndex)
            Descripción: Devuelve una nueva cadena que es un subconjunto de la cadena original, 
                         comenzando desde el índice especificado hasta el final de la cadena.
            Ejemplo:

                String str = "Hello";
                String substr = str.substring(2); // substr es "llo"

        4. substring(int beginIndex, int endIndex)
            Descripción: Devuelve una nueva cadena que es un subconjunto de la cadena original, comenzando desde beginIndex y terminando en endIndex - 1.
            Ejemplo:

                String str = "Hello";
                String substr = str.substring(1, 4); // substr es "ell"
        
        5. indexOf(String str)
            Descripción: Devuelve el índice de la primera aparición de la subcadena especificada. Si no se encuentra, devuelve -1.
            Ejemplo:

                String str = "Hello";
                int index = str.indexOf("l"); // index es 2

        6. lastIndexOf(String str)
            Descripción: Devuelve el índice de la última aparición de la subcadena especificada. Si no se encuentra, devuelve -1.
            Ejemplo:

                String str = "Hello";
                int index = str.lastIndexOf("l"); // index es 3

        7. contains(CharSequence s)
            Descripción: Devuelve true si la cadena contiene la secuencia de caracteres especificada.
            Ejemplo:

                String str = "Hello";
                boolean contains = str.contains("ell"); // contains es true

        8. equals(Object obj)
            Descripción: Compara la cadena con el objeto especificado para ver si son iguales.
            Ejemplo:

                String str1 = "Hello";
                String str2 = "Hello";
                boolean isEqual = str1.equals(str2); // isEqual es true

        9. equalsIgnoreCase(String anotherString)
            Descripción: Compara la cadena con otra cadena, ignorando las diferencias entre mayúsculas y minúsculas.
            Ejemplo:

                String str1 = "Hello";
                String str2 = "hello";
                boolean isEqual = str1.equalsIgnoreCase(str2); // isEqual es true
        
        10. toUpperCase()
            Descripción: Convierte todos los caracteres de la cadena a mayúsculas.
            Ejemplo:

                String str = "Hello";
                String upper = str.toUpperCase(); // upper es "HELLO"
            
        11. toLowerCase()
            Descripción: Convierte todos los caracteres de la cadena a minúsculas.
            Ejemplo:

                String str = "Hello";
                String lower = str.toLowerCase(); // lower es "hello"
        
        12. replace(CharSequence target, CharSequence replacement)
            Descripción: Reemplaza todas las ocurrencias de una secuencia de caracteres en la cadena con otra secuencia.
            Ejemplo:

                String str = "Hello World";
                String replaced = str.replace("World", "Java"); // replaced es "Hello Java"

        13. split(String regex)
            Descripción: Divide la cadena en un array de cadenas, utilizando una expresión regular como delimitador.
            Ejemplo:

                String str = "one,two,three";
                String[] parts = str.split(","); // parts es ["one", "two", "three"]

        14. isEmpty()
            Descripción: Devuelve `true` si la cadena está vacía, es decir, tiene una longitud de `0`.
            Ejemplo:

                String str = "";
                boolean empty = str.isEmpty(); // empty es true

        15. valueOf()
            Descripción: Convierte diferentes tipos de datos (int, float, char, etc.) en una cadena.
            Ejemplo:

                int number = 10;
                String str = String.valueOf(number); // str es "10"

        16. .repeat(int count)
            Descripción: Repite la cadena original count veces y devuelve la nueva cadena resultante.
            Ejemplo:

                String str = "abc";
String          repeatedStr = str.repeat(3); // repeatedStr es "abcabcabc"
    */