package funcionamiento;

public class MetodosPila<E> {

    /**
     * Este metodo toma los elementos de una pila y devuelve una pila de la suma
     * de sus elementos
     *
     * @param pila: Pila a usar
     */
    public static void sumarElementosPila(Pila<Integer> pila) {

        // Se crea una pila temporal
        Pila<Integer> stackTemp = new Pila();

        // La variable entera actual, guardara un elemento de la pila
        int actual = 0;

        // Mientras la pila no este vacia
        while (!pila.isEmpty()) {
            // Se saca el elemento de la cima y se sumara con el que venga despues del pop
            actual += pila.pop();
            // Se adjunta a la pila
            stackTemp.push(actual);
        }

        // Impresion de la pila
        System.out.println("Pila Suma");
        stackTemp.print();
    }

    /**
     * Construye dos pilas. Una donde los elementos son mayores a un numero y
     * otra donde los elementos son menores al numero
     *
     * @param stack: Se recibe una pila
     * @param num: Numero que permitira construir las pilas
     */
    public static void construirPilaMenorMayor(Pila<Integer> stack, int num) {

        // Se crean dos pilas
        Pila<Integer> stackMax = new Pila(); // Pila para mayores
        Pila<Integer> stackLow = new Pila(); // Pila para menores

        // Mientras la pila no este vacia
        while (!stack.isEmpty()) {

            // Se toma el elemento de la pila
            int actual = stack.pop();
            // Si el elemento de la pila es mayor al num del parametro, se agrega a la pila de max
            if (actual > num) {
                stackMax.push(actual);

                // Caso contrario
            } else if (actual <= num) {
                stackLow.push(actual);
            }

        }
        System.out.println("Pila con elementos mayores a " + num);
        stackMax.print();
        System.out.println("Pila con elementos menores a " + num);
        stackLow.print();

    }

    /**
     * Elimina los elementos repetidos de una pila
     *
     * @param stack: Pila a usar
     * @param element: Elemento repetido a eliminar
     */
    public static void sacarElementoRepetido(Pila<Integer> stack, int element) {

        // Se crea una pila temporal
        Pila<Integer> stackTemp = new Pila();

        // Mientras la pila no este vacia
        while (!stack.isEmpty()) {
            // Se toma un elemento actual con el pop
            int actual = stack.pop();
            // Si ese elemento actual no es el elemento repetido...
            if (actual != element) {
                // Agregarlo a la pila temporal
                stackTemp.push(actual);
            }

        }
        // Ahora, se necesita vaciar la pila temporal para restaurar la pila original
        while (!stackTemp.isEmpty()) {
            // Se pasan los elementos de la pila temporal a la pila original
            stack.push(stackTemp.pop());
        }
        // Se muestra la pila
        System.out.println("Se actualizo la pila");
        stack.print();

    }

    /**
     * Recibe una pila y crea una adicional con los datos de manera inversa
     *
     * @param pila: Pila a manipular
     */
    public static void crearPilaInversa(Pila<Integer> pila) {

        // Se crea la pila inversa
        Pila<Integer> inversa = new Pila();

        // Mientras la pila no este vacia
        while (!pila.isEmpty()) {

            // Sacamos los datos y los agregamos a la pila inversa
            inversa.push(pila.pop());

        }

        // Se muestra la pila de manera inversa
        System.out.println("Pila Inversa");
        inversa.print();
    }

    /**
     * Una palabra palindromo significa que se lee igual del revés. Este metodo
     * determina si una palabra cumple esta caracterista
     *
     * @param palabra: Determina si cumple o no
     */
    public static void palindromo(String palabra) {

        // Creacion de la pila que guardara las palabras (Del tipo caracter)
        Pila<Character> stack = new Pila(); // Así se puede tomar letra por letra del string

        String palabraInversa = "";

        // Se recorre el tamaño de la palabra
        for (int i = 0; i < palabra.length(); i++) {
            // La variable index guardara cada letra de esa palabra
            char index = palabra.charAt(i);
            // Y la agrega a una pila
            stack.push(index);

        }

        // Mientras la pila no este vacia
        while (!stack.isEmpty()) {
            // Se guardan esos caracteres en el String
            palabraInversa += stack.pop();

        }

        // Si la palabra inversa es la misma que se paso en el metodo, sera palindromo
        if (palabraInversa.equalsIgnoreCase(palabra)) {
            System.out.println("Es un palindromo");

            // Caso contrario
        } else {
            System.err.println("No es un palindromo");
        }

    }

    /**
     * Toma una ecuacion y de acuerdo a la cantidad de parentesis, determina si
     * esta balanceada o no
     *
     * @param ecuacion: Ecuacion a evaluar
     */
    public static void ecuacionBalanceada(String ecuacion) {

        // Se usaran dos pilas, una que guarde los parentesis abiertos y otra los cerrados
        Pila<Character> stackAbierto = new Pila<>();
        Pila<Character> stackCerrado = new Pila<>();

        // Se toma la ecuacion y con un char se toma cada caracter
        for (int i = 0; i < ecuacion.length(); i++) {

            char index = ecuacion.charAt(i);
            // Si se encuentra un parentesis abierto, se agrega a la pila de parentesis abiertos
            if (index == '(') {
                stackAbierto.push(index);

                // Si se encuentra un parentesis cerrrado, se agrega a la pila de parentesis cerrados   
            } else if (index == ')') {
                stackCerrado.push(index);

            }

        }
        // Por ultimo, se comparan los sizes de la pila y se imprime el mensaje para cada caso
        if (stackAbierto.getSize() != stackCerrado.getSize()) {
            System.err.println("La ecuacion no esta balanceada");
        } else {
            System.out.println("La ecuacion esta balanceada");
        }

    }

    public static int precedencia(char operador) {

        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String transformarPosfija(String ecuacion) {

        // Se crea una pila de tipo caracter    
        Pila<Character> stack = new Pila<>();

        String expresion = ecuacion;
        String expresionPosfija = "";
        
        // Operadores de la pila
        String operadores = "+-*/^";

        for (int i = 0; i < ecuacion.length(); i++) {
            char caracter = ecuacion.charAt(i);

            if (Character.isLetterOrDigit(caracter)) {
                expresionPosfija += caracter;
                

                // Si la ecuacion contiene los operadores (+ - * / ^)    
            } else if (operadores.contains(String.valueOf(caracter))) {
                // Mientras la pila no este vacia se evalua la jerarquia de operaciones
                while (!stack.isEmpty() && precedencia(stack.peek()) >= precedencia(caracter)) {
                    expresionPosfija += stack.pop();

                }
                stack.push(caracter);
            } else if (caracter == '(') {
                stack.push(caracter);
            } else if (caracter == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    expresionPosfija += stack.pop();

                }

                stack.pop(); // Eliminar el '(' de la pila
            }
        }

        while (!stack.isEmpty()) {
            expresionPosfija += stack.pop();

        }

        System.out.println("Expresion: " + expresion);

        System.out.println("Posfija: " + expresionPosfija);
        return expresionPosfija + " ";
    }

    public static void evaluarPosfijaOperacion(String ecuacion) {

        // Se guarda la expresión posfija en un String
        String posFija = MetodosPila.transformarPosfija(ecuacion);

        // Se crea una pila: Almacenera los operadores
        Pila<Integer> stack = new Pila<>();

        // Se muestra en pantalla el resultado de esa expresion pos fija
        System.out.println("Posfija: " + posFija);

        // Se recorre la expresion pos fija
        for (int i = 0; i < posFija.length(); i++) {

            // Se tomara en cuenta cada caracter de la expresion posfija
            char caracter = posFija.charAt(i);

            // Si el caracter es un digito (numero)
            if (Character.isDigit(caracter)) {
                // Se convierte de char a entero, y es agregado a la pila
                stack.push(Character.getNumericValue(caracter));

            } else {
                // Si es un operador, se sacan los dos primeros digitos de la pila
                int b = stack.pop();
                int a = stack.pop();

                // En un switch, es necesaria la evaluacion de la expresion posfija
                switch (caracter) {
                    // Si el op es multiplicacion
                    case '*':
                        stack.push(a * b);
                        break;
                    // Si el op es suma
                    case '+':
                        stack.push(a + b);
                        break;
                    // Si el op es resta
                    case '-':
                        stack.push(a - b);
                        break;
                    // Si el op es div
                    case '/':
                        stack.push(a / b);
                        break;
                    // Si el op es pow    
                    case '^':
                        stack.push((int) Math.pow(a, b));
                        break;
                }
            }
        }

        stack.print();
        System.out.println("Resultado: " + stack.pop());

    }
}
