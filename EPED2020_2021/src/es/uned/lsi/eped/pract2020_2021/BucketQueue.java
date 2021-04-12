package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con prioridad implementada mediante una secuencia de SamePriorityQueue*/
public class BucketQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private List<SamePriorityQueue<E>> priorityQueue;
	
  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE	  
	  private List<SamePriorityQueue<E>> iteratorQueue;
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ 
    	iteratorQueue = priorityQueue;
    }

    /*Devuelve el siguiente elemento de la iteración*/
    public E getNext() { 
    	
    	E elem = null;
    	
    	if(hasNext()) {
    		
	    	int size = iteratorQueue.size();
	    	
	    	if(iteratorQueue.get(size).getFirst() != null) {	// Todavía hay elementos en la misma cola
	    	
	    		elem = iteratorQueue.get(size).getFirst();
	    		iteratorQueue.get(size).dequeue();	
	    	
	    	} else {											// Borramos la cola vacía
	    		
	    		iteratorQueue.remove(size);
	    		getNext();	 
	    		
	    	}
	    	
	    	return elem;
	    	
    	} else {
    		return null;
    	}    	
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
  BucketQueue() { 
	  
	  priorityQueue = new List<>();
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento más prioritario de la cola y que
   *llegó en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { 

	  if(!isEmpty()) {			  
		  int size = priorityQueue.size();			// El tamaño de la cola nos da la de mayor prioridad
		  return priorityQueue.get(size).getFirst();
	  } else {
		  System.out.println("La cola está vacía");
		  return null;
	  }	
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { 
	  
	  SamePriorityQueue<E> newSPQueue = new  SamePriorityQueue<E>(prior);			// Creamos una nueva cola

	  if(isEmpty()) {		  
		  newSPQueue.enqueue(elem);					// Insertamos el elemento en la cola
		  priorityQueue.insert(prior, newSPQueue);	// Insertamos la cola en el listado de colas
	  } else {

		  boolean existPriority = false;
		  
		  // Recorremos la lista
		  for(int counter = 0; counter <= priorityQueue.size(); counter++) {
			  
			  SamePriorityQueue<E> actualQueue = priorityQueue.get(counter);	// Cogemos la cola actual
			  int priority = actualQueue.compareTo(newSPQueue);					// Comparamos la prioridad
			  
			  if(priority == 0) {					
				  existPriority = true;
				  actualQueue.enqueue(elem);		// Si encontramos una cola añadimos el elemento
			  }			  		  
		  }
		  
		  if(!existPriority) {						// No existe la cola			  
			  priorityQueue.insert(prior, newSPQueue);
		  }		  
	  }  
  }

  /*Elimina el elemento más prioritario y que llegá a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { 
	  	  
	  if(!isEmpty()) {			  
		  int size = priorityQueue.size();			// El tamaño de la cola nos da la de mayor prioridad
		  priorityQueue.get(size).dequeue();
	  } else {
		  System.out.println("La cola está vacía");
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
	  return size;
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() { 
	  return size == 0;
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) {
	  
	List<SamePriorityQueue<E>> containsQueues = priorityQueue; 
	SamePriorityQueue<E> actualQueue;
	  
  	while(containsQueues.size() != 0) {					// Si existen colas
  		
  		int size = containsQueues.size();
  		actualQueue = containsQueues.get(size);
  		E elem = actualQueue.getFirst();				// Cogemos el elemento más prioritario
	    
  		if(elem.equals(e)) {
    		return true;
    	}
  		
  		if(elem != null) { actualQueue.dequeue(); }		// Todavía hay elementos en la misma cola
  		else { containsQueues.remove(size); }			// Borramos la cola actual

  	}
  	return false;
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() { 
	  size = 0;
  }
 
}

