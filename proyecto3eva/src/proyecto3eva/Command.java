package proyecto3eva;

import java.util.Scanner;

public class Command {

	public static int fin = 0;
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	public Command(ENUM_COMMAND command, ByteCode intruction) {
		this.command = command;
		this.instruction = instruction;
	}

	public Command(ENUM_COMMAND command) {
		this.command = command;
	}

	public Command(ENUM_COMMAND command, int replace) {
		this.command = command;
		this.replace = replace;
	}

	public Command() {
	}

	public boolean execute(Engine engine) {
		Engine obj2 = new Engine();
		do {
			switch(command) {
				case HELP:
					obj2.HELP();
					fin = 1;
					break;
				case QUIT:
					obj2.QUIT();
					fin = 1;
					break;
				case RUN:
					obj2.RUN();
					fin = 1;
					break;
				case NEWINST:
					obj2.NEWINST_BYTECODE();
					fin = 1;
					break;
				case RESET:
					obj2.RESET();
					fin = 1;
					break;
				case REPLACE:
					obj2.REPLACE();
					fin = 1;
					break;
			}
		}while(fin == 0);
		return true;
	}
}
