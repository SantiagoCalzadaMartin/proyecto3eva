package proyecto3eva;

public class Memory {
	
	int Size = 10;
	int MAX_Memory;
	Integer memory[] = new Integer[Size];
	
	public boolean Write(int posicion, int valor) {
		return true;
	}
	
	public void Read(int posicion) {		
	}
	
	public void ReSize() {
		this.Size = Size++;
	}
	
	public void ToString() {
		
	}
}
