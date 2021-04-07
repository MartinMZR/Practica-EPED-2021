package es.uned.lsi.eped.DataStructures;

/* Representa un conjunto, que es un contenedor que permite     *
 * almacenar elementos que ser�n �nicos dentro del conjunto.    */
public interface SetIF<E> extends ContainerIF<E> {

	/* Realiza la uni�n del conjunto llamante con el par�metro  */
	public void union (SetIF<E> s);
	
	/* Realiza la intersecci�n del conjunto llamante con el     *
	 * par�metro                                                */
	public void intersection (SetIF<E> s);
	
	/* Realiza la diferencia del conjunto llamante con el       *
	 * par�metro (los elementos que est�n en el llamante pero   *
	 * no en el par�metro)                                      */
	public void difference (SetIF<E> s);
	
	/* Devuelve true sii el conjunto par�metro es subconjunto   *
	 * del llamante                                             */
	public boolean isSubset (SetIF<E> s);
}
