package es.uned.lsi.eped.DataStructures;

/* Representa una cola de elementos. Una cola es una            * 
 * especializaciÛn de una secuencia, que mantiene el orden de   * 
 * almacenamiento de sus elementos y una polÌtica de acceso     *
 * First In First Out (FIFO)                                    */
public interface QueueIF<E> extends SequenceIF<E> {

	/* Devuelve el primer elemento de la cola.                  *
	/* @Pre !isEmpty()                                          *
	 * @return la cabeza de la cola (su primer elemento).       */
     public E getFirst ();

    /* Incluye un elemento al final de la cola. Modifica el     *
     * tama√±o de la misma.                                      *
     * @param elem el elemento que debe encolar (a√±adir).       */
     public void enqueue (E elem);
    
    /* Elimina el primer elemento de la cola. Modifica la       *
     * tama√±o de la misma.                                      *
     * @Pre !isEmpty();                                         */
     public void dequeue ();        
}
