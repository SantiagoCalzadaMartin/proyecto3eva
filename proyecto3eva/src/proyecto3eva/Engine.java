package proyecto3eva;

import java.util.Scanner;

public class Engine {
	public static int finalBucle = 1;
	private ByteCodeProgram program;
	private CPU cpu;
	private Command comando;
	Scanner sc;
	/**
	 * Constructora de engine
	 */
	public Engine() {
		this.program = new ByteCodeProgram();
		this.cpu = new CPU();
		this.comando = new Command();
		this.sc = new Scanner(System.in);
	}
	/**
	 * metodo boleano help que muestra el menu
	 * @return
	 */
	public boolean HELP() {
		System.out.println("HELP: muestra esta ayuda");
		System.out.println("QUIT: cierra la aplicación");
		System.out.println("RUN: ejecuta el programa");
		System.out.println("NEWINST BYTECODE: introduce una nueva instrucción al programa");
		System.out.println("RESET: vacía el programa");
		System.out.println("REPLACE: reemplaza n instrucción por la del usuario");
		return true;
	}
	/**
	 * metodo boleano quit que termina la ejecución del programa
	 * @return
	 */
	public boolean QUIT() {
		System.out.println("Saliste del programa");
		finalBucle = 0;
		return true;
	}
	/**
	 * metodo boleano run que ejecuta el programa almacenado
	 * @return
	 */
	public boolean RUN() {
		System.out.println(this.program.runProgram(this.cpu) + this.program.toString());
		return true;
	}
	/**
	 * metodo boleano newinst bytecode que almacena los bytecode de los comandos
	 * @param BC
	 * @return
	 */
	public boolean NEWINST_BYTECODE(ByteCode BC) {
		if(BC == null) {
			System.err.println("Error: ejecución incorrecta del comando");
		    return false;
		}
		else {
			this.program.setPosition(BC);
			System.out.println(this.program.toString());
			return true;
		}
	}
	/**
	 * metodo boleano reset que resetea el programa
	 * @return
	 */
	public boolean RESET() {
		this.program.erase();
		return true;
	}
	/**
	 * metodo boleano replace que cambia un comando de una posición especifica del programa
	 * @param pos
	 * @return
	 */
	public boolean REPLACE(int pos) {
		if (pos >= this.program.NumElements || pos < 0) {
			System.err.println("Error: ejecución incorrecta del comando");
			return false;
		} else {
			System.out.println("Introduce el nuevo comando");
			ByteCode BC = ByteCodeParser.parse(sc.nextLine());
			if(BC == null) {
				System.out.println("Error: ejecución incorrecta del comando");
				return false;
			}
			else {
				this.program.replacePosition(BC, pos);
				System.out.println(this.program.toString());
				return true;
			}
		}
	}
	/**
	 * metodo start que ejecuta el programa
	 */
	public void start() {

		while (finalBucle == 1) {
			this.comando = CommandParse.parse(sc.nextLine());
			if (this.comando == null) {
				System.err.println("Error: ejecución incorrecta del comando");
			} else if(this.comando.getCommand() != null && this.comando.getByteCode() == null){
				System.out.println("Comienza la ejecución del comando " + this.comando.getCommand() + " "
						+ "\n");				
				this.comando.execute(this);
			}
			else if(this.comando.getCommand() != null && this.comando.getByteCode() != null) {
				System.out.println("Comienza la ejecución del comando " + this.comando.getCommand() + " "
						+ this.comando.getByteCode() + "\n");				
				this.comando.execute(this);
			}
		}
	}
}