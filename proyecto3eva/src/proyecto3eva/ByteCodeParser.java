package proyecto3eva;

public class ByteCodeParser {
	
	public static ByteCode parse(String s) {
		String[] arrayByteCode = s.split(" ");
		if(s.length() == 0 || s.length() > 2) {
			return null;
		}
		else if(s.length() == 1) {
			switch(arrayByteCode[0]) {
				case "ADD":
					return new ByteCode(ENUM_BYTECODE.ADD);
				case "SUB":
					return new ByteCode(ENUM_BYTECODE.SUB);
				case "MUL":
					return new ByteCode(ENUM_BYTECODE.MUL);
				case "DIV":
					return new ByteCode(ENUM_BYTECODE.DIV);
				case "OUT":
					return new ByteCode(ENUM_BYTECODE.OUT);
				case "HALT":
					return new ByteCode(ENUM_BYTECODE.HALT);
				default:
					return null;
			}
		}
		else {
			switch(arrayByteCode[0]) {
				case "PUSH":
					return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(arrayByteCode[1]));
				case "LOAD":
					return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(arrayByteCode[1]));

				case "STORE":
					return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(arrayByteCode[1]));

				default:
					return null;
			}
		}
	}
}
