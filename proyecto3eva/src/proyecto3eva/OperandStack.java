package proyecto3eva;

public class OperandStack {
	public int numElem;
	private int[] stack;
	private static int maxElem;
	
	public OperandStack() {
		this.numElem = 0;
		this.maxElem = 10;
		this.stack = new int[maxElem];
	}
	
	public boolean isEmpty() {
		if(this.numElem == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String ToString() {
		String frase = "Pila: ";
		if(isEmpty() == false) {
			for(int i = 0; i < stack.length; i++) {
				if(stack[i] != 0) {
					frase = frase + stack[i] + " ";
				}
			}
		}
		else {
			frase = frase + "<vacía>";
		}
		return frase;
	}
	
	public boolean push(int val) {
		if(this.numElem >= this.maxElem) {
			return false;
		}
		else {
			stack[numElem] = val;
			numElem++;
			return true;
		}
	}
	
	public int pop() {
		if(isEmpty() == true) {
			return -1;
		}
		else {
			int cima = stack[numElem - 1];
			stack[numElem - 1] = 0;
			numElem--;
			return cima;
		}
	}
	
	public int peek() {
		if(isEmpty() == true) {
			return -1;
		}
		else {
			int cima = stack[numElem - 1];
			return cima;
		}
	}
}
