package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con un nivel de prioridad asignado determinado*/
public class SamePriorityQueue<E> implements QueueIF<E>,Comparable<SamePriorityQueue<E>>{
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	
	private Queue<E> normalQueue;		// Almacena una nueva cola
	private int priorityLevel;			// Almacena el nivel de prioridad 

  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola vacía con la prioridad dada por parámetro.
   *@param p: nivel de prioridad asociado a la cola
  */
  SamePriorityQueue(int p){ 
	  
	  priorityLevel = p;
	  normalQueue = new Queue<E>();
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
	  
	  if(!isEmpty()) {
		  
		  return normalQueue.getFirst();		  
	  } else {	
		  
		  return null;
	  }
  }
 
  /*Añade un elemento a la cola de acuerdo al orden de llegada*/
  public void enqueue(E elem) {
	  
	  normalQueue.enqueue(elem);
  }

  /*Elimina un elemento a la cola de acuerdo al orden de llegada
   * @Pre !isEmpty()
  */
  public void dequeue() { 
	  
	  if(!isEmpty()) {
		  normalQueue.dequeue();
	  }
  }

  /* OPERACIONES PROPIAS DEL INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {

	  return normalQueue.iterator();
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COLLECTIONIF */

  /*Devuelve el número de elementos de la cola*/
  public int size() {

	  return normalQueue.size();
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() {

	  return normalQueue.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) {

	  return normalQueue.contains(e);	  
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() {

	  normalQueue.clear();	  
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

