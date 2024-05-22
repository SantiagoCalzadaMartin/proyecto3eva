package proyecto3eva;

public class CPU {
	public OperandStack pila;
	public Memory memoria;
	public boolean halt;
	/**
	 * constructora de cpu
	 */
	public CPU() {
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.halt = false;
	}
	/**
	 * metodo tostring que convierte a string todo el contenido de memoria y pila
	 */
	public String toString() {

		return this.pila.ToString() + "\n" + this.memoria.ToString() + "\n";
	}
	/**
	 * metodo erase que resetea la cpu
	 */
	public void erase() {
		this.memoria = new Memory();
		this.pila = new OperandStack();
	}
	/**
	 * metodo bolean execute que ejecuta las instrucciones newinst del programa
	 * @param instr
	 * @return
	 */
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
	/**
	 * metodo boleano ishalt que devuelve el valor de halt
	 * @return
	 */
	public boolean isHalt() {
		return halt;
	}
	/**
	 * metodo boleano sumapila que devuelve la suma de los dos elementos anteriores de la pila
	 * si se puede hacer
	 * @return
	 */
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
	/**
	 * metodo boleano restapila que devuelve la resta de los dos elementos anteriores de la pila
	 * si se puede hacer
	 * @return
	 */
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
	/**
	 * metodo boleano multiplicapila que devuelve la multiplicación de los dos elementos anteriores de la pila
	 * si se puede hacer
	 * @return
	 */
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
	/**
	 * metodo boleano dividepila que devuelve la division de los dos elementos anteriores de la pila
	 * si se puede hacer
	 * @return
	 */
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
	/**
	 * metodo boleano runcpu que cambia el valor de halt a false y devuelve halt
	 * @return
	 */
	public boolean runCPU() {
		return this.halt = false;
	}
}