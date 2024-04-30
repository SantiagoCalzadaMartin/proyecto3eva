package proyecto3eva;

public class ByteCodeParser {
	
	public static ByteCode parse(String s) {
		String[] arrayByteCode = s.split(",");
		if(s.length() == 0 || s.length() > 2) {
			return null;
		}
		else if(s.length() == 1) {
			switch(arrayByteCode[1]) {
				case "ADD":
					
				case "SUB":
					
				case "MUL":
					
				case "DIV":
					
				case "OUT":
					
				case "HALT":
					
				default:
					return null;
			}
		}
		else {
			switch(arrayByteCode[1]) {
				case "PUSH":
					
				case "LOAD":
					
				case "STORE":
					
				default:
					return null;
			}
		}
	}
}
