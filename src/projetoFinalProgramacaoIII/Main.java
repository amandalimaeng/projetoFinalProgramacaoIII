package projetoFinalProgramacaoIII;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FilaDeEspera fila = new FilaDeEspera();
		Scanner sc = new Scanner(System.in);
		int menu;

		do {
			System.out.println("Menu: \n[1]- Adicionar paciente à fila de espera\n"
					+ "[2]- Chamar paciente da fila para o atendimento (remover da fila)\n"
					+ "[3]- Mostrar fila de espera\n" + "[4]- Mostrar próximo paciente a ser chamado\n"
					+ "[5]- Sair\n ");

			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("Digite o nome do paciente: ");
				String nome = sc.next();
				System.out.println("Digite a prioridade do paciente:\n [1]-Alta\n [2]-Média\n [3]-Baixa ");
				int prioridade = sc.nextInt();
				Paciente paciente = new Paciente(nome, prioridade);
				System.out.println("Paciente adicionado à fila com sucesso!");
				try {
					fila.inserir(paciente);
				} catch (FilaException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.print("CHAMANDO : ");
					System.out.println(fila.remover());
				} catch (FilaException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				fila.mostrarFila();
				break;

			case 4:

				try {
					System.out.println("Próximo paciente a ser chamado: ");
					System.out.println(fila.mostrarHead());
				} catch (FilaException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 5:
				System.out.println("Até a próxima!");
				menu = 5;
				break;

			default:
				System.out.println("Você não digitou uma opção válida.");
			}

		} while (menu != 5);

		sc.close();

	}

}
