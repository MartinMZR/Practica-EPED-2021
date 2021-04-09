package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con un nivel de prioridad asignado determinado*/
public class SamePriorityQueue<E> implements QueueIF<E>,Comparable<SamePriorityQueue<E>>{
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	
	private E value;				// Almacena el valor del nodo actual
	private E currentNode;			// Almacena el el nodo actual
	private E lastNode;				// Almacena el último nodo
	private E firstNode; 			// Almacena el primer nodo
	private E nextNode;  			// Almacena el nodo siguiente al actual
	private int priorityLevel;		// Almacena el nivel de prioridad 
	private int size;				// Almacena el tamaño de la cola

  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola vacía con la prioridad dada por parámetro.
   *@param p: nivel de prioridad asociado a la cola
  */
  SamePriorityQueue(int p){ 
	  
	  priorityLevel = p;
	  firstNode = null;
	  lastNode = null;
	  size = 0;
  }

  /* Devuelve la prioridad de la cola
   * @return prioridad de la cola
   */
  public int getPriority(){ 
	  
	  return priorityLevel;
  }
 
  /* OPERACIONES PROPIAS DE QUEUEIF */

  /*Devuelve el primer elemento de la cola
   * @Pre !isEmpty()
   */
  public E getFirst() { 
	  
	  try {
		  
		  return firstNode;
	  
	  } catch (NullPointerException e) {
		  System.err.println("No se puede mostrar el primer elemento, la cola está vacía. ");
		  return null;
	  }
  }
 
  /*Añade un elemento a la cola de acuerdo al orden de llegada*/
  public void enqueue(E elem) { 

	  currentNode = elem;
	  
	  if(isEmpty()) {
		  firstNode = currentNode;
	  } else {
		  nextNode = currentNode;
	  }
	  
	  lastNode = currentNode;
	  size++;
  }

  /*Elimina un elemento a la cola de acuerdo al orden de llegada
   * @Pre !isEmpty()
  */
  public void dequeue() { 
	  
	  try {
		  
		  firstNode = nextNode;
		  size--;
		  
		  if(size == 0) {
			  lastNode = null;
		  }
		  
	  } catch (NullPointerException e) {
			System.err.println("Error, no se puede extraer el nodo, la cola está vacía.");
	  }
  }

  /* OPERACIONES PROPIAS DEL INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {
	  
	  IteratorIF<E> queueIterator = new IteratorIF<E>() {
		
		  private E currentNode = firstNode;
		  
		  public E getNext() {
			
			  E elem = currentNode;
			  currentNode = nextNode;
			  return elem;
		  }
		
		  public boolean hasNext() {

			  return currentNode != null;
		  }
		
		  public void reset() {

			  currentNode = firstNode;
		  }
	  };
	
	return queueIterator;
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COLLECTIONIF */

  /*Devuelve el número de elementos de la cola*/
  public int size() { 
	  
	  return size;
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() { 
	  
	  return size == 0;
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) { 

	  E node = firstNode;
	  
	  while(node != null) {
		  if(node.equals(e)) {
			  return true;
		  }
		  node = nextNode;
	  }
	  
	  return false;
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 
	  
	  size = 0;
	  firstNode = null;
	  lastNode = null;
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COMPARABLE */
 
  /*Comparación entre colas según su prioridad
   * Salida:
   *  - Valor >0 si la cola tiene mayor prioridad que la cola dada por parámetro
   *  - Valor 0 si ambas colas tienen la misma prioridad
   *  - Valor <0 si la cola tiene menor prioridad que la cola dada por parámetro
   */
  public int compareTo(SamePriorityQueue<E> o) { 
	  
	  int result;
	  
	  if(this.getPriority() > o.getPriority()) {		  
		  result = 1;
	  } else if(this.getPriority() == o.getPriority()) {		  
		  result = 0; 
	  } else { 		  
		  result = -1; 
	  }
	  
	  return result;	  
  }

}

