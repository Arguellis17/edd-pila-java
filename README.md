> Este repositorio contiene una implementación de la estructura de datos tipo pila en el lenguaje de programación Java. Se hara referencia a las linked list dentro de la clase pila, de manera que la utilización de estas sean más flexibles. A su vez, también se trabajara con la generecidad. Se incluyó una clase llamada "Metodos pila", que incluye diversos ejercicios sobre las pilas :)

# 📚 ¿Qué es una Pila? 📚
Una pila es una estructura de datos lineal que sigue el principio de __LIFO__ _(Last In, First Out, por sus siglas en inglés)_, lo que significa que el último elemento añadido es el primero en ser retirado. La pila es conceptualmente similar a una pila de objetos físicos, donde solo puedes agregar o quitar elementos desde la parte superior.
  
Las operaciones fundamentales en una pila son:

* __Push:__ Agrega un elemento a la parte superior de la pila.

* __Pop:__ Retira el elemento más recientemente agregado de la parte superior de la pila.

* __Peek (o Top):__ Retorna el elemento en la parte superior de la pila sin retirarlo.

<p align="center">
  <img src="https://i.postimg.cc/hP5gbr5s/Captura-de-pantalla-2023-11-04-120814.png" alt="Descripción de la imagen">
</p>

Las pilas son utilizadas comúnmente en la implementación de algoritmos y estructuras de datos más complejas. Un ejemplo típico es la gestión de llamadas a funciones en la ejecución de programas, donde cada nueva función llamada se añade a la pila y se retira cuando se completa su ejecución.

## 🔑 Caracteristicas Clave 🔑
* Utilización de generecidad para permitir el almacenamiento de elementos de diferentes tipos de datos en la pila, proporcionando flexibilidad y reutilización del código.
* Referencia y utilización de Linked List dentro de la clase Pila para mejorar la flexibilidad y funcionalidad, permitiendo operaciones específicas de Linked List cuando sea necesario.
* Implementación de métodos básicos de pila como push, pop, y peek, que son fundamentales para agregar, retirar y observar el elemento en la parte superior de la pila.
* Integración de manejo de excepciones para abordar situaciones como desbordamiento (stack overflow) o intentos de retirar elementos de una pila vacía (stack underflow).
* Desarrollo de pruebas unitarias para garantizar el correcto funcionamiento de la pila en diversas situaciones y mantener la estabilidad del código.
