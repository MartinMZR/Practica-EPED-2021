package es.uned.lsi.eped.DataStructures;

/* Representa un �rbol de b�squeda binaria, en el que los       *
 * elementos se organizan autom�ticamente seg�n su orden.       */
public interface BSTreeIF<E extends Comparable<E>> extends TreeIF<E> {
	/* Valor enumerado que indica los tipos de recorrido        *
	 * ofrecidos por los �rboles de b�squeda binaria.           */
	public enum IteratorModes {
		DIRECTORDER, REVERSEORDER
	}
	
	/* Valor enumerado que indica cu�l es la ordenaci�n de los  *
	 * elementos dentro del �rbol (ascendente o descendente).   */
	public enum Order {
		ASCENDING, DESCENDING
	}

	/* Añade un elemento no contenido previamente en el �rbol   *
	 * @Pre: !contains(e)                                       *
	 * @Post: contains(e)                                       */
	public void add(E e);
	
	/* Elimina un elemento previamente contenido en el �rbol    *
	 * @Pre: contains(e)                                        *
	 * @Post: !contains(e)                                      */
	public void remove(E e);

	public Order getOrder();
	
}
