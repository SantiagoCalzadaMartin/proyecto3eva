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
		if (memory[pos] >= 0) {
			retorno = memory[pos];
			return retorno;
		} else {
			retorno = -1;
			return retorno;
		}
	}

	public void ReSize(int pos) {
		this.isEmpty = false;
		if (pos >= this.Size) {
			Integer memory2[] = new Integer[pos * 2];
			this.memory = memory2;
		}
	}

	public String ToString() {
		String frase = "";
		if (isEmpty == true) {
			frase = "<vacia>";
		} else {
			for (int i = 0; i < memory.length; i++) {
				frase += "[" + i + "]" + ":" + memory[i] + " ";
			}
		}
		return frase;
	}
}
