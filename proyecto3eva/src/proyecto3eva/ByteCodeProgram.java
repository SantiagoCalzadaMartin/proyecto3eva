package proyecto3eva;

public class ByteCodeProgram {
	public int NumElements;
	public int size;
	private ByteCode[] program;
	private ByteCode[] program2;
	private Command comando;
	/**
	 * constructora de bytecodeprogram
	 */
	public ByteCodeProgram() {
		this.NumElements = 0;
		this.size = 10;
		this.program = new ByteCode[size];
		this.comando = new Command();
	}
	/**
	 * metodo resize que aumenta el tamaño de program al doble
	 */
	public void ReSize() {
		if(this.NumElements >= this.size) {
		this.size *= 2;
		this.program2 = new ByteCode[this.size];
		for (int i = 0; i < program2.length; i++) {
			if (i < program.length) {
				program2[i] = program[i];
			} else {
				program2[i] = null;
			}
		}
		this.program = this.program2;
		}
	}
	/**
	 * metodo get que devuelve el bytecode de la posicion pos de program
	 * @param pos
	 * @return
	 */
	public ByteCode get(int pos) {
		return this.program[pos];
	}
	/**
	 * metodo position devuelve el bytecode de la posicion pos de program si puede
	 * @param pos
	 * @return
	 */
	public ByteCode Position(int pos) {
		if (pos <= program.length) {
			int i = 0;
			while (i <= pos) {
				if (i == pos) {
					return program[i];
				}
				i++;
			}
		}
		return null;
	}
	/**
	 * metodo bolean replaceposition que cambia el bytecode de program de la posicion pos por
	 * el bytecode introducido por el usuario
	 * @param bc
	 * @param pos
	 * @return
	 */
	public boolean replacePosition(ByteCode bc, int pos) {
		if (pos <= this.program.length && program[pos] != null) {
			program[pos] = bc;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * metodo bolean setposition que introduce el bytecode en la siguiente posicion disponible
	 * de program
	 * @param bc
	 * @return
	 */
	public boolean setPosition(ByteCode bc) {
		ReSize();
		this.program[NumElements] = bc;
		this.NumElements++;
		return true;
	}
	/**
	 * metodo runprogram que ejecuta el programa almacenado posicion a posicion mandandoselo a
	 * cpu
	 * @param cpu
	 * @return
	 */
	public String runProgram(CPU cpu) {
		String mensaje = "";
		for (int i = 0; i < this.NumElements; i++) {
			mensaje = mensaje + " Comienza la ejecución del comando " + this.program[i];
			if (!cpu.isHalt() && cpu.execute(this.program[i])) {
				mensaje = mensaje + "\n" + "Estado de la CPU: " + "\n" + cpu.toString() + "\n";
			}else if (!cpu.isHalt()) {
				mensaje = mensaje + "\n" + "Error: ejecución incorrecta del comando" + "\n";
				this.program.toString();
			}
		}
		cpu.erase();
		cpu.runCPU();
		return mensaje;
	}
	/**
	 * metodo bolean erase que resetea program
	 * @return
	 */
	public boolean erase() {
		ByteCode[] program3 = new ByteCode[this.size];
		this.program = program3;
		this.NumElements = 0;
		return true;
	}
	/**
	 * metodo tostring que cambia a string el contenido de program
	 */
	public String toString() {
		String cadena = "Programa almacenado: " + "\n";
		for (int i = 0; i < this.size; i++) {
			if (this.program[i] != null) {
				cadena += i + ":" + this.program[i] + "\n";
			}
		}
		return cadena;
	}
}