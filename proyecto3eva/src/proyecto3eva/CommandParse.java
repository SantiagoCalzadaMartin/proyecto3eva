package proyecto3eva;

public class CommandParse {
	//Exactamente igual a la teoria de ByteCodeParser	
	public static Command parse(String line) {
		String cadena[] = line.split(" ");
		if(cadena.length == 0) {
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
			return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(cadena[1]));
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

/** Ajustar este codigo aquí
 * 	puede tener longitud 1, 2, o 3
 	public static Command parse(String line) {
 
    String[] parts = line.trim().split("\\s+"); // Divide la línea en partes separadas por espacios en blanco
    if (parts.length == 0) {
        return null; // Si no hay partes, la línea es inválida
    }
    
    String commandName = parts[0]; // El primer elemento es el nombre del comando
    ENUM_COMMAND commandEnum;
    try {
        commandEnum = ENUM_COMMAND.valueOf(commandName); // Intenta convertir el nombre del comando en un ENUM_COMMAND
    } catch (IllegalArgumentException e) {
        return null; // Si el nombre del comando no es válido, la línea es inválida
    }
    
    // Crea un objeto Command correspondiente al comando identificado
    Command command = new Command();
    command.setCommand(commandEnum);
    
    // Aquí podrías procesar los parámetros adicionales del comando si los hubiera
    
    return command;
}
*/