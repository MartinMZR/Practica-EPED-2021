package es.uned.lsi.eped.DataStructures;

public abstract class Collection<E> implements CollectionIF<E> {
	protected int size;

	/* Constructor por defecto de una colecci�n */
	public Collection () {
		size = 0;
	}
	
	/* Devuelve el n�mero de elementos de la colecci�n */
	public int size() {
		return size;
	}
	
	/* Nos dice si la colecci�n est� vac�a o no */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/* Vac�a la colecci�n */
	public void clear() {
		size = 0;
	}
	
	abstract public boolean contains(E e);
}
