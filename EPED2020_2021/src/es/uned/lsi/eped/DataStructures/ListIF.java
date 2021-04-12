package es.uned.lsi.eped.DataStructures;

/* Representa una lista de elementos. Una lista es una          *
 * secuencia que permite modificar o acceder a cualquiera de    *
 * sus elementos de forma no destructiva.                       */ 
public interface ListIF<E> extends SequenceIF<E> {

	/* Devuelve el elemento de la lista que ocupa la posici�n   *
	 * indicada por el par�metro.                               *	
	 * @param pos la posici�n comenzando en 1.                  *	
	 * @Pre: 1 <= pos <= size().                                *
	 * @return el elemento en la posici�n pos.                  */
	public E get (int pos);
    
	/* Modifica la posici�n dada por el par�metro pos para que  *
	 * contenga el valor dado por el par�metro e.               *
	 * @param pos la posici�n cuyo valor se debe modificar,     *
	 *  comenzando en 1.                                        *
	 * @param e el valor que debe adoptar la posici�n pos.      *
	 * @Pre: 1 <= pos <= size().                                */
	public void set (int pos, E e);
	
   	/* Inserta un elemento en la Lista.                         *
   	 * @param elem El elemento que hay que a�adir.              *				
   	 * @param pos  La posici�n en la que se debe a�adir elem,   *
   	 *  comenzando en 1.                                        *
 	 * @Pre: 1 <= pos <= size()+1                               */
    public void insert (int pos, E elem);
    
    /* Elimina el elemento que ocupa la posici�n del par�metro  *	 
     * @param pos la posici�n que ocupa el elemento a eliminar, *
     *  comenzando en 1                                         *
	 * @Pre: 1 <= pos <= size()                                 */
    public void remove (int pos);
}
