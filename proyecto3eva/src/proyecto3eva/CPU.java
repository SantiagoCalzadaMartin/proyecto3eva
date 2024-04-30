package proyecto3eva;

public class CPU {
	public OperandStack pila;
	public Memory memoria;
	public boolean end;
	
	public CPU() {
		
	}
	
	public void ToString() {
		OperandStack ob1 = new OperandStack();
		Memory ob2 = new Memory();
		
		ob1.ToString();
		ob2.ToString();
	}
	
	public void erase() {
		this.memoria = null;
		this.pila = null;
	}
	
	public boolean execute(ByteCode instr) {
		if(instr.equals(ENUM_BYTECODE.ADD)) {
			sumaPila();
			return true;
		}
		
		return false;
	}
	
	public boolean isHalt() {
		return end;
	}
	
	public void sumaPila() {
		
	}
	
	public void restaPila() {
		
	}
	
	public void multiplicaPila() {
		
	}
	
	public void dividePila() {
		
	}
}
