package com.gl.dsa.assignment;

class Node{
	int nodeData;
	Node leftNode;
	Node rightNode;
	
	Node(int item){
		nodeData = item;
		leftNode = rightNode = null;
	}
}
class BstToSkewedTree{
	
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void flattenBTToSkewed(Node root,int order){
		if(root == null)
			return;
	
		if(order > 0)
			flattenBTToSkewed(root.rightNode, order);
		else
			flattenBTToSkewed(root.leftNode, order);
		
		Node rightNode = root.rightNode;
		Node leftNode = root.leftNode;
	
		if(headNode == null)
		{
			headNode = root;
			root.leftNode = null;
			prevNode = root;
		}
		else
		{
			prevNode.rightNode = root;
			root.leftNode = null;
			prevNode = root;
		}
		if (order > 0)
			flattenBTToSkewed(leftNode, order);
		else
			flattenBTToSkewed(rightNode, order);
	}

	static void traverseRightSkewed(Node root)
	{
		if(root == null)
			return;
		System.out.print(root.nodeData + " ");
		traverseRightSkewed(root.rightNode);	
	}

	public static void main (String[] args){
	
		BstToSkewedTree	tree = new BstToSkewedTree();
		tree.node = new Node(50);
		tree.node.leftNode = new Node(30);
		tree.node.rightNode = new Node(60);
		tree.node.leftNode.leftNode = new Node(10);
		tree.node.leftNode.rightNode = new Node(40);
		int order = 0;
		flattenBTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}