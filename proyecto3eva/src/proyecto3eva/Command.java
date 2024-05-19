package proyecto3eva;

import java.util.Scanner;

public class Command {

	public static int fin = 0;
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	public Command(ENUM_COMMAND command, ByteCode instruccion) {
		this.command = command;
		this.instruction = instruccion;
	}

	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}
	
	public ENUM_COMMAND getCommand() {
		return this.command;
	}

	public ByteCode getByteCode() {
		return this.instruction;
	}
	
	public Command() {
	}

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
