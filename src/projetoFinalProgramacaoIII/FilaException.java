package projetoFinalProgramacaoIII;

/* 
 * Uma exce��o personalizada para casos de remo��o e inser��es indevidas em nossa fila de espera.
 */

public class FilaException extends Exception {

	private static final long serialVersionUID = 1L;

	public FilaException(String string) {
		super(string);

	}

}
