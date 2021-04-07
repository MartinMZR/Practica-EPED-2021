package es.uned.lsi.eped.DataStructures;

public class BTree<E> extends Tree<E> implements BTreeIF<E> {
	
	private BTreeIF<E> leftChild;
	private BTreeIF<E> rightChild;
		
	/* Constructor por defecto: crea un �rbol binario vac�o */
	public BTree(){
		super();
		this.leftChild = null;
		this.rightChild = null;
	}
		
	/* Devuelve el hijo izquierdo del �rbol */
	public BTreeIF<E> getLeftChild() {
		return this.leftChild;
	}

	/* Devuelve el hijo derecho del �rbol */
	public BTreeIF<E> getRightChild() {
		return this.rightChild;
	}

	/* Modifica la ra�z */
	public void setRoot(E e) {
		this.root = e;
	}

	/* Modifica el hijo izquierdo */
	public void setLeftChild(BTreeIF<E> child) {
		this.leftChild = child;
	}

	/* Modifica el hijo derecho */
	public void setRightChild(BTreeIF<E> child) {
		this.rightChild = child;
	}

	/* Elimina el hijo izquierdo */
	public void removeLeftChild() {
		this.leftChild = null;
	}

	/* Elimina el hijo derecho */
	public void removeRightChild() {
		this.rightChild = null;
	}

	/* Reimplementaci�n/Especializaci�n de algunos m�todos de Collection */
	
	/* Devuelve el n�mero de nodos del �rbol */
	public int size() {
		if ( isEmpty() ) { return 0; }
		int s = 1;
		if ( this.leftChild != null ) { s = s + this.leftChild.size(); }
		if ( this.rightChild != null ) { s = s + this.rightChild.size(); }
		return s;
	}

	/* Vac�a el �rbol binario */
	public void clear() {
		super.clear();
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/* M�todos heredados de CollectionIF */
	
	/* Comprueba si el �rbol binario contiene el elemento */
	public boolean contains(E e) {
		return ( !isEmpty() && ( this.root.equals(e) ||   
								 ( this.leftChild != null && this.leftChild.contains(e) ) ||
								 ( this.rightChild != null && this.rightChild.contains(e) ) ) );
	}

	/* M�todos heredados de TreeIF */
	
	/* Devuelve el n�mero de hijos del �rbol */
	public int getNumChildren() {
		int nC = 0;
		if ( this.leftChild != null ) { nC++; }
		if ( this.rightChild != null ) { nC++; }
		return nC;
	}

	/* Devuelve el fan-out del �rbol */
	public int getFanOut() {
		if ( getNumChildren() == 2 ) { return 2; }
		if ( this.leftChild != null ) { return Math.max(1,this.leftChild.getFanOut()); }
		if ( this.rightChild != null ) { return Math.max(1,this.rightChild.getFanOut()); }
		return 0;
	}

	/* Devuelve la altura del �rbol */
	public int getHeight() {
		if ( isEmpty() ) { return -1; }
		int hLC = -1;
		if ( this.leftChild != null ) { hLC = this.leftChild.getHeight(); }
		int hRC = -1;
		if ( this.rightChild != null ) { hRC = this.rightChild.getHeight(); }
		return 1 + ((hLC > hRC)?hLC:hRC);
	}

	/* Devuelve un iterador sobre el �rbol seg�n el recorrido elegido */
	public IteratorIF<E> iterator(Object mode) {
		QueueIF<E> queue = new Queue<E>();
		if ( mode instanceof BTreeIF.IteratorModes ) {
			switch ((BTreeIF.IteratorModes) mode) {
				case PREORDER:
					preorder(this,queue);
					break;
				case INORDER:
					inorder(this,queue);
					break;
				case POSTORDER:
					postorder(this,queue);
					break;
				case BREADTH:
					breadthLR(this,queue);
					break;
				case RLBREADTH:
					breadthRL(this,queue);
					break;
			}
		}
		return queue.iterator();
	}
	
	/* Recorre el �rbol en preorden */
	private void preorder(BTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			q.enqueue(t.getRoot());
			if ( t.getLeftChild() != null ) { preorder(t.getLeftChild(),q); }
			if ( t.getRightChild() != null ) { preorder(t.getRightChild(),q); }
		}
	}
	
	/* Recorre el �rbol en inorden */
	private void inorder(BTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			if ( t.getLeftChild() != null ) { inorder(t.getLeftChild(),q); }
			q.enqueue(t.getRoot());
			if ( t.getRightChild() != null ) { inorder(t.getRightChild(),q); }
		}
	}

	/* Recorre el �rbol en postorden */
	private void postorder(BTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			if ( t.getLeftChild() != null ) { postorder(t.getLeftChild(),q); }
			if ( t.getRightChild() != null ) { postorder(t.getRightChild(),q); }
			q.enqueue(t.getRoot());
		}
	}

	/* Recorre el �rbol en anchura de izquierda a derecha */
	private void breadthLR(BTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			QueueIF<BTreeIF<E>> auxQ = new Queue<BTreeIF<E>>();
			auxQ.enqueue(t);
			while ( ! auxQ.isEmpty() ) {
				BTreeIF<E> cBT = auxQ.getFirst();
				q.enqueue(cBT.getRoot());
				if ( cBT.getLeftChild() != null ) { auxQ.enqueue(cBT.getLeftChild()); }
				if ( cBT.getRightChild() != null ) { auxQ.enqueue(cBT.getRightChild()); }
				auxQ.dequeue();
			}
		}
	}

	/* Recorre el �rbol en anchura de derecha a izquierda */
	private void breadthRL(BTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			QueueIF<BTreeIF<E>> auxQ = new Queue<BTreeIF<E>>();
			auxQ.enqueue(t);
			while ( ! auxQ.isEmpty() ) {
				BTreeIF<E> cBT = auxQ.getFirst();
				q.enqueue(cBT.getRoot());
				if ( cBT.getRightChild() != null ) { auxQ.enqueue(cBT.getRightChild()); }
				if ( cBT.getLeftChild() != null ) { auxQ.enqueue(cBT.getLeftChild()); }
				auxQ.dequeue();
			}
		}
	}

}
