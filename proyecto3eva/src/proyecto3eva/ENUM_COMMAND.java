package proyecto3eva;

public enum ENUM_COMMAND {
	HELP, QUIT, NEWINST(1), RUN, RESET, REPLACE(1);
	private int valueArg;
	
	/**
	 * Constructora simple de enum_command
	 */
	ENUM_COMMAND() {
		this.valueArg = 0;
	}
	/**
	 * Constructora donde recibe un parametro de enum_command
	 * @param n
	 */
	ENUM_COMMAND(int n) {
		this.valueArg = n;
	}
	/**
	 * Devuelve el número de parámetros que tiene un comando
	 * @return
	 */
	public int getValueArg(){
		return this.valueArg;
	}
}