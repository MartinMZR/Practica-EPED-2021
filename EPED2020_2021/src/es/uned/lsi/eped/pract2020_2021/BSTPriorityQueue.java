
package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;
import es.uned.lsi.eped.DataStructures.BSTreeIF.IteratorModes;

/*Representa una cola con prioridad implementada mediante un árbol binario de búsqueda de SamePriorityQueue*/
public class BSTPriorityQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private BSTree<SamePriorityQueue<E>> priorityQueue;

  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	  private BSTree<SamePriorityQueue<E>> iteratorQueue;
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ 
    	iteratorQueue = priorityQueue;
    }

    /*Devuelve el siguiente elemento de la iteración*/
    public E getNext() {  
    	
  	  // *** FALTA IMPLEMENTAR ***  
    	return null;
    }
    
    /*Comprueba si queda algún elemento por iterar*/
    public boolean hasNext() { 
    	return iteratorQueue != null;
    }
 
    /*Reinicia el iterador a la posición inicial*/
    public void reset() { 
    	iteratorQueue = priorityQueue;
    }
  }



  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vacía
   */
  BSTPriorityQueue(){ 
	  
	  priorityQueue = new BSTree<>();
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento más prioritario de la cola y que
   *llegó en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { 

	  // *** FALTA IMPLEMENTAR ***
	  return null;
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { 
	  
	  // *** FALTA IMPLEMENTAR ***
  }

  /*Elimina el elemento más prioritario y que llegá a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { 
	  
	  // *** FALTA IMPLEMENTAR ***

  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() { 
	  
	  return new PriorityQueueIterator();
  }
 
  /* OPERACIONES PROPIAS DE LA INTERFAZ COLLECTIONIF */

  /*Devuelve el número de elementos de la cola*/
  public int size() { 	  	  
	  return priorityQueue.size();
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() { 
	  return priorityQueue.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) { 

	  IteratorIF<SamePriorityQueue<E>> it = priorityQueue.iterator(IteratorModes.DIRECTORDER);
	  
	  while(it.hasNext()) {		  

		  if(it.getNext().contains(e)) {
			  return true;
		  }
	  }
	  return false;
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 
	  priorityQueue.clear();  
  } 
}

