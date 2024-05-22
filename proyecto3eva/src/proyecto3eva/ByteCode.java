package proyecto3eva;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;	
	/**
	 * construcatora de bytecode para bytecodes simples
	 * @param name
	 */
	public ByteCode(ENUM_BYTECODE name) {
		this.name = name;
	}
	/**
	 * constructora de bytecode para bytecodes con parametros adicionales
	 * @param name
	 * @param param
	 */
	public ByteCode(ENUM_BYTECODE name, Integer param) {
		this.name = name;
		this.param = param;
	}
	/**
	 * constructora de bytecode por defecto
	 */
	public ByteCode() {
	}
	/**
	 * metodo getbytecode que devuelve el bytecode
	 * @return
	 */
	public ENUM_BYTECODE getByteCode() {
		return this.name;
	}
	/**
	 * metodo getparam que devuelve el parametro
	 * @return
	 */
	public int getParam() {
		return this.param;
	}
	/**
	 * metodo tostring que convierte a string los bytecode y sus parametros
	 */
	public String toString() {
		String cadena = "";
		
		if(this.name == ENUM_BYTECODE.PUSH || this.name == ENUM_BYTECODE.LOAD || this.name == ENUM_BYTECODE.STORE) {
			cadena += getByteCode() + " " + getParam();
		}
		else {
			cadena += getByteCode();
		}		
		return cadena;
	}
}
