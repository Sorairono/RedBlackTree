/**Student name: Long Nguyen
Class: CS3345
Section: 004 
Semester: Spring 2019
Project: 4
Description: Create a simple red black tree
*/

//Red black tree class
/**
 *
 * @author Sorairono
 */
public class RedBlackTree<E extends Comparable<E>> 
{
	//Node class
	class Node<E extends Comparable<E>>
	{
		//Variables of Node class
		E element;
		Node<E> leftChild;
		Node<E> rightChild;
		Node<E> parent;
		boolean color;
		//Default constructor
		public Node()
		{
			parent = null;
			leftChild = null;
			rightChild = null;
			color = BLACK;
		}
		//Parameterized constructor
		public Node(E key)
		{
			parent = null;
			leftChild = null;
			rightChild = null;
			color = BLACK;
			element = key;
		}
	}
	//Red and black boolean
	private static boolean RED = false;
	private static boolean BLACK = true;
	//Create a null node and root node of the tree
	private Node<E> nullNode = new Node<E>();
	private Node<E> root = nullNode;
	//Default constructor of the tree
	public RedBlackTree()
	{
		root.parent = nullNode;
		root.leftChild = nullNode;
		root.rightChild = nullNode;
	}

	//Insert method, the same as BST tree
	public boolean insert(E element) throws NullPointerException
	{
		//Throw NullPointerException when element entered is null
		if (element == null)
		{
			throw new NullPointerException("This key is invalid");
		}
		//Create a Node with given element and temporary node to traverse the tree
		Node<E> x = root;
		Node<E> y = nullNode;
		Node<E> z = new Node<E>(element);
		//While the temp node hasn't reached the leaves
		while (x != nullNode) 
		{
			y = x;
			if (z.element.compareTo(x.element) < 0)
			{
				x = x.leftChild;
			}
			else if (z.element.compareTo(x.element) > 0) 
			{
				x = x.rightChild;
			} 
			else 
			{
				return false;
			}
		}
		//Make y be the new node's parent then add it to the left or right of y
		z.parent = y;
		if (y == nullNode) 
		{
			root = z;
		} 
		else if (z.element.compareTo(y.element) < 0) 
		{
			y.leftChild = z;
		} 
		else 
		{
			y.rightChild = z;
		}
		//Make the new node's left and right child be null and color be red
		z.color = RED;
		z.leftChild = nullNode;
		z.rightChild = nullNode;
		//Rebalancing procedure should enforce the properties of a red-black tree
		rebalancingProcedure(z);
		return true;
	}

	//Rebalance method
	private void rebalancingProcedure(Node<E> x)
	{
		Node<E> y = nullNode;
		//While the tree does not follow the red-black tree properties
		while (x.parent.color == RED)
		{
			if (x.parent == x.parent.parent.leftChild)
			{
				y = x.parent.parent.rightChild;
				//Recolor case
				if (y.color == RED)
				{
					y.color = BLACK;
					x.parent.color = BLACK;
					x.parent.parent.color = RED;
					x = x.parent.parent;
				}
				//Recolor and rotate right case
				else if (y.color == BLACK && x == x.parent.leftChild)
				{
					x.parent.color = BLACK;
					x.parent.parent.color = RED;
					rotateRight(x.parent.parent);
				}
				//Rotating left case
				else
				{
					x = x.parent;
					rotateLeft(x);
				}
			}
			else
			{
				y = x.parent.parent.leftChild;
				//Recolor case
				if (y.color == RED)
				{
					y.color = BLACK;
					x.parent.color = BLACK;
					x.parent.parent.color = RED;
					x = x.parent.parent;
				}
				//Recolor and rotate left case
				else if (y.color == BLACK && x == x.parent.rightChild)
				{
					x.parent.color = BLACK;
					x.parent.parent.color = RED;
					rotateLeft(x.parent.parent);
				}
				//Rotating right case
				else
				{
					x = x.parent;
					rotateRight(x);
				}
			}
		}
		//Root node always black
		root.color = BLACK;
	}

	//Rotate left method
	private void rotateLeft(Node<E> x)
	{
		Node<E> y = x.rightChild;
		x.rightChild = y.leftChild;
		if (y.leftChild == nullNode)
		{
			y.leftChild.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nullNode)
		{
			root = y;
		}
		else if (x.parent.rightChild == x)
		{
			x.parent.rightChild = y;
		}
		else 
		{
			x.parent.leftChild = y;
		}
		y.leftChild = x;
		x.parent = y;
	}

	//Rotate right method
	private void rotateRight(Node<E> x)
	{
		Node<E> y = x.leftChild;
		x.leftChild = y.rightChild;
		if (y.rightChild == nullNode)
		{
			y.rightChild.parent = y;
		}
		y.parent = x.parent;
		if (x.parent == nullNode)
		{
			root = y;
		}
		else if (x.parent.rightChild == x)
		{
			x.parent.rightChild = y;
		}
		else 
		{
			x.parent.leftChild = y;
		}
		y.rightChild = x;
		x.parent = y;
	}

	//Contain method
	public boolean contains(Comparable<E> object) 
	{
		Node<E> x = root;

		while (x != nullNode) 
		{
			if (object.compareTo(x.element) == 0)
			{
				return true;
			}
			else if (object.compareTo(x.element) > 0)
			{
				x = x.rightChild;
			}
			else
			{
				x = x.leftChild;
			}
		}
		return false;
	}

	//toString method to print the tree pre-order traversal
	public String toString()
	{
		return toString(root);
	}

	private String toString(Node<E> x)
	{
		if (x == nullNode)
		{
			return "";
		}
		String str = "";
		String str1 = "";
		String str2 = "";
		if(x.color == BLACK) 
		{
			str = str + x.element + " ";
		} 
		else  
		{
			str = str + "*" + x.element + " ";
		}
		str1 = toString(x.leftChild);
		str2 = toString(x.rightChild);
		return str + str1 + str2;
	}
}
