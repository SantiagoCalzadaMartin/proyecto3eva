package proyecto3eva;

public class CommandParse {
	/**
	 * metodo statico parse que analiza cual es el comando introducido por el usuario
	 * @param line
	 * @return
	 */
	public static Command parse(String line) {
		String cadena[] = line.split(" ");
		if(cadena.length <= 0) {
			return null;
		}
		else if(cadena[0].equalsIgnoreCase("HELP")) {
			return new Command(ENUM_COMMAND.HELP);
		}
		else if(cadena[0].equalsIgnoreCase("QUIT")) {
			return new Command(ENUM_COMMAND.QUIT);
		}
		else if(cadena[0].equalsIgnoreCase("RUN")) {
			return new Command(ENUM_COMMAND.RUN);
		}
		else if(cadena[0].equalsIgnoreCase("NEWINST")){
			if(cadena.length == 3) {
				String atributos = cadena[1] + " " + cadena[2];
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(atributos));
			}
			else {
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(cadena[1]));
			}
		}
		else if(cadena[0].equalsIgnoreCase("RESET")) {
			return new Command(ENUM_COMMAND.RESET);
		}
		else if(cadena[0].equalsIgnoreCase("REPLACE")) {
			return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(cadena[1]));
		}
		else {
			return null;
		}
	}
}