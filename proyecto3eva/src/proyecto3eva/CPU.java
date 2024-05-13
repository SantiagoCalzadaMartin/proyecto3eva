package proyecto3eva;

public class CPU {
	public OperandStack pila;
	public Memory memoria;
	public boolean halt;
	
	public CPU() {
	}
	
	public void ToString() {
		OperandStack ob1 = new OperandStack();
		Memory ob2 = new Memory();
		
		ob1.ToString();
		ob2.ToString();
	}
	
	public void erase() {
		this.memoria = new Memory();
		this.pila = new OperandStack();
	}
	
	public boolean execute(ByteCode instr) {
		if(instr.equals(ENUM_BYTECODE.ADD)) {
			sumaPila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.SUB)) {
			restaPila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.MUL)) {
			multiplicaPila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.DIV)) {
			dividePila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.OUT)) {
			outPila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.HALT)) {
			isHalt();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.STORE)) {
			storePila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.LOAD)) {
			loadPila();
			return true;
		}
		else if(instr.equals(ENUM_BYTECODE.PUSH)) {
			pushPila();
			return true;
		}
		return false;
	}
	
	public boolean isHalt() {
		this.halt = true;
		return halt;
	}
	
	public boolean sumaPila() {
		int num1 = pila.pop();
		int num2 = pila.pop();
		
		int suma = num1 + num2;
		pila.push(suma);
		return true;
	}
	
	public boolean restaPila() {
		int num1 = pila.pop();
		int num2 = pila.pop();
		
		int suma = num1 - num2;
		pila.push(suma);
		return true;
	}
	
	public boolean multiplicaPila() {
		int num1 = pila.pop();
		int num2 = pila.pop();
		
		int suma = num1 * num2;
		pila.push(suma);
		return true;
	}
	
	public boolean dividePila() {
		int num1 = pila.pop();
		int num2 = pila.pop();
		
		int suma = num1 / num2;
		pila.push(suma);
		return true;
	}
	
	public boolean outPila() {
		System.out.println("La cima de la pila es: " + pila.peek());
		return true;
	}
	
	public boolean storePila() {
		ByteCode ob1 = new ByteCode();
		this.memoria.Write(ob1.getParam(), this.pila.pop());
		return true;
	}
	
	public boolean loadPila() {
		ByteCode ob1 = new ByteCode();
		this.memoria.Read(ob1.getParam());
		return true;
	}
	
	public boolean pushPila() {
		ByteCode ob1 = new ByteCode();
		this.pila.push(ob1.getParam());
		return true;
	}
	
	public boolean runCPU() {
		return this.halt = false;
	}
	//todos los bytecode que se pueden poner
}