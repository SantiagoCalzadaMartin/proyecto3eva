package proyecto3eva;

public class ByteCodeProgram {
	public int NumElements;
	public int size;
	private ByteCode[] program;
	private ByteCode[] program2;
	private Command comando;

	public ByteCodeProgram() {
		this.NumElements = 0;
		this.size = 10;
		this.program = new ByteCode[size];
		this.comando = new Command();
	}

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

	public ByteCode get(int pos) {
		return this.program[pos];
	}

	public void set() {

	}

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

	public boolean replacePosition(ByteCode bc, int pos) {
		if (pos <= this.program.length && program[pos] != null) {
			program[pos] = bc;
			return true;
		} else {
			return false;
		}
	}

	public boolean setPosition(ByteCode bc) {
		ReSize();
		this.program[NumElements] = bc;
		this.NumElements++;
		return true;
	}

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

	public boolean erase() {
		ByteCode[] program3 = new ByteCode[this.size];
		this.program = program3;
		this.NumElements = 0;
		return true;
	}

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