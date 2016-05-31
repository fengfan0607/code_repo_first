package Tree;

import java.util.Iterator;

import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.xml.internal.ws.api.message.Attachment;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	Node<E> root;
	int size;

	public LinkedBinaryTree() {
		// TODO Auto-generated constructor stub
		root = null;
		size = 0;
	}

	protected Node<E> validate(Position<E> p) {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("not a valide position");
		}
		Node<E> node = (Node<E>) p;

		if (node == parent(node)) {
			throw new IllegalArgumentException("position is no longer exist");
		}
		return node;
	}

	@Override
	public Position<E> left(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public Position<E> addRoot(E e) {
		if (isEmpty()) {
			throw new IllegalArgumentException("tree is not empty");
		}
		root = createNode(null, null, null, e);
		size = 1;
		return root;
	}

	public Position<E> addleft(Position<E> p, E e) {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("left child already exist");
		}
		Node<E> child = createNode(null, null, parent, e);
		parent.setLeft(child);
		size++;
		return child;
	}

	public Position<E> addRight(Position<E> p, E e) {
		Node<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("right child already exist");
		}
		Node<E> child = createNode(null, null, parent, e);
		parent.setRight(child);
		size++;
		return child;
	}

	public E set(Position<E> p, E e) {
		Node<E> node = validate(p);
		E oldValue = node.getElement();
		node.setElement(e);
		return oldValue;
	}

	public void attach(Position<E> p, LinkedBinaryTree<E> T1, LinkedBinaryTree<E> T2) {
		Node<E> node = validate(p);
		if (!isExternal(p)) {
			throw new IllegalArgumentException("node must be a leaf");
		}
		if (!T1.isEmpty()) {
			T1.root.setParent(node);
			node.setLeft(T1.root);
			size += T1.size();
			T1.root = null;
			T1.size = 0;
		}
		if (!T2.isEmpty()) {
			T2.root.setParent(node);
			node.setRight(T1.root);
			size += T2.size();
			T2.root = null;
			T2.size = 0;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Node<E> createNode(Node<E> leftChild, Node<E> rightChild, Node<E> parent, E e) {
		return new Node<E>(leftChild, rightChild, parent, e);
	}

	private static class Node<E> implements Position<E> {

		Node<E> left, right, parent;
		E element;

		public Node(Node<E> leftChild, Node<E> rightChild, Node<E> parent, E e) {
			// TODO Auto-generated constructor stub
			this.parent = parent;
			this.left = leftChild;
			this.right = rightChild;
			this.element = e;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() {
			// TODO Auto-generated method stub
			return element;
		}

	}

}
