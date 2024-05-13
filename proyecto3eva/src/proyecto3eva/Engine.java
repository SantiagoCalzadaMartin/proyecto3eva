package proyecto3eva;

import java.util.Scanner;

public class Engine {
	public static int finalBucle = 1;
	
	public Engine() {

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
		finalBucle = 0;
	}

	public static void RUN() {
		ByteCodeProgram ob1 = new ByteCodeProgram();
		ob1.runProgram(null);
	}

	public static void NEWINST_BYTECODE() {
	
	}

	public static void RESET() {

	}

	public static void REPLACE() {

	}

	public static void start() {
		
		while (finalBucle == 1) {
			Scanner sc = new Scanner(System.in);
			String comando = sc.next();
			Command obj3 = CommandParse.parse(comando);
			obj3.execute(null);
		}
	}
}