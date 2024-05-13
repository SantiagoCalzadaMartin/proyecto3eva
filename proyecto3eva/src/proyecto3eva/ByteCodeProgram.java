package proyecto3eva;

public class ByteCodeProgram {
	public int NumElements;
	public int size;
	private ByteCode[] program;

	public ByteCodeProgram() {
		this.NumElements = 0;
		this.size = 10;
		this.program = new ByteCode[size];
	}

	public void ReSize(int pos) {
		if (pos > this.size) {
			ByteCode program2[] = new ByteCode[this.size * 2];
			this.program = program2;
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
		ReSize(pos);
		if(pos <= this.program.length && program[pos] != null) {
			program[pos] = bc;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setPosition(ByteCode bc) {
		this.program[NumElements] = bc;
	}
	
	public String runProgram(CPU cpu) {
		String mensaje = " ";
		for(int i = 0; i < this.NumElements; i++) {
			if(!cpu.isHalt() && cpu.execute(this.program[i])) {
				//texto de la maquina virtual del ejemplo del jhony
			}
			else if(!cpu.isHalt()) {
				//texto de la maquina virtual del ejemplo del jhony				
			}
		}
		cpu.erase();
		cpu.runCPU();
		return mensaje;
	}
}