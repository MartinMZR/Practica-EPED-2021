package es.uned.lsi.eped.DataStructures;

/* Representa una pila de elementos. Una pila es una            * 
 * especializaciÛn de una secuencia, que mantiene el orden de   *
 * almacenamiento de sus elementos y una polÌtica de acceso     *
 * Last In First Out (LIFO).                                    */
public interface StackIF <E> extends SequenceIF<E>{
	
	/* Devuelve el elemento situado en la cima de la pila       *
	 * @Pre !isEmpty ();                                        *
	 * @return la cima de la pila                               */
	public E getTop ();
	
	/* Incluye un elemento en la cima de la pila. Modifica el   *
	 * tama√±o de la misma.                                      *
	 * @param elem el elemento que se quiere a√±adir en la cima  */
	public void push (E elem);    
	
	/* Elimina la cima de la pila. Modifica el tama√±o de la     * 
	 * pila.                                                    *
	 * @Pre !isEmpty ();                                        */
	public void pop ();            
}
