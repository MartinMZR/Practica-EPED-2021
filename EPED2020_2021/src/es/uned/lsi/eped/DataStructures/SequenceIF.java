package es.uned.lsi.eped.DataStructures;

/* Representa una secuencia, que es una colecci�n de elementos  *
 * que se organizan linealmente.                                */
public interface SequenceIF<E> extends CollectionIF<E> {

	/* Devuelve el iterador sobre la secuencia. No necesita     *
	 * par�metros puesto que el recorrido es lineal y �nico.    */
	public IteratorIF<E> iterator (); 
}
