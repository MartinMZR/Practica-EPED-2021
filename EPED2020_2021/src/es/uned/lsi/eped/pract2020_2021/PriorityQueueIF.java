package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.SequenceIF;

/* Representa una cola de prioridad, en la que los elementos    * 
 * salen seg�n su nivel de prioridad y su orden de entrada.     */ 
public interface PriorityQueueIF<E> extends SequenceIF<E> {

	/* Devuelve el elemento m�s prioritario de la cola con prioridad.*
	/* @Pre !isEmpty()                                               *
	 * @return el elemento m�s prioritario de la cola con prioridad. */
	public E getFirst();
	
    /* Incluye un elemento con una cierta prioridad en la cola con prioridad *
     * @param elem: el elemento a encolar (a�adir).       					 *
     * @param prior: prioridad                                               *
    */
	public void enqueue(E elem, int prior);
	
    /* Elimina el elemento m�s prioritario de la cola con prioridad *
     * @Pre !isEmpty();                                             */
	public void dequeue();
	

	
	
}
