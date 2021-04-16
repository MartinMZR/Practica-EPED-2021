package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con prioridad implementada mediante una secuencia de SamePriorityQueue*/
public class BucketQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private List<SamePriorityQueue<E>> priorityQueue;
	private final int firstElement = 1; 
	
  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICI�N DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE	  
	  private List<SamePriorityQueue<E>> iteratorList;
	  private SamePriorityQueue<E> spQueue;
	  private IteratorIF<E> iteratorQueue;
	  private E elem;
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ 
    	iteratorList = new List<SamePriorityQueue<E>>(priorityQueue);
    	spQueue = iteratorList.get(firstElement);
    	iteratorQueue = spQueue.iterator();
    	elem = null;
    }

    /*Devuelve el siguiente elemento de la iteraci�n*/
    public E getNext() {  		    
    	// Comprueba que a�n quedan colas en la lista y que la cola actual est� vac�a
	   	if(hasNext() && !iteratorQueue.hasNext()) { 	    																						
	   		iteratorList.remove(firstElement);
	   		// Comprueba que una vez eliminada la cola actual a�n quedan una cola por recorrer
	   		if(hasNext()) {
	   			spQueue = iteratorList.get(firstElement);
	   			iteratorQueue = spQueue.iterator();
	   		}
    	}    	
	   	// Comprueba que a�n quedan elementos en la cola actual
	   	if(iteratorQueue.hasNext()) {	    		
	   		elem = iteratorQueue.getNext();	
	   		//return elem;
	   	} else {
	   		//return null;
	   	}
	   	
	   	return elem;
    }
    
    /*Comprueba si queda alg�n elemento por iterar*/
    public boolean hasNext() { 
    	return iteratorList.size() != 1;
    }
 
    /*Reinicia el iterador a la posici�n inicial*/
    public void reset() { 
    	iteratorList = new List<SamePriorityQueue<E>>(priorityQueue);
    }
  }



  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vac�a
   */
  BucketQueue() { 
	  priorityQueue = new List<SamePriorityQueue<E>>();	  
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento m�s prioritario de la cola y que
   *lleg� en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { 

	  if(!isEmpty()) {		  
		  return priorityQueue.get(firstElement).getFirst();
	  } else {
		  return null;
	  }	
  }
 
  /*A�ade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { 

	  boolean insertQueueFinal = true;
	  
	  // Comprobamos si existe alguna cola con la prioridad entrante
	  for(int getListNumber = 1; getListNumber <= priorityQueue.size(); getListNumber++) {
		  		  	  
		  int p = priorityQueue.get(getListNumber).getPriority();
		  // Si existe ponemos el elemento en la cola
		  if(p == prior) {
			  priorityQueue.get(getListNumber).enqueue(elem);
			  insertQueueFinal = false;
			  break;
		  }
		  // Si encontramos una cola con una prioridad menor
		  if(prior > p) {  
			  //Hay que crear una nueva cola
			  SamePriorityQueue<E> newQueue = new SamePriorityQueue<>(prior);
			  //Hay que insertar el elemento
			  newQueue.enqueue(elem);
			  // Hay que insertar la cola en el lugar indicado
			  priorityQueue.insert(getListNumber, newQueue);
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
		  priorityQueue.insert((priorityQueue.size() + 1), newQueue); 
	  }	  		
  }

  /*Elimina el elemento m�s prioritario y que lleg� a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { 
	  // Si la lista no est� vac�a desencolamos el primer elemento
	  if(!isEmpty()) {
		  priorityQueue.get(firstElement).dequeue();
		  // Comprobamos si la cola se ha quedado vac�a para eliminarla
		  if(priorityQueue.get(firstElement).isEmpty()) {
			  priorityQueue.remove(firstElement);
		  }
	  }	   
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {	  
	  return new PriorityQueueIterator();
  }
 
  /* OPERACIONES PROPIAS DE LA INTERFAZ COLLECTIONIF */

  /*Devuelve el n�mero de elementos de la cola*/
  public int size() {   
	  
	  int sizeQueue = 0;
	  IteratorIF<SamePriorityQueue<E>> it = priorityQueue.iterator();
	  
	  while(it.hasNext()) {		 
		  sizeQueue = sizeQueue + it.getNext().size();  
	  }	 
	  return sizeQueue;
  }

  /*Decide si la cola est� vac�a*/
  public boolean isEmpty() {   
	  return priorityQueue.isEmpty();
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
	  priorityQueue.clear();
  }
 
}
