package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con un nivel de prioridad asignado determinado*/
public class SamePriorityQueue<E> implements QueueIF<E>,Comparable<SamePriorityQueue<E>>{
 
  //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	
	private Queue<E> newQueue;			// Almacena una nueva cola
	private int priorityLevel;			// Almacena el nivel de prioridad 

  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola vac�a con la prioridad dada por par�metro.
   *@param p: nivel de prioridad asociado a la cola
  */
  SamePriorityQueue(int p){ 
	  
	  priorityLevel = p;
	  newQueue = new Queue<E>();
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
		  
		  return newQueue.getFirst();	  
		  
	  } else {		  
		  System.out.println("No se puede mostrar el primer elemento, la cola est� vac�a. ");
		  return null;
	  }
  }
 
  /*A�ade un elemento a la cola de acuerdo al orden de llegada*/
  public void enqueue(E elem) { 

	  newQueue.enqueue(elem);
  }

  /*Elimina un elemento a la cola de acuerdo al orden de llegada
   * @Pre !isEmpty()
  */
  public void dequeue() { 
	  
	  if(!isEmpty()) {
		  
		  newQueue.dequeue();
		  
	  } else {
		  System.out.println("Error, no se puede extraer el nodo, la cola est� vac�a.");
	  }
  }

  /* OPERACIONES PROPIAS DEL INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {
	  	  
	  return newQueue.iterator();
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COLLECTIONIF */

  /*Devuelve el n�mero de elementos de la cola*/
  public int size() { 
	  
	  return newQueue.size();
  }

  /*Decide si la cola est� vac�a*/
  public boolean isEmpty() { 
	  
	  return newQueue.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por par�metro*/
  public boolean contains(E e) { 

	  return newQueue.contains(e);	  
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 
	  
	  newQueue.clear();	  
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COMPARABLE */
 
  /*Comparaci�n entre colas seg�n su prioridad
   * Salida:
   *  - Valor >0 si la cola tiene mayor prioridad que la cola dada por par�metro
   *  - Valor 0 si ambas colas tienen la misma prioridad
   *  - Valor <0 si la cola tiene menor prioridad que la cola dada por par�metro
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

