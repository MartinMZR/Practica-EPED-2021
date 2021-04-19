package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;
import es.uned.lsi.eped.DataStructures.BSTreeIF.IteratorModes;
import es.uned.lsi.eped.DataStructures.BSTreeIF.Order;

/*Representa una cola con prioridad implementada mediante un árbol binario de búsqueda de SamePriorityQueue*/
public class BSTPriorityQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private BSTree<SamePriorityQueue<E>> priorityBSQueue;

  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	  private IteratorIF<SamePriorityQueue<E>> iteratorBSTree;
	  private SamePriorityQueue<E> spQueue;
	  private IteratorIF<E> iteratorQueue;
	  private E elem;	  
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ 
    	// Utilizamos el iterador en DIRECORDER por que el arbol está creado en orden DESCENDENTE
    	// de esta forma cuando pedimos un nuevo elemento siempre nos da el MAYOR que es el de más prioridad
    	iteratorBSTree = priorityBSQueue.iterator(IteratorModes.DIRECTORDER);
    	spQueue = iteratorBSTree.getNext();
    	iteratorQueue = spQueue.iterator();
    	elem = null; 
    }

    /*Devuelve el siguiente elemento de la iteración*/
    public E getNext() {  
    	
    	elem = iteratorQueue.getNext(); 

		return elem;
    }
    
    /*Comprueba si queda algún elemento por iterar*/
    public boolean hasNext() { 
    	
    	boolean hasNext = true;
    	
		//Si la cola actual está vacía
		if(!iteratorQueue.hasNext()) {
			// Si quedan colas dentro del árbol
			if(iteratorBSTree.hasNext()) {
				spQueue = iteratorBSTree.getNext();
				iteratorQueue = spQueue.iterator();
			} else {
				hasNext = false;
			}
		}

		return hasNext;
    }
 
    /*Reinicia el iterador a la posición inicial*/
    public void reset() { 
    	iteratorBSTree.reset();
    }
  }



  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vacía
   */
  BSTPriorityQueue(){ 
	  // Creamos el arbol binario de b�squeda en orden DESCENDENTE
	  priorityBSQueue = new BSTree<SamePriorityQueue<E>>(Order.DESCENDING);
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento más prioritario de la cola y que
   *llegó en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { 
	  
	  E elem = null;
	  
	  if(!isEmpty()) {
		  // Creamos un iterador y devolvemos el primer elemento de la primera cola
		  elem = priorityBSQueue.iterator(IteratorModes.DIRECTORDER).getNext().getFirst();
	  } 
	  
	  return elem;
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { 
	  
	  boolean insertNewQueue = true;
	  IteratorIF<SamePriorityQueue<E>> it = priorityBSQueue.iterator(IteratorModes.DIRECTORDER);
	  
	  while(it.hasNext()) {
		  
		  SamePriorityQueue<E> spq = it.getNext();
		  int p = spq.getPriority();
		  
		  if(p == prior) {			  
			  spq.enqueue(elem);
			  insertNewQueue = false;
			  break;			  
		  }
	  }
	  
	  if(insertNewQueue) {
		  SamePriorityQueue<E> newQueue = new SamePriorityQueue<E>(prior);
		  newQueue.enqueue(elem);
		  priorityBSQueue.add(newQueue);
	  }
  }

  /*Elimina el elemento m�s prioritario y que llegó a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { 
 
	  IteratorIF<SamePriorityQueue<E>> it = priorityBSQueue.iterator(IteratorModes.DIRECTORDER);
	  
	  if(!isEmpty()) {
		  SamePriorityQueue<E> spq = it.getNext();
		  spq.dequeue();
		  // Comprobamos si la cola ha quedado vacía para eliminarla
		  if(spq.isEmpty()) {
			  priorityBSQueue.remove(spq);
		  }		  
	  } 
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {	  
	  return new PriorityQueueIterator();
  }
 
  /* OPERACIONES PROPIAS DE LA INTERFAZ COLLECTIONIF */

  /*Devuelve el número de elementos de la cola*/
  public int size() { 	  	  
	  
	  int sizeQueue = 0;
	  IteratorIF<SamePriorityQueue<E>> it = priorityBSQueue.iterator(IteratorModes.DIRECTORDER);
	  
	  while(it.hasNext()) {
		  sizeQueue = sizeQueue + it.getNext().size();
	  }
	  
	  return sizeQueue;
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() { 
	  return priorityBSQueue.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) { 

	  IteratorIF<SamePriorityQueue<E>> it = priorityBSQueue.iterator(IteratorModes.DIRECTORDER);
	  
	  while(it.hasNext()) {		  

		  if(it.getNext().contains(e)) {
			  return true;
		  }
	  }
	  return false;
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 
	  priorityBSQueue = new BSTree<SamePriorityQueue<E>>(Order.DESCENDING);
	  //priorityBSQueue.clear();	  
  } 
}
