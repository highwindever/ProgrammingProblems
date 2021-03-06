package chapter8Recursion;


public class ParenthesesCombination {
	public static void main(String[] args){
		brackets(3, 0, "");		
	}
	
	
	static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            brackets(openStock-1, closeStock+1, s + "(");
        }
        if (closeStock > 0) {
            brackets(openStock, closeStock-1, s + ")");
        }
    }
}
