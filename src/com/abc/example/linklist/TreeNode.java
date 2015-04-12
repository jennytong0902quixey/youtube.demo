package com.abc.example.linklist;

public class TreeNode {
	TreeNode left;
	int data;
	TreeNode right;
	
	public TreeNode(int d){
		data = d ;
		left = right = null;  // this nodes have no children
		
	}
	

	public synchronized void insert( int d){
		if (d<data){
			if(left == null){
				left = new TreeNode(d);
			}
			else{
				left.insert(d);
			}
		}
		else if (d>data){
			if(right == null){
				right = new TreeNode(d);
			}
			else{
				right.insert(d);
			}
			
		}
	}
	
	
}
