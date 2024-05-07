package proyecto3eva;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;	

	public ByteCode(ENUM_BYTECODE name) {
		this.name = name;
	}
	
	public ByteCode(ENUM_BYTECODE name, Integer param) {
		this.name = name;
		this.param = param;
	}
	
	public ENUM_BYTECODE getByteCode() {
		return this.name;
	}
	
	public int getParam() {
		return this.param;
	}
}
