package proyecto3eva;

import java.util.Scanner;

public class Command {

	public static int fin;
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	/**
	 *constructora por defecto de command
	 */
	public Command() {
		this.fin = 0;
	}
	/**
	 * constructora de comandos con bytecode de command
	 * @param command
	 * @param instruccion
	 */
	public Command(ENUM_COMMAND command, ByteCode instruccion) {
		this.command = command;
		this.instruction = instruccion;
	}
	/**
	 * constructora de comandos de command
	 * @param command
	 */
	public Command(ENUM_COMMAND command) {
		this.command = command;
	}
	/**
	 * constructora de replace de command
	 * @param command
	 * @param replace
	 */
	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}
	/**
	 * metodo getcommand que devuelve el comando
	 * @return
	 */
	public ENUM_COMMAND getCommand() {
		return this.command;
	}
	/**
	 * metodo getbytecode que devuelve el bytecode
	 * @return
	 */
	public ByteCode getByteCode() {
		return this.instruction;
	}
	/**
	 * metodo execute que ejecuta los comandos mandados de engine
	 * @param engine
	 * @return
	 */
	public boolean execute(Engine engine) {
		do {
			switch(command) {
				case HELP:
					engine.HELP();
					fin = 1;
					break;
				case QUIT:
					engine.QUIT();
					fin = 1;
					break;
				case RUN:
					engine.RUN();
					fin = 1;
					break;
				case NEWINST:
					engine.NEWINST_BYTECODE(this.instruction);
					fin = 1;
					break;
				case RESET:
					engine.RESET();
					fin = 1;
					break;
				case REPLACE:
					engine.REPLACE(this.replace);
					fin = 1;
					break;
			}
		}while(fin == 0);
		return true;
	}
}
