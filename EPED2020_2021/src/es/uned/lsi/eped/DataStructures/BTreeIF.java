package es.uned.lsi.eped.DataStructures;

/* Representa un arbol binario de elementos, en el que un nodo	*
 * puede tener, a lo sumo, dos hijos (fan-out <= 2 para todos   *
 * los nodos).                                                  */
public interface BTreeIF<E> extends TreeIF<E>{
	/* Valor enumerado que indica los tipos de recorrido        *
	 * ofrecidos por los �rboles de binarios.                   */
	public enum IteratorModes {
		PREORDER, POSTORDER, BREADTH, INORDER, RLBREADTH
	}
    
	/* Obtiene el hijo izquierdo del �rbol llamante.            *
     * @return el hijo izquierdo del �rbol llamante.            */
    public BTreeIF<E> getLeftChild ();
    
    /* Obtiene el hijo derecho del �rbol llamante.              *
     * @return el hijo derecho del �rbol llamante               */
    public BTreeIF<E> getRightChild ();

    /* Modifica la ra�z del �rbol.                              *
     * @param el elemento que se quiere poner como ra�z del     *
     * �rbol.                                                   */ 	
    public void setRoot (E e);
    
    /* Pone el �rbol par�metro como hijo izquierdo del �rbol    *
     * llamante. Si ya hab�a hijo izquierdo, el antiguo dejar�  *
     * de ser accesible (se pierde).                            *
     * @Pre: !isEmpty()                                         *
     * @param child el �rbol que se debe poner como hijo        *
     *        izquierdo.                                        */
    public void setLeftChild (BTreeIF <E> child);
    
    /* Pone el �rbol par�metro como hijo derecho del �rbol      *
     * llamante. Si ya hab�a hijo izquierdo, el antiguo dejar�  *
     * de ser accesible (se pierde).                            *
     * @Pre: !isEmpty()                                         *
     * @param child el �rbol que se debe poner como hijo        *
     *        derecho.	                                        */
    public void setRightChild (BTreeIF <E> child);

    /* Elimina el hijo izquierdo del �rbol.                     */
    public void removeLeftChild ();
    
    /* Elimina el hijo derecho del �rbol.                       */
    public void removeRightChild ();
    
}
