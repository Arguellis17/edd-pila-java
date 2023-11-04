package funcionamiento;

public class Pila<E> {

    // Se llama la lista enlazada
    MyLinkedList<E> stack = new MyLinkedList<>();

    /**
     * Agregar elementos a la pila (Siempre se agrega al ultimo)
     *
     * @param element: Valor del dato
     */
    public void push(E element) {

        stack.add(element);

    }

    /**
     * Elimina un elemento de la pila (Siempre elimina el ultimo)
     *
     * @return devuelve el dato eliminado
     */
    public E pop() {

        return stack.removeAndReturn();
    }

    /**
     * Sacar el ultimo dato de la pila
     *
     * @return devuelve el ultimo elemento de la pila
     */
    public E peek() {

        return stack.sacarElementoCola();
    }

    /**
     * Preguntar si la pila esta vacia
     *
     * @return devuelve un boolean para cada caso
     */
    public boolean isEmpty() {

        return stack.isEmpty();

    }

    /**
     * Devolver el tamaño de la pila
     *
     * @return
     */
    public int getSize() {

        return stack.getSize();
    }

    /**
     * Vacia la pila
     *
     * @return devuelve la pila sin elementos
     */
    public E clear() {

        return stack.clear();

    }

    /**
     * Devuelve el fondo de la pila
     *
     * @param pila: Pila a usar
     * @return devuelve el elemento del fondo
     */
    public int devolverFondoPila(Pila<Integer> pila) {

        return stack.getHeadInteger();

    }
    
    /**
     * Informa si un elemento pertenece a la pila con un true o false
     *
     * @param element: Elemento a informar
     * @return devuelve true o false segun sea el caso. Si esta en la pila
     */
    public boolean elementoEncontradoPila(E element) {

        return stack.informarElemento(element);
    }

    /**
     * Impresion de la pila
     */
    public void print() {

        stack.print();

    }

}
