package es.uned.lsi.eped.DataStructures;

public abstract class Tree<E> extends Collection<E> implements TreeIF<E> {

	protected E root;

	Tree() {
		super();
		this.root = null;
	}
	
	/* Devuelve el elemento situado en la ra�z del �rbol */
	public E getRoot() {
		return this.root;
	}

	/* Decide si el �rbol es una hoja */
	public boolean isLeaf() {
		return this.root!=null && getNumChildren() == 0;
	}

	/* Reimplementaci�n de algunos m�todos de Collection */
	
	/* Decide si el �rbol es vac�o */
	public boolean isEmpty() {
		return this.root==null;
	}
	
	/* Vac�a el �rbol */
	public void clear() {
		super.clear();
		this.root = null;
	}
	
	abstract public int getNumChildren();

	abstract public int getFanOut();

	abstract public int getHeight();

	abstract public IteratorIF<E> iterator(Object mode);

	abstract public boolean contains(E e);

}
