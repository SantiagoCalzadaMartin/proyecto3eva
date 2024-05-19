package proyecto3eva;

public class CPU {
	public OperandStack pila;
	public Memory memoria;
	public boolean halt;

	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}

	public String toString() {

		return this.pila.ToString() + "\n" + this.memoria.ToString() + "\n";
	}

	public void erase() {
		this.memoria = new Memory();
		this.pila = new OperandStack();
	}

	public boolean execute(ByteCode instr) {
		switch(instr.getByteCode()) {
			case ADD:
				sumaPila();
				return true;
			case SUB:
				restaPila();
				return true;
			case MUL:
				multiplicaPila();
				return true;
			case DIV:
				dividePila();
				return true;
			case OUT:
				System.out.println("La cima de la pila es: " + pila.peek());
				return true;
			case HALT:
				return this.halt = true;
			case STORE:
				this.memoria.Write(instr.getParam(), this.pila.pop());
				return true;
			case LOAD:
				this.pila.push(this.memoria.Read(instr.getParam()));
				return true;
			case PUSH:
				this.pila.push(instr.getParam());
				return true;
			 default:
				return false;
		}
	}

	public boolean isHalt() {
		return halt;
	}

	public boolean sumaPila() {
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 + num1;
		pila.push(suma);
		return true;
	}

	public boolean restaPila() {
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 - num1;
		pila.push(suma);
		return true;
	}

	public boolean multiplicaPila() {
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 * num1;
		pila.push(suma);
		return true;
	}

	public boolean dividePila() {
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 / num1;
		pila.push(suma);
		return true;
	}

	public boolean runCPU() {
		return this.halt = false;
	}
	// todos los bytecode que se pueden poner
}