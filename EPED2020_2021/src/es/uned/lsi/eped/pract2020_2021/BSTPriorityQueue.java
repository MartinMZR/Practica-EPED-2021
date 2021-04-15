
package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con prioridad implementada mediante un �rbol binario de b�squeda de SamePriorityQueue*/
public class BSTPriorityQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private BSTree<SamePriorityQueue<E>> priorityQueue;

  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	  private BSTree<SamePriorityQueue<E>> iteratorQueue;
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ 
    	iteratorQueue = priorityQueue;
    }

    /*Devuelve el siguiente elemento de la iteraci�n*/
    public E getNext() { ... }
    
    /*Comprueba si queda alg�n elemento por iterar*/
    public boolean hasNext() { 
    	return iteratorQueue != null;
    }
 
    /*Reinicia el iterador a la posici�n inicial*/
    public void reset() { 
    	iteratorQueue = priorityQueue;
    }
  }



  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vac�a
   */
  BSTPriorityQueue(){ 
	  
	  priorityQueue = new BSTree<>();
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento m�s prioritario de la cola y que
   *lleg� en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { ... }
 
  /*A�ade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { ... }

  /*Elimina el elemento m�s prioritario y que lleg� a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { ... }

  /* OPERACIONES PROPIAS DE LA INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() { 
	  
	  return new PriorityQueueIterator();
  }
 
  /* OPERACIONES PROPIAS DE LA INTERFAZ COLLECTIONIF */

  /*Devuelve el n�mero de elementos de la cola*/
  public int size() { 
	  return size;
  }

  /*Decide si la cola est� vac�a*/
  public boolean isEmpty() { 
	  return size == 0;
  }
 
  /*Decide si la cola contiene el elemento dado por par�metro*/
  public boolean contains(E e) { 

	  IteratorIF<SamePriorityQueue<E>> it = priorityQueue.iterator();
	  
	  while(it.hasNext()) {		  

		  if(it.getNext().contains(e)) {
			  return true;
		  }
	  }
	  return false;
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 
	  size = 0;  
  }
 
}

