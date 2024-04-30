package proyecto3eva;

public class Engine {
	
	public Engine() {
		
	}
	
	public static void start() {
		Command obj3 = new Command();
		obj3.execute(new Engine());
	}
	
	public static void HELP() {
		System.out.println("HELP: muestra esta ayuda");
		System.out.println("QUIT: cierra la aplicación");
		System.out.println("RUN: ejecuta el programa");
		System.out.println("NEWINST BYTECODE: introduce una nueva instrucción al programa");
		System.out.println("RESET: vacía el programa");
		System.out.println("REPLACE: reemplaza n instrucción por la del usuario");
	}
	
	public static void QUIT() {
		System.out.println("Saliste del programa");
	}
	
	public static void RUN() {
		
	}
	
	public static void NEWINST_BYTECODE() {
		
	}
	
	public static void RESET() {
		
	}
	
	public static void REPLACE() {
		
	}
	
	public static void main(String[] args) {
		start();
	}
}