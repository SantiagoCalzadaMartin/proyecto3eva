	package proyecto3eva;

public class Memory {
	boolean isEmpty;
	int Size;
	Integer memory[];
	/**
	 * constructora de memory
	 */
	public Memory() {
		this.isEmpty = true;
		this.Size = 10;
		this.memory = new Integer[Size];
	}
	/**
	 * metodo boleano write que escribe el valor en la posicion indicada si se puede
	 * @param pos
	 * @param value
	 * @return
	 */
	public boolean Write(int pos, int value) {
		if (pos >= 0) {
			this.ReSize(pos);
			this.memory[pos] = value;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * metodo read que devuelve el valor de la posicion indicada de memory
	 * @param pos
	 * @return
	 */
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
	/**
	 * metodo resize que aumenta el tamaño de memory a la posicion indicada * 2
	 * @param pos
	 */
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
	/**
	 * metodo tostring que cambia el contenido de memory a string
	 * @return
	 */
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
