package proyecto3eva;

public class ByteCodeProgram {
	public int NumElements;
	public int size;
	private ByteCode[] program;

	public ByteCodeProgram() {
		this.NumElements = 10;
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

	public void replacePosition(ByteCode bc, int pos) {
		ReSize(pos);
		int i = 0;
		while(i <= program.length) {
			if(i == pos) {
				program[i] = bc;
			}
			i++;
		}
	}
	
	public void setPosition() {
		//agregar al programa el elemento
	}
}