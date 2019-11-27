package projetoFinalProgramacaoIII;

public class FilaDeEspera {

	private int fim = 0;
	private static final int CAPACIDADE_DO_HOSPITAL = 100;

	private Paciente[] fila = new Paciente[CAPACIDADE_DO_HOSPITAL];

	public void inserir(Paciente paciente) throws FilaException {
		if (!isFull() && !isEmpty()) {
			fila[fim] = paciente;
			fim++;
			this.ordenar(); // Ordena a fila a cada inserção.
		} else if (!isFull() && isEmpty()) {
			fila[fim] = paciente;
			fim++;
		}

		else {
			throw new FilaException("A fila está cheia!\n Novos pacientes não podem ser inseridos!");
		}
	}

	public boolean isFull() {
		if (fim == fila.length) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (fim == 0) {
			return true;
		} else {
			return false;
		}

	}

	public Paciente remover() throws FilaException {
		Paciente retorno = fila[0];
		if (!isEmpty()) {

			for (int i = 0; i < fila.length - 1; i++) {
				fila[i] = fila[(i + 1)];
			}
			fim--;
			return retorno;
		} else {
			throw new FilaException("A fila está vazia! \n Não há pacientes para serem chamados.");

		}
	}

	public Paciente mostrarHead() throws FilaException {
		if (!isEmpty()) {
			return fila[0];
		} else {
			throw new FilaException("A fila está vazia! \\n Não há pacientes para serem chamados.");
		}
	}

	public void mostrarFila() {
		for (int i = 0; i <= fim - 1; i++) {
			System.out.println(fila[i]);
		}
	}

	/*
	 * A ordenação será feita de acordo com o código de prioridade. Como o
	 * BubbleSort é um algoritmo estável não ocorrerá de dois pacientes com a mesma
	 * prioridade trocarem de lugar durante a ordenação.
	 * 
	 */

	public void ordenar() {
		for (int i = 0; i < fila.length - 1; i++) {
			for (int j = 1; j < fila.length - i; j++) {

				if (fila[j - 1] != null && fila[j] != null) { // Evitando um .getPrioridade de elementos nulos.
					if (fila[j - 1].getPrioridade() > fila[j].getPrioridade()) {
						Paciente aux = fila[j];
						fila[j] = fila[j - 1];
						fila[j - 1] = aux;
					}
				}
			}
		}
	}

}
