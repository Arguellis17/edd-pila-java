package funcionamiento;

public class ClientePila {

    public static void main2(String[] args) {

        // Se crea una pila de enteros 
        Pila<Integer> stackOne = new Pila<>();

        // Se agregan elementos con el metodo push
        stackOne.push(1);
        stackOne.push(2);
        stackOne.push(3);
        stackOne.push(4);

        // Impresion de la pila
        System.out.println("Pila");
        stackOne.print();

//        MetodosPila.sumarElementosPila(stackOne);
//        MetodosPila.construirPilaMenorMayor(stackOne, 2);
//        MetodosPila.sacarElementoRepetido(stackOne, 4);
//        MetodosPila.crearPilaInversa(stackOne);
//        System.out.println("Fondo: " + stackOne.devolverFondoPila(stackOne));
//        System.out.println("Encontrado: " + stackOne.elementoEncontradoPila(2));
    }

    public static void main(String[] args) {

        //MetodosPila.palindromo("oso");
        MetodosPila.transformarPosfija("7+3*2");
        //MetodosPila.evaluarPosfijaOperacion("7+3*2");
        
    }
}
