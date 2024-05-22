package proyecto3eva;

public enum ENUM_BYTECODE {
	PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT;
	private int valueArg;
	
	/**
	 * Constructora simple de enum_bytecode
	 */
	ENUM_BYTECODE() {
		this.valueArg = 0;
	}
	/**
	 * Constructora donde recibe un parametro de enum_bytecode
	 * @param n
	 */
	ENUM_BYTECODE(int n) {
		this.valueArg = n;
	}
	/**
	 * Devuelve el número de parámetros que tiene una instrucción
	 * @return
	 */
	public int getValueArg(){
		return this.valueArg;
	}
}
