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
		  return priorityQueue.get(0).getFirst();
	  } else {
		  System.out.println("La cola está vacía");
		  return null;
	  }	
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { 
	  
	  boolean insertQueueFinal = true;
	  
	  // Comprobamos si existe alguna cola con la prioridad entrante
	  for(int e = 0; e < priorityQueue.size(); e++) {
		  
		  int p = priorityQueue.get(e).getPriority();
		  // Si existe ponemos el elemento en la cola
		  if(p == prior) {
			  priorityQueue.get(e).enqueue(elem);
			  insertQueueFinal = false;
			  break;
		  }
		  // Si encontramos una cola con una prioridad menor
		  if(p < prior) {
			  //Hay que crear una nueva cola
			  SamePriorityQueue<E> newQueue = new SamePriorityQueue<>(prior);
			  //Hay que insertar el elemento
			  newQueue.enqueue(elem);
			  // Hay que insertar la cola en el lugar indicado
			  priorityQueue.insert(e, newQueue);
			  insertQueueFinal = false;
			  break;
		  }		  
	  }		
	  
	  // Si no existe -> Por que hemos llegado al final de la cola
	  if(insertQueueFinal) {			  	  
		  //Hay que crear una nueva cola
		  SamePriorityQueue<E> newQueue = new SamePriorityQueue<>(prior);
		  //Hay que insertar el elemento
		  newQueue.enqueue(elem);
		  // Hay que insertar el elemento al final de la cola	
		  priorityQueue.insert(priorityQueue.size(), newQueue);  
	  }	  		
  }

  /*Elimina el elemento más prioritario y que llegá a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { 
	  	  
	  if(!isEmpty()) {			  
		  priorityQueue.get(0).dequeue();
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
	  
	E elem = null; 
	int size = 0;
	  
	List<SamePriorityQueue<E>> containsQueues = priorityQueue; 
	SamePriorityQueue<E> actualQueue;
	  
  	while(containsQueues.size() != 0) {					// Si existen colas
  		
  		size = containsQueues.size();
  		actualQueue = containsQueues.get(size);
  		elem = actualQueue.getFirst();					// Cogemos el elemento más prioritario
	     
  		// Todavía hay elementos en la misma cola
  		if(elem != null) { 
  			actualQueue.dequeue();
  		// No quedan elemento en la cola, borramos la cola	
  		} else { 
  			containsQueues.remove(size);
  		}				
  		// Comparamos el elemento 
  		if(elem.equals(e)) { 
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

