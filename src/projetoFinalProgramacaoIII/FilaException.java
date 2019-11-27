package projetoFinalProgramacaoIII;

/* 
 * Uma exceção personalizada para casos de remoção e inserções indevidas em nossa fila de espera.
 */

public class FilaException extends Exception {

	private static final long serialVersionUID = 1L;

	public FilaException(String string) {
		super(string);

	}

}
