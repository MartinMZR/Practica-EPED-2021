package es.uned.lsi.eped.DataStructures;

public class GTree<E> extends Tree<E> implements GTreeIF<E> {

	private ListIF<GTreeIF<E>> children; 
	
	/* Constructor por defecto: crea un �rbol vac�o */
	public GTree() {
		super();
		this.children = new List<GTreeIF<E>>();
	}

	public void setRoot(E e) {
		this.root = e;
	}

	public ListIF<GTreeIF<E>> getChildren() {
		return this.children;
	}

	public GTreeIF<E> getChild(int pos) {
		return this.children.get(pos);
	}

	public void addChild(int pos, GTreeIF<E> e) {
		this.children.insert(pos, e);
	}

	public void removeChild(int pos) {
		this.children.remove(pos);
	}

	/* Reimplementaci�n/Especializaci�n de algunos m�todos de Collection */
	
	/* Devuelve el n�mero de nodos del �rbol */
	public int size() {
		if ( isEmpty() ) { return 0; }
		int s = 1;
		IteratorIF<GTreeIF<E>> childIt = this.children.iterator();
		while ( childIt.hasNext() ) {
			s = s + childIt.getNext().size();
		}		
		return s;
	}

	/* Vac�a el �rbol */
	public void clear() {
		super.clear();
		this.children.clear();
	}

	/* M�todos heredados de CollectionIF */
	
	/* Comprueba si el �rbol contiene el elemento */
	public boolean contains(E e) {
		if ( isEmpty() ) { return false; }
		boolean found = getRoot().equals(e);
		IteratorIF<GTreeIF<E>> childIt = this.children.iterator();
		while ( !found && childIt.hasNext() ) {
			found = childIt.getNext().contains(e);
		}
		return found;
	}	

	/* M�todos heredados de TreeIF */
	
	/* Devuelve el n�mero de hijos del �rbol */
	public int getNumChildren() {
		return this.children.size();
	}

	/* Devuelve el fan-out del �rbol */
	public int getFanOut() {
		if ( isEmpty() ) { return 0; }
		int fOut = getNumChildren();
		IteratorIF<GTreeIF<E>> childIt = this.children.iterator();
		while ( childIt.hasNext() ) {
			int aux = childIt.getNext().getFanOut();
			if ( aux > fOut ) { fOut = aux; }
		}
		return fOut;
	}

	/* Devuelve la altura del �rbol */
	public int getHeight() {
		int height = -1;
		if ( isEmpty() ) { return height; }
		IteratorIF<GTreeIF<E>> childIt = this.children.iterator();
		while ( childIt.hasNext() ) {
			int aux = childIt.getNext().getHeight();
			if ( aux > height ) { height = aux; }
		}
		return 1 + height;
	}

	/* Devuelve un iterador sobre el �rbol seg�n el recorrido elegido */
	public IteratorIF<E> iterator(Object mode) {
		QueueIF<E> queue = new Queue<E>();
		if ( mode instanceof GTree.IteratorModes ) {
			switch ((GTree.IteratorModes) mode) {
			case PREORDER:
				preorder(this,queue);
				break;
			case POSTORDER:
				postorder(this,queue);
				break;
			case BREADTH:
				breadthLR(this,queue);
				break;
			}
		}
		return queue.iterator();
	}
	
	/* Recorre el �rbol en preorden */
	private void preorder(GTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			q.enqueue(t.getRoot());
			IteratorIF<GTreeIF<E>> childIt = t.getChildren().iterator();
			while ( childIt.hasNext() ) {
				preorder(childIt.getNext(),q);
			}
		}
	}

	/* Recorre el �rbol en postorden */
	private void postorder(GTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			IteratorIF<GTreeIF<E>> childIt = t.getChildren().iterator();
			while ( childIt.hasNext() ) {
				postorder(childIt.getNext(),q);
			}
			q.enqueue(t.getRoot());
		}
	}

	/* Recorre el �rbol en anchura de izquierda a derecha */
	private void breadthLR(GTreeIF<E> t, QueueIF<E> q) {
		if ( !t.isEmpty() ) {
			QueueIF<GTreeIF<E>> auxQ = new Queue<GTreeIF<E>>();
			auxQ.enqueue(t);
			while ( ! auxQ.isEmpty() ) {
				GTreeIF<E> cGT = auxQ.getFirst();
				q.enqueue(cGT.getRoot());
				IteratorIF<GTreeIF<E>> childIt = cGT.getChildren().iterator();
				while ( childIt.hasNext() ) {
					auxQ.enqueue(childIt.getNext());
				}
				auxQ.dequeue();
			}

		}
	}
}
