package proyecto3eva;

public class ByteCodeParser {
	/**
	 * metodo statico parse que analiza cual es el bytecode introducido por el usuario
	 * @param s
	 * @return
	 */
	public static ByteCode parse(String s) {
		String[] arrayByteCode = s.split(" ");
		if(arrayByteCode.length <= 0 || arrayByteCode.length > 2) {
			return null;
		}
		else if(arrayByteCode.length == 1) {
			if(arrayByteCode[0].equalsIgnoreCase("ADD")) {
					return new ByteCode(ENUM_BYTECODE.ADD);
			}
			else if(arrayByteCode[0].equalsIgnoreCase("SUB")) {
					return new ByteCode(ENUM_BYTECODE.SUB);
			}
			else if(arrayByteCode[0].equalsIgnoreCase("MUL")) {
					return new ByteCode(ENUM_BYTECODE.MUL);
			}
			else if(arrayByteCode[0].equalsIgnoreCase("DIV")) {
					return new ByteCode(ENUM_BYTECODE.DIV);
			}
			else if(arrayByteCode[0].equalsIgnoreCase("OUT")) {
					return new ByteCode(ENUM_BYTECODE.OUT);
			}
			else if(arrayByteCode[0].equalsIgnoreCase("HALT")) {
					return new ByteCode(ENUM_BYTECODE.HALT);
			}
			else {
					return null;
			}
		}
		else {
			if(arrayByteCode[0].equalsIgnoreCase("PUSH")) {
					return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(arrayByteCode[1]));
			}
			if(arrayByteCode[0].equalsIgnoreCase("LOAD")) {
					return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(arrayByteCode[1]));
			}
			if(arrayByteCode[0].equalsIgnoreCase("STORE")) {
					return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(arrayByteCode[1]));
			}
			else {
					return null;
			}
		}
	}
}
