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
		Scanner sc = new Scanner(System.in);
		CommandParse obj1 = new CommandParse();
		Engine obj2 = new Engine();
		do {
			String opc = sc.next();
			command = ENUM_COMMAND.valueOf(opc);
			switch(command) {
				case HELP:
					obj1.parse(opc);
					obj2.HELP();
					break;
				case QUIT:
					obj1.parse(opc);
					obj2.QUIT();
					fin = 1;
					break;
				case RUN:
					obj1.parse(opc);
					obj2.RUN();
					break;
				case NEWINST:
					obj1.parse(opc);
					obj2.NEWINST_BYTECODE();
					break;
				case RESET:
					obj1.parse(opc);
					obj2.RESET();
					break;
				case REPLACE:
					obj1.parse(opc);
					obj2.REPLACE();
					break;
				default: 
					System.out.println("Error en el codigo");
			}
		}while(fin == 0);
		return true;
	}
}
