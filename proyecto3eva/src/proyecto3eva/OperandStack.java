package proyecto3eva;

public class OperandStack {
	public int numElem;
	private int[] stack;
	private static int maxElem;
	/**
	 * constructora de operandstack
	 */
	public OperandStack() {
		this.numElem = 0;
		this.maxElem = 10;
		this.stack = new int[maxElem];
	}
	/**
	 * metodo boleano isempty que indica si la pila esta vacía
	 * @return
	 */
	public boolean isEmpty() {
		if(this.numElem == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * metodo tostring que convierte el contenido de la pila a un string
	 * @return
	 */
	public String ToString() {
		String frase = "Pila: ";
		if(isEmpty() == false) {
			for(int i = 0; i < this.numElem; i++) {
				frase = frase + stack[i] + " ";
			}
		}
		else {
			frase = frase + "<vacía>";
		}
		return frase;
	}
	/**
	 * metodo boleano push que inserta elementos en la pila
	 * @param val
	 * @return
	 */
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
	/**
	 * metodo pop que saca de la pila el ultimo elemento (el elemento superior de la pila)
	 * @return
	 */
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
	/**
	 * metodo peek que muestra el elemento superior de la pila
	 * @return
	 */
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
