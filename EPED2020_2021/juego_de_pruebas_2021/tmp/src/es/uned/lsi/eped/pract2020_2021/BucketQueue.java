package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con prioridad implementada mediante una secuencia de SamePriorityQueue*/
public class BucketQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private List<SamePriorityQueue<E>> priorityQueue;
	private int firstElement; 
	
  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE	  
	  private List<SamePriorityQueue<E>> listOfSPQ;
	  private SamePriorityQueue<E> spQueue;
	  private IteratorIF<E> iteratorQueue;
	  private E elem;
	  
    /*Constructor por defecto*/
    protected PriorityQueueIterator(){ 
    	listOfSPQ = new List<SamePriorityQueue<E>>(priorityQueue);
    	spQueue = listOfSPQ.get(firstElement);
    	iteratorQueue = spQueue.iterator();
    	elem = null;
    }

    /*Devuelve el siguiente elemento de la iteración*/
    public E getNext() {  		
	   	    	
	   	elem = iteratorQueue.getNext(); 
	   
	   	// Comprobamos si cola actual está vacía
	   	if(!iteratorQueue.hasNext()) {	
	   		listOfSPQ.remove(firstElement); 
	   		// Comprobamos que aún queda una cola por recorrer
		   	if(hasNext()) {
			   	spQueue = listOfSPQ.get(firstElement);
			   	iteratorQueue = spQueue.iterator();
			 }
	   	}  	
	   	
	   	return elem;
    }
    
    /*Comprueba si queda algún elemento por iterar*/
    public boolean hasNext() { 
    	return listOfSPQ.size() != 0;
    }
 
    /*Reinicia el iterador a la posición inicial*/
    public void reset() { 
    	listOfSPQ = new List<SamePriorityQueue<E>>(priorityQueue);
    }
  }



  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vacía
   */
  BucketQueue() { 
	  priorityQueue = new List<SamePriorityQueue<E>>();
	  firstElement = 1;
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento más prioritario de la cola y que
   *llegó en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() { 

	  if(!isEmpty()) {		  
		  return priorityQueue.get(firstElement).getFirst();
	  } else {
		  return null;
	  }	
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) { 

	  boolean insertQueueToFinal = true;
	  	  
	  // Comprobamos si existe alguna cola con la prioridad entrante
	  for(int getListNumber = 1; getListNumber <= priorityQueue.size(); getListNumber++) {
		  		  	  
		  int p = priorityQueue.get(getListNumber).getPriority();
		  // Si existe ponemos el elemento en la cola
		  if(p == prior) {
			  priorityQueue.get(getListNumber).enqueue(elem);
			  insertQueueToFinal = false;
			  break;
		  }
		  // Si encontramos una cola con una prioridad menor
		  if(p < prior) {  
			  //Hay que crear una nueva cola
			  SamePriorityQueue<E> newQueue = new SamePriorityQueue<>(prior);
			  //Hay que insertar el elemento
			  newQueue.enqueue(elem);
			  // Hay que insertar la cola en el lugar indicado
			  priorityQueue.insert(getListNumber, newQueue);
			  insertQueueToFinal = false;
			  break;
		  }		  
	  }		
	  
	  // Si no existe -> Por que hemos llegado al final de la cola
	  if(insertQueueToFinal) {			  
		  //Hay que crear una nueva cola
		  SamePriorityQueue<E> newQueue = new SamePriorityQueue<>(prior);
		  //Hay que insertar el elemento
		  newQueue.enqueue(elem);
		  // Hay que insertar el elemento al final de la cola	
		  priorityQueue.insert((priorityQueue.size() + 1), newQueue); 
	  }	  		
  }

  /*Elimina el elemento más prioritario y que llegá a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() { 
	  // Si la lista no está vacía desencolamos el primer elemento
	  if(!isEmpty()) {
		  priorityQueue.get(firstElement).dequeue();
		  // Comprobamos si la cola se ha quedado vacía para eliminarla
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

  /*Devuelve el número de elementos de la cola*/
  public int size() {   
	  
	  int sizeQueue = 0;
	  IteratorIF<SamePriorityQueue<E>> it = priorityQueue.iterator();
	  
	  while(it.hasNext()) {		 
		  sizeQueue = sizeQueue + it.getNext().size();  
	  }	 
	  
	  return sizeQueue;
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() {   
	  return priorityQueue.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
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

