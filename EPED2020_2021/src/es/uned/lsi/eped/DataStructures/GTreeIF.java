package es.uned.lsi.eped.DataStructures;

/* Representa un arbol general de elementos, en el que un nodo  *
 * puede tener cualquier n�mero de hijos.                       */
public interface GTreeIF<E> extends TreeIF<E> {
	/* Valor enumerado que indica los tipos de recorridos       *
	 * ofrecidos por los �rboles generales.                     */
	public enum IteratorModes {
		PREORDER, POSTORDER, BREADTH
	}
    
    /* Modifica la ra�z del �rbol.                              *
     * @param el elemento que se quiere poner como ra�z del     *
     * �rbol.                                                   */ 	
     public void setRoot (E e);
     
    /* Obtiene los hijos del �rbol llamante.                    *
     * @return la lista de hijos del �rbol (en el orden en que  *
     * est�n almacenados en el mismo.                           */
     public ListIF <GTreeIF<E>> getChildren ();

    /* Obtiene el hijo que ocupa la posici�n dada por par�metro.*
     * @param pos la posici�n del hijo que se desea obtener,    *
     *  comenzando en 1.                                        *
     * @Pre 1 <= pos <= getChildren ().size ();                 *
     * @return el �rbol hijo que ocupa la posici�n pos.         */
     public GTreeIF<E> getChild (int pos);
		
    /* Inserta un �rbol como hijo en la posici�n pos.           *
     * @param pos la posici�n que ocupar� el �rbol entre sus    *
     * hermanos, comenzando en 1.                               *
     * Si pos == getChildren ().size () + 1, se a�ade como      *
     * �ltimo hijo.                                             *
     * @param e el hijo que se desea insertar.                  *
     * @Pre 1<= pos <= getChildren ().size () + 1               */
     public void addChild (int pos, GTreeIF<E> e);
    
    /* Elimina el hijo que ocupa la posici�n par�metro.         *
     * @param pos la posici�n del hijo con base 1.              *
     * @Pre 1 <= pos <= getChildren ().size ();                 */
     public void removeChild (int pos);
       
}
