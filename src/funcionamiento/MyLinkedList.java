package funcionamiento;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>, Iterator<E> {

    // Ojo, el apuntador a la cabeza de la lista nunca
    // debe moverse, de lo contrario perderá la referencia
    // al primer elemento.
    private Node<E> head;
    private int size = 0; // Number of elements in the list

    /**
     * Imprime el elemento de mayor valor en una lista
     */
    public void imprimirMayor() {

        Node<E> p = head;
        if (p != null) {
            E mayor = p.getData();
            while (p != null) {

                Comparable cMayor = (Comparable) mayor;
                Comparable cDato = (Comparable) p.getData();

                if (cMayor.compareTo(cDato) < 0) {
                    mayor = p.getData();

                }

                p = p.getNext();
            }

            System.out.println(mayor);
        }

    }

    public void imprimirMayores(E valor) {

        // Recorre cada nodo
        Node<E> p = head;
        // Se dice que mientras P sea diferente de nulo, para que P tome uno a uno correctamente
        // Ya que si se pregunta que lo siguiente de P no sea nulo y esa fuera nuestra condicion
        // No tomaria el ultimo nodo 
        while (p != null) {
            // Verificar si el valor que se pasa en el metodo es un String
            if (valor instanceof String) {
                // Obtener el valor del nodo en un String
                String valorNodo = (String) p.getData();

                if (valorNodo.compareTo((String) valor) > 0) {
                    System.out.println(valorNodo + " - ");
                }
                // Si el valor es una instancia de un Integer
            } else if (valor instanceof Integer) {

                // Convertir el valor pasado en un entero
                int eValor = (Integer) valor;

                // Obtener el valor del nodo en un entero
                int eNodo = (Integer) p.getData();

                // Comparamos el valor de los nodos con el valor pasado en el argumento
                if (eNodo > eValor) {
                    System.out.println(eNodo + " - ");
                }

            } else {
                // Si se esta pasando un objeto se llama al metodo compareTo
                // que ya se encuentra sobreescrito en la clase Persona y Mascota, funcionando en función de la edad
                Comparable obtenerPersona = (Comparable) p.getData();
                // Ya una vez que se a obtenido una persona o Mascota, el valor pasado en el argumento es casteado a uno
                // Comparable, para que actue como la persona aux de nuestro metodo compareTo
                if (obtenerPersona.compareTo((Comparable) valor) > 0) {
                    System.out.println(p.getData() + " - ");
                }

            }
            // P avanzará mientras se cumpla la condicion
            p = p.getNext();

        }

    }

    /* 
    * Se obtiene el tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Agrega un elemento de tipo E a la lista
     *
     * @param val valor a agregar a lista generica
     */
    public void add(E val) {
        // Si la cabeza es nula, significa que no se ha instanciado una lista antes
        if (head == null) {
            // Se crea un nuevo nodo y se le asigna el valor pasado desde el metodo
            Node nuevo = new Node(val);
            // Se indica que la cabeza sera el nuevo nodo creado
            head = nuevo;
            size++;

        } else {
            // Cuando la lista ya se ha instanciado, se crea un nuevo nodo y se le asigna el valor
            Node nuevo = new Node(val);
            //nuevo.setData(val);
            // Apuntador p para tener una referencia del inicio de la lista
            Node p = head;
            // Mientras el siguiente nodo sea diferente de nulo, P se movera
            while (p.getNext() != null) {
                // Moviendo a P con getNext();
                p = p.getNext();
            }
            // Cuando lo siguiente de P es nulo, signifca que llego al final de lista
            p.setNext(nuevo); // Se conecta P al nuevo nodo
            size++;
        }
    }

    /**
     * Agrega un elemento de tipo E a la lista de manera ordenada
     *
     * @param val valor a agregar a lista generica
     */
    public void addOrdered(E val) {
        // Se crea el nuevo nodo
        Node nuevo = new Node((E) val);

        if (head == null) {
            head = nuevo;
            size++;
        } else {
            Node p = head;
            if (p.getData() instanceof Integer) {
                if ((int) p.getData() > (int) val) {
                    // Conecta a cabeza cuando es menor (añade al inicio
                    nuevo.setNext(p);
                    head = nuevo;
                } else {
                    // Conecta a la cola directamente cuando es mayor
                    if (p.getNext() == null) {
                        p.setNext(nuevo);
                    } else {
                        // Se agrega que p sea diferente de nulo, pues el seguira preguntando a medida que avance la lista
                        while (p != null && (int) p.getData() < (int) val) {
                            p = p.getNext();
                        }
                        //System.out.println("P: " + p.getData());
                        //System.out.println("Q: " + q);
                        Node q = head;

                        while (q.getNext() != p) {
                            q = q.getNext();
                        }

                        q.setNext(nuevo);
                        nuevo.setNext(p);
                        // System.out.println("q: " + q.getData() );
                        //System.out.println("p: " + p.getData());
                    }
                }

            } else if (p.getData() instanceof Object) {

                Comparable edadComparable = (Comparable) p.getData();
                if (edadComparable.compareTo((Comparable) val) > 0) {
                    // Conecta a cabeza cuando es menor (añade al inicio
                    nuevo.setNext(p);
                    head = nuevo;
                } else {
                    // Conecta a la cola directamente cuando es mayor
                    if (p.getNext() == null) {
                        p.setNext(nuevo);
                    } else {
                        // Se agrega que p sea diferente de nulo, pues el seguira preguntando a medida que avance la lista
                        while (p != null && edadComparable.compareTo((Comparable) val) < 0) {
                            p = p.getNext();
                        }
                        //System.out.println("P: " + p.getData());
                        //System.out.println("Q: " + q);
                        Node q = head;

                        while (q.getNext() != p) {
                            q = q.getNext();
                        }

                        q.setNext(nuevo);
                        nuevo.setNext(p);
                        // System.out.println("q: " + q.getData() );
                        //System.out.println("p: " + p.getData());
                    }
                }

            } else if (p.getData() instanceof String) {
                System.out.println("CADENA DE STRINGS ");

            }
        }
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    public void remove(E nodo) {

        // Validar que el elemento a eliminar es la cabeza
        if (nodo == head.getData()) {
            // Se crea un apuntador p en cabeza
            Node p = head;
            // La nueva cabeza sera lo siguiente de P
            head = p.getNext();
            size--;
            // Cuando el elemento a eliminar este en medio de los nodos
        } else {
            // Se crea un apuntador P que inica desde cabeza
            Node p = head;
            // Acanzara hasta encontrar el nodo 
            while (p.getData() != nodo) {
                p = p.getNext();

            }

            // Se crea un apuntador Q que sera igual a la posicion siguiente de P
            Node q = p.getNext();
            // Se crea un apuntador A que inicia desde head y avanzara hasta que no sea igual a al apuntador P
            Node a = head;
            while (a.getNext() != p) {
                a = a.getNext();
            }
            // El apuntador A se conecta a Q, funcionara correctamente asi el apuntador Q sea nulo
            a.setNext(q);
            size--;

        }
    }

    public void removePos(int pos) {
        // Se posiciona un apuntador en cabeza
        Node p = head;
        int contador = 0;
        // Si la posicion que se eliminara esta en la cabeza
        if ((pos == 1 || pos == 0)) {
            head = head.getNext();
            size--;
        } else {
            // Avanzara hasta ser igual a la posicion
            while (contador < pos - 1) {
                p = p.getNext();
                contador++;
            }
            // El apuntador Q sera igual a la posicion siguiente de P
            Node q = p.getNext();
            Node a = head;
            // El apuntador A avanzara hasta que lo siguiente de el no sea P (queda atras de P)
            while (a.getNext() != p) {
                a = a.getNext();
            }
            // Desde el apuntador A se conecta a Q, eliminando a P
            a.setNext(q);

        }
    }

    public E removeAndReturn() {

        if (head == null) {
            // La lista está vacía
            return null;
        }

        Node p = head;
        Node q = null;

        // Mueve p al último nodo y q al nodo anterior a p
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }

        if (q == null) {
            // Solo hay un nodo en la lista
            head = null;
        } else {
            // Hay más de un nodo, actualiza el enlace del nodo anterior
            q.setNext(null);
        }

        size--;

        return (E) p.getData();
    }

    /**
     * Vacia la Linked List
     */
    public E clear() {

        head = null;
        return (E) head;
    }

    /**
     * Preguntar si la lista esta vacía
     *
     * @return true o false dependiendo si se cumple la condición
     */
    public boolean isEmpty() {
        // Si la cabeza es nula y el size no a incrementado de 0, no se ha instanciado una lista
        if (head == null && size == 0) {
            return true;
        }

        return false;
    }

    /**
     * Impresión de la lista
     */
    public void print() {
        // Se crea un apuntador P desde el incio de la lista (head)
        Node p = head;
        // Mientras nuestro nodo no sea nulo, se saca el dato del nodo y se mueve al siguiente
        while (p != null) {
            System.out.println("[ " + p.getData() + " ]");
            p = p.getNext();

        }
    }

    /**
     * Imprime la lista completa.
     *
     * @return String con la información de los elementos contenidos
     */
    public String printTwo() {
        // Se crea un objeto que guardará el resultado
        // de la concatenación. Se podría haber usado un
        // String también.
        StringBuffer sb = new StringBuffer("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }

        return sb.toString();
    }

    /**
     * Obtener un nodo de acuerdo a su posicion
     *
     * @param pos: Posicion a buscar en la lista
     * @return devuelve el nodo
     */
    public E get(int pos) {
        Node p = head;
        int contador = 0;
        if ((pos == 1 || pos == 0)) {
            return (E) p.getData();
        } else {
            while (contador < pos - 1) {
                p = p.getNext();
                contador++;
            }

        }
        return (E) p.getData();
    }

    /**
     * Agrega un elemento en una posicion especifica
     *
     * @param element: Valor del nodo
     * @param pos: Posicion a ingresar el nodo
     */
    public void addPos(E element, int pos) {

        Node nuevo = new Node((E) element);
        int contador = 0;
        if ((pos == 1 || pos == 0)) {
            Node p = head;
            nuevo.setNext(p);
            head = nuevo;
            size++;

        } else {
            Node p = head;
            while (contador < pos - 1) {
                p = p.getNext();
                contador++;
            }
            Node q = head;
            while (q.getNext() != p) {

                q = q.getNext();
            }
            q.setNext(nuevo);
            nuevo.setNext(p);
            size++;

        }

    }

    /**
     * Agregar un nodo de acuerdo a la posicion de un nodo buscado
     *
     * @param dataNodeToFind: Nodo a encontrar y agregar en la posicion
     * @param dataNodeToInsert: Nodo a insertar en la posicion del nodo buscado
     */
    public void addNodeForData(E dataNodeToFind, E dataNodeToInsert) {
        // Apuntador que inicia en la cabeza
        Node p = head;

        // Se convierten los valores genericos a un tipo nodo
        Node nuevo = new Node((E) dataNodeToInsert);
        Node find = new Node((E) dataNodeToFind);

        // Avanzara hasta encontrar el nodo que queremos buscar
        while (p.getData() != find.getData()) {
            p = p.getNext();

        }
        // Como se trabaja con generecidad, debemos evaluar que instancia de dato se pasa en el metodo

        // Cuando los datos son del tipo entero
        if (p.getData() instanceof Integer) {
            // Se castea el tipo de dato a entero 
            // OJO: RECORDAR QUE P YA ENCONTRO AL NODO Y OBTIENE ESE NODO ENCONTRADO AQUÍ
            int nodoEnteroFind = (int) p.getData();

            // Si el nodo esta en la cabeza
            if (nodoEnteroFind == (int) head.getData()) {
                // Se conectan los apuntadores
                nuevo.setNext(p);
                head = nuevo;
                size++;
            } else {
                // Si es diferente de cabeza 
                Node a = head;
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                a.setNext(nuevo);
                nuevo.setNext(p);
                size++;

            }

            // Caso 2: Si la instancia del dato es del tipo String
        } else if (p.getData() instanceof String) {
            // Con el metodo equals, comparamos si el dato ingresado es igual a la cabeza
            if (p.getData().equals(head.getData())) {
                // Conectar apuntadores
                nuevo.setNext(p);
                head = nuevo;
                size++;
            } else {
                // Si es diferente de cabeza
                Node a = head;
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                a.setNext(nuevo);
                nuevo.setNext(p);
                size++;

            }
            // Caso 3: Si la instancia del dato es del tipo Object (Persona o Mascota)
        } else if (p.getData() instanceof Object) {
            // Con el metodo equals, comparamos si el dato ingresado es igual a la cabeza
            if (p.getData().equals(head.getData())) {
                // Conectar apuntadores
                nuevo.setNext(p);
                head = nuevo;
                size++;
            } else {
                // Si la posicion es diferente de cabeza
                Node a = head;
                while (a.getNext() != p) {
                    a = a.getNext();
                }
                a.setNext(nuevo);
                nuevo.setNext(p);
                size++;
            }

        }
    }

    /**
     * Suma los valores de una lista de tipo Integer
     *
     * @param listToSum: Se ingresa la lista a sumar todos sus elementos
     */
    public void sumarLista(MyLinkedList<Integer> listToSum) {

        Node p = head;
        int valPrev = 0;
        int valNext = 0;
        int sum = 0;
        // Recorre la lista
        while (p.getNext() != null) {

            // Obtiene el valor anterior
            valPrev = (int) p.getData();
            valPrev += valPrev; // Y lo ira sumando a medida de que lo obtenga

            // Cuando avance
            p = p.getNext();
            valNext = (int) p.getData(); // Obtiene el valor siguiente

            // Los valores anteriores que ya se encuentran sumados, se suman al siguiente
            sum = valPrev + valNext;

        }

        System.out.println("Suma Total: " + sum);

    }

    /**
     * Obtiene la cabeza de la lista
     *
     * @return devuelve el head
     */
    public Node getHead() {

        return head;
    }

    public int getHeadInteger() {

        Node p = head;
        int headInteger = (int) p.getData();

        return headInteger;
    }

    /**
     * Devuelve la cola de una lista
     *
     * @return retorna el dato de la cola
     */
    public E getTail() {

        Node p = head;

        while (p.getNext() != null) {
            p = p.getNext();

        }

        return (E) p.getData();

    }

    /**
     * Crea una nueva lista a partir de los elementos de tres listas. Sumandolos
     * uno en uno, dos en dos y así sucesivamente.
     *
     * @param one: Lista Uno
     * @param two: Lista Dos
     * @param three: Lista Tres
     */
    public void devolverSumaLista(MyLinkedList<Integer> one, MyLinkedList<Integer> two, MyLinkedList<Integer> three) {

        // No supe como hacerlo para longitudes distintas :VVVVV
        if (one.getSize() != two.getSize() || one.getSize() != three.getSize()) {

            System.out.println("Las longiudes no coinciden");

        } else {

            // Se crea la nueva lista
            MyLinkedList<Integer> listaSuma = new MyLinkedList<>();

            // Estas variables enteras nos permitiran obtener los data de las listas y nos permitiran sumar
            int dataListOne = 0;
            int dataListTwo = 0;
            int dataListThree = 0;

            // Se crean unos apuntadores y a traves del metodo obtenerCabeza se posicionan al inicio de la lista
            Node p = one.getHead();
            Node q = two.getHead();
            Node a = three.getHead();

            // Se llenara hasta la penultima posicion
            while (p.getNext() != null && q.getNext() != null && a.getNext() != null) {

                dataListOne = (int) p.getData();
                dataListTwo = (int) q.getData();
                dataListThree = (int) a.getData();
                p = p.getNext();

                q = q.getNext();

                a = a.getNext();

                listaSuma.add(dataListOne + dataListTwo + dataListThree);

            }
            // Ahora falta llenar la ultima posicion XDD
            int lastPosOne = (int) one.getTail();
            int lastPosTwo = (int) two.getTail();
            int lastPosThree = (int) three.getTail();

            listaSuma.add(lastPosOne + lastPosTwo + lastPosThree);

            // Se imprime la lista con las sumas
            listaSuma.print();

        }

    }

    /**
     * Crea una lista del tipo Integer de manera aleatoria
     *
     * @param list: Lista a crear
     * @param size: Tamaño a crear de la lista
     */
    public static void llenarAleatorio(MyLinkedList<Integer> list, int size) {

        // Dentro de la lista 
        for (int i = 0; i < size; i++) {
            int randomData = (int) (Math.random() * 10) + 1;
            list.add(randomData);
        }
    }

    /**
     * Agrega un elemento a la lista y lo agrega dos posiciones despues
     *
     * @param val: Elemento a agregar
     * @param pos: Posicion de la lista (se desplaza dos)
     */
    public void addAfterTwo(E val, int pos) {

        Node p = head;
        Node q = head;
        Node a = head;
        Node nuevo = new Node(val);
        int contador = 0;

        while (contador < pos - 1 && p != null) {

            p = p.getNext();
            contador++;
        }
        if (p.getData().equals(head.getData())) {

            q = p.getNext().getNext();
            a = q.getNext();
            q.setNext(nuevo);
            nuevo.setNext(a);

            return;
        }
        if (p.getNext() == null) {

            p.setNext(nuevo);
            return;
        }
        a = p.getNext();
        q = p.getNext().getNext();
        if (q == null) {
            a.setNext(nuevo);

        } else {
            a = q.getNext();
            q.setNext(nuevo);
            nuevo.setNext(a);

        }
        size++;

    }

    /**
     * Elimina un nodo dos posiciones despues
     *
     * @param pos: Posicion a eliminar (desplaza dos)
     */
    public void removeAfterTwo(int pos) {

        // Preguntar de que otra manera puedo ahorrarme los retornos :VVVV
        Node p = head;
        Node q = head;
        Node a = head;

        int contador = 0;

        while (contador < pos - 1) {
            p = p.getNext();
            contador++;
        }
        if (p.getData().equals(head.getData())) {
            System.out.println("sonaron");

            q = p.getNext().getNext();
            a = q.getNext();
            q.setNext(a.getNext());
            size--;
            return;
        }
        if (p.getNext() == null) {
            return;
        }
        q = p.getNext().getNext();

        if (q == null) {
            return;
        }
        a = q.getNext();
        if (a == null) {
            return;
        }
        q.setNext(a.getNext());
        size--;
    }

    public void add(E element, int pos) {
        Node p = head;
        p = head.getNext();
        for (int i = 0; i < size; i++) {
            Node q = p.getNext();
            if (i == pos) {
                Node nuevo = new Node(element);
                // Q apunta a nulo. Al estar haciendo esto, directamente se corta la lista
                q.setNext(nuevo.getNext());
                size++;
                return;

            }

        }
    }

    // Este metodo sera llamado en la clase de la pila
    public E sacarElementoCola() {

        Node p = head;

        while (p.getNext() != null) {
            p = p.getNext();
        }

        return (E) p.getData();

    }
    
    
    

    /**
     * Informa si un elemento se encuentra en la Linked List
     *
     * @param element: Elemento de la lista
     * @return devuelve true o false si el elemento se encuentra
     *
     */
    public boolean informarElemento(E element) {

        Node p = head;
        Node obtenerDato = new Node(element);

        while (!p.getData().equals(obtenerDato.getData())) {

            p = p.getNext();
            if (p == null) {

                return false;
            }

        }

        return true;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E next() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
