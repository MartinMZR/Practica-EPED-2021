package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.Collection;
import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.Sequence;

/*Representa una cola con prioridad implementada mediante una secuencia de SamePriorityQueue*/
public class BucketQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE

	private E value;
	
  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	  
	  private E currentNode;
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ ... }

    /*Devuelve el siguiente elemento de la iteraci�n*/
    public E getNext() { 

    	E elem = this.currentNode.
    }
    
    /*Comprueba si queda alg�n elemento por iterar*/
    public boolean hasNext() { � }
 
    /*Reinicia el iterador a la posici�n inicial*/
    public void reset() { � }
  }



  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vac�a
   */
  BucketQueue() { 
	  
	super();  
	this.lastNode = null;
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento m�s prioritario de la cola y que
   *lleg� en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { � }
 
  /*A�ade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { � }

  /*Elimina el elemento m�s prioritario y que lleg� a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { � }

  /* OPERACIONES PROPIAS DE LA INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() { 

	  return new PriorityQueueIterator();	  
  }
 
  /* OPERACIONES PROPIAS DE LA INTERFAZ COLLECTIONIF */

  /*Devuelve el n�mero de elementos de la cola*/
  public int size() { 

	  return size;			// Atributo dentro tipo protected dentro de la interfaz collection
  }

  /*Decide si la cola est� vac�a*/
  public boolean isEmpty() { 
	  
	  return size == 0;		// Compara el tama�o del atributo size, y devuelve el resultado
  }
 
  /*Decide si la cola contiene el elemento dado por par�metro*/
  public boolean contains(E e) {...}
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 

	  size = 0;				// Cambia el tama�o de la colecci�n a 0
  }
 
}

