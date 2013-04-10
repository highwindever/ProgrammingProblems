package chapter4TreesAndGraphs;

import java.util.LinkedList;

import chapter4TreesAndGraphs.BTree.Node;

public class BFS {
	public static void main(String[] args){
		BTree bt = new BTree();
		Node n5 = bt.new Node(7,null,null);
		Node n6 = bt.new Node(6,null,null);
		Node n3 = bt.new Node(5,null,null);
		Node n4 = bt.new Node(4,null,null);
		Node n1 = bt.new Node(2,n3,n4);
		Node n2 = bt.new Node(3,n5,n6);
		Node root = bt.new Node(1,n1,n2);
		bt.root = root; 
		doBFSUsingTwoQ(bt.root);
		doBFSUsingOneQ(bt.root);
	}
	
	
	public static void doBFSUsingTwoQ(Node root){
		if(root==null) return;
		LinkedList<Node> currentLevel = new LinkedList<Node>();
		LinkedList<Node> nextLevel = new LinkedList<Node>();
		currentLevel.add(root);
		while(!currentLevel.isEmpty()){
			Node curNode = currentLevel.poll();
			if(curNode!=null){
				System.out.print(curNode.data+" ");
				nextLevel.add(curNode.left);
				nextLevel.add(curNode.right);
			}
			if(currentLevel.isEmpty()){
				System.out.println();				
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
			}
		}

	}
	
	public static void doBFSUsingOneQ (Node root){
		LinkedList<Node> level = new LinkedList<Node>();
		int curLevelNum =1;
		int nextLevelNum =0;
		level.add(root);
		while(curLevelNum!=0){
			Node curNode = level.poll();
			curLevelNum--;
			System.out.print(curNode.data + " ");
			if(curNode.left!=null){
				level.add(curNode.left);
				nextLevelNum ++;
			}
			if(curNode.right!=null){
				level.add(curNode.right);
				nextLevelNum ++;
			}

			if(curLevelNum==0){
				System.out.println();
				curLevelNum = nextLevelNum;
				nextLevelNum = 0;
			}
			
		}
	}
}
