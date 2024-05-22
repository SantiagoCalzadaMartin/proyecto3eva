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
				return sumaPila();
			case SUB:
				return restaPila();
			case MUL:
				return multiplicaPila();
			case DIV:
				return dividePila();
			case OUT:
				if(pila.peek() == -1) {
					return false;
				}
				System.out.println("La cima de la pila es: " + pila.peek());
				return true;
			case HALT:
				return this.halt = true;
			case STORE:
				if(this.pila.pop() == -1) {
					return false;
				}
				this.memoria.Write(instr.getParam(), this.pila.pop());
				return true;
			case LOAD:
				if(this.memoria.Read(instr.getParam()) == -1) {
					return false;
				}
				this.pila.push(this.memoria.Read(instr.getParam()));
				return true;
			case PUSH:
				return this.pila.push(instr.getParam());
			 default:
				return false;
		}
	}

	public boolean isHalt() {
		return halt;
	}

	public boolean sumaPila() {
		if(pila.pop() == -1) {
			return false;
		}
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 + num1;
		pila.push(suma);
		return true;
	}

	public boolean restaPila() {
		if(pila.pop() == -1) {
			return false;
		}
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 - num1;
		pila.push(suma);
		return true;
	}

	public boolean multiplicaPila() {
		if(pila.pop() == -1) {
			return false;
		}
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 * num1;
		pila.push(suma);
		return true;
	}

	public boolean dividePila() {
		if(pila.pop() == -1) {
			return false;
		}
		int num1 = pila.pop();
		int num2 = pila.pop();

		int suma = num2 / num1;
		pila.push(suma);
		return true;
	}

	public boolean runCPU() {
		return this.halt = false;
	}
}