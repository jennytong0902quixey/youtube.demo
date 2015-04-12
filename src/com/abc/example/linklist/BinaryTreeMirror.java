package com.abc.example.linklist;

public class BinaryTreeMirror{
    public static TreeNode mirrorof(TreeNode rootNode){
        if (rootNode == null){
            return rootNode;
        }
        else{
            TreeNode temp = rootNode.left;
            rootNode.left = rootNode.right;
            rootNode.right = temp;
            
            mirrorof(rootNode.left);
            mirrorof(rootNode.right);
        }
        return rootNode;
    }
    
    public static void main(String[] args){
    	TreeNode rootNode = new TreeNode(6);
    	rootNode.insert(3);
    	rootNode.insert(19);
    	
    	System.out.print("mirrorof: : " + rootNode.data + "\n");
    	System.out.print("mirrorof: : " + rootNode.right.data+ "\n");
    	System.out.print("mirrorof: : " + rootNode.left.data+ "\n");
    	
    	TreeNode node = mirrorof(rootNode);   
    	
    	System.out.print("mirrorof: : " + node.data + "\n");
    	System.out.print("mirrorof: : " + node.right.data+ "\n");
    	System.out.print("mirrorof: : " + node.left.data+ "\n");
    	
    	Tree tree = new Tree();
    	
    	for (int i =1; i<=10; i++){
    		int value = (int)Math.random()*100;
    		tree.insertNode(i);
    	}
    	System.out.print("\npreoderTraversal: ");
    	tree.preoderTraversal();
    	System.out.print("\ninorderTraversal: ");
    	tree.inorderTraversal();
    	System.out.print("\npostorderTraversal: ");
    	tree.postorderTraversal();
    	}
}