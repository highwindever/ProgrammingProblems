package chapter3StacksAndQueues;

import java.util.Stack;

public class SortStack {
	public static void main(String[] args){
		Stack<Integer> stk1 = new Stack<Integer>();
		stk1.push(5);
		stk1.push(2);
		stk1.push(6);
		stk1.push(3);
		stk1.push(9);
		stk1.push(1);
		Stack<Integer> stk2 = sortStack(stk1);
		while(!stk2.empty()){
			System.out.println(stk2.pop());
		}
	}
	
	static Stack<Integer> sortStack(Stack<Integer> stk1){
		if(stk1.empty()) return stk1;
		Stack<Integer> stk2 = new Stack<Integer>();
		while(!stk1.empty()){
			int i = stk1.pop();
			while(!stk2.empty()&&i<stk2.peek()){
				stk1.push(stk2.pop());				
			}
			stk2.push(i);
		}
		return stk2;
	}
}
