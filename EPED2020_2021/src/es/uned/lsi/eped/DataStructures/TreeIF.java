package es.uned.lsi.eped.DataStructures;

/* Representa un �rbol, que es una colecci�n cuyos elementos se *
 * organizan jer�rquicamente.                                   */

public interface TreeIF<E> extends CollectionIF<E> {

	/* Obtiene el elemento situado en la ra�z del �rbol         *
     * @Pre: !isEmpty ();                                       *
     * @return el elemento que ocupa la ra�z del �rbol.         */
	public E getRoot ();

	/* Decide si el �rbol es una hoja (no tiene hijos)          *
	 * @return true sii el �rbol es no vac�o y no tiene hijos   */
	public boolean isLeaf();	
	
	/* Devuelve el n�mero de hijos del �rbol                    */
	public int getNumChildren ();
	
	/* Devuelve el fan-out del �rbol: el n�mero m�ximo de hijos *
	 * que tiene cualquier nodo del �rbol                       */
	public int getFanOut ();
	
	/* Devuelve la altura del �rbol: la distancia m�xima desde  *
	 * la ra�z a cualquiera de sus hojas                        */
    public int getHeight ();
	
    /* Obtiene un iterador para el �rbol.                       *
     * @param mode el tipo de recorrido indicado por los        * 
     * valores enumerados definidos en cada TAD concreto.       */
    public IteratorIF<E> iterator (Object mode);    

}
