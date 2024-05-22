	package proyecto3eva;

public class Memory {
	boolean isEmpty = true;
	int Size = 10;
	Integer memory[] = new Integer[Size];

	public boolean Write(int pos, int value) {
		if (pos >= 0) {
			this.ReSize(pos);
			this.memory[pos] = value;
			return true;
		} else {
			return false;
		}
	}

	public int Read(int pos) {
		int retorno;
		if(this.memory[pos] == null) {
			retorno = -1;
			return retorno;
		} else if (memory[pos] >= 0) {
			retorno = memory[pos];
			return retorno;
		} else {
			retorno = -1;
			return retorno;
		}
	}

	public void ReSize(int pos) {
		this.isEmpty = false;
		if (pos >= memory.length) {
			Integer memory2[] = new Integer[pos * 2];
			for(int  i = 0; i < memory.length; i++) {
				memory2[i] = memory[i];
			}
			this.memory = memory2;
		}
	}

	public String ToString() {
		String fraseFinal = "Memoria: ";
		String fraseIntermedia = "";
		if (isEmpty == true) {
			fraseIntermedia = "<vacia>";
		} else {
			for (int i = 0; i < memory.length; i++) {
				if(memory[i] != null) {
					fraseIntermedia += "[" + i + "]" + ":" + memory[i] + " ";
				}
			}
		}
		fraseFinal += fraseIntermedia;
		return fraseFinal;
	}
}
