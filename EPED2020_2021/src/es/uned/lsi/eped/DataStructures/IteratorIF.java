package es.uned.lsi.eped.DataStructures;

/* Representa un iterador de elementos.                         */
public interface IteratorIF<E> {

	/* Obtiene el siguiente elemento de la iteraci�n.           *
     * @pre:  hasNext ()                                        *
     * @return el siguiente elemento de la iteraci�n,           */
	  public E getNext ();
	    
	 /* Comprueba si a�n quedan elementos por iterar.           *
	  * @return true sii el iterador dispone de m�s elementos.  */
	  public boolean hasNext ();
	    
	 /* Vuelve la posici�n del iterador al principio. Esto      *
	  * permite reutilizar un iterador sin crear otro nuevo.    */
	  public void reset ();
}
