package es.uned.lsi.eped.DataStructures;

/* Representa una colecci�n de elementos, sin ning�n tipo de    *
 *  relaci�n entre ellos m�s que la pertenencia a la misma      *  
 *  colecci�n.                                                  */
public interface CollectionIF<E> {

	/* Devuelve el n�mero de elementos de la colecci�n.         */
	public int size ();
	
	/* Devuelve true sii la colecci�n no contiene elementos.    */	
	public boolean isEmpty ();
	
	/* Devuelve true sii e est� en la colecci�n.                */
	public boolean contains (E e);
	
	/* Elimina todos los elementos de la colecci�n.             */
	public void clear ();
	
}
