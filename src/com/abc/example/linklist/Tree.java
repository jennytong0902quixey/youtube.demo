package com.abc.example.linklist;

public class Tree {
	private TreeNode root;
	
	public Tree(){
		root = null;
	}
	
	public synchronized void insertNode(int d){
		if (root == null){
			root = new TreeNode(d);
		}
		else{
			root.insert(d);
		}
	}
	
	public void preoderTraversal(){
		preoderTraversalHelper(root);
	}
	
	private void preoderTraversalHelper(TreeNode node){
		if (node == null)
			return;
		
		System.out.print(node.data + " ");
		preoderTraversalHelper(node.left);
		preoderTraversalHelper(node.right);
	
	}
	
	public void inorderTraversal(){
		inorderTraversalHelper(root);
	}
	
	private void inorderTraversalHelper(TreeNode node){
		if (node == null)
			return;
		
		inorderTraversalHelper(node.left);
		System.out.print(node.data + " ");
		inorderTraversalHelper(node.right);	
	}
	
	public void postorderTraversal(){
		postorderTraversalHelper(root);
	}
	
	private void postorderTraversalHelper(TreeNode node){
		if (node == null)
			return;
		
		postorderTraversalHelper(node.left);
		postorderTraversalHelper(node.right);
		System.out.print(node.data + " ");
	}
	
	
	public static void main(String[] args){
		Tree tree = new Tree();
		int value;
		
		for(int i=1; i<=10; i++){
			value = (int)(Math.random()*100);
			tree.insertNode(value);
		}
		
		System.out.print("\npreoderTraversal: ");
		tree.preoderTraversal();
		System.out.print("\ninorderTraversal: ");
		tree.inorderTraversal();
		System.out.print("\npostorderTraversal: ");
		tree.postorderTraversal();
		
	}
}
