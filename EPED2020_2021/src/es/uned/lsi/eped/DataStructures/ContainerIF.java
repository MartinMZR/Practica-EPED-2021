package es.uned.lsi.eped.DataStructures;

/* Representa un contenedor, que es una colecci�n de elementos  *
 * que no guardan ning�n orden entre s�.                        */
public interface ContainerIF<E> extends CollectionIF<E> {

	/* Añade un elemento al contenedor                          */
	public void add (E e);
	
	/* Elimina un elemento e del contenedor                     *
	 * @pre:  this.contains(e)                                  *
	 * @post: !this.contains(e)                                 */
	public void remove (E e);

	/* Devuelve un iterador para el contenedor                  */
	public IteratorIF<E> iterator (); }
