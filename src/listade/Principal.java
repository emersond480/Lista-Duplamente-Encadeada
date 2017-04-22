package listade;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] noargs) {

		int opc = 0;
		ListaLigada lista = new ListaLigada();
		while (opc != 5) {
			opc = Integer.parseInt(
					JOptionPane.showInputDialog(null, "1 - Inserir Aluno\n2 - Remover\n3 - Listar Alunos\n5 - Sair\n"));

			if (opc == 1) {
				int opc2 = 0;
				opc2 = Integer.parseInt(JOptionPane
						.showInputDialog("\n1 - Inserir no Inicio\n2 - Inserir no Fim\n3 - Inserir na Posição\n"));

				if (opc2 == 1) {
					String nome = JOptionPane.showInputDialog("Digite um nome: ");
					int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
					Aluno a1 = new Aluno(nome, idade);

					lista.addInicio(a1);
				} else if (opc2 == 2) {
					String nome = JOptionPane.showInputDialog("Digite um nome: ");
					int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
					Aluno a2 = new Aluno(nome, idade);

					lista.add(a2);
				} else if (opc2 == 3) {
					int posic = Integer.parseInt(JOptionPane.showInputDialog("Digite a Posição"));
					String nome = JOptionPane.showInputDialog("Digite um nome: ");
					int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
					Aluno a3 = new Aluno(nome, idade);

					lista.add(posic, a3);
				} else {
					JOptionPane.showMessageDialog(null, "Opção Invalida");
				}
			} else if (opc == 2) {
				int opc3 = Integer.parseInt(JOptionPane.showInputDialog(
						"1 - Remover Inicio\n2 - Remove Fim\n3 - Remover por Posição\n4- Remover por Nome"));

				if (opc3 == 1) {
					lista.removeInicio();
				} else if (opc3 == 2) {
					lista.removeFim();
				} else if (opc3 == 3) {
					int posicRm = Integer.parseInt(JOptionPane.showInputDialog("Digite a Posição a ser Removida"));
					lista.remove(posicRm);
				} else if (opc3 == 4) {
					Aluno alunoAux2 = new Aluno();
					String nomeRm = JOptionPane.showInputDialog("Nome a Remover: ");
					int rmId = 0;

					for (int i2 = 0; i2 < lista.tamanho(); i2++) {
						alunoAux2 = lista.pega(i2);
						String nomeConf = alunoAux2.getNome();
						if (nomeRm.equals(nomeConf)) {
							System.out.println("true");
							rmId = i2;
						}
					}
					lista.remove(rmId);
				} else {
					JOptionPane.showMessageDialog(null, "Opção Invalida");
				}
			} else if (opc == 3) {
				Aluno alunoAux = new Aluno();

				System.out.println("\n\nTotal de Elementos na Lista: " + lista.getTotalDeElementos());
				System.out.println("\nPrimeiro: " + lista.getPrimeira().getElemento().getNome() + "\nÚltimo: "
						+ lista.getUltima().getElemento().getNome() + "\n");

				for (int i = 0; i < lista.tamanho(); i++) {
					alunoAux = lista.pega(i);

					System.out.println("Posição: " + i + " Nome: " + alunoAux.getNome() + " Idade: "
							+ alunoAux.getIdade() + lista.antProx(i));
				}

			} else if (opc != 5) {
				JOptionPane.showMessageDialog(null, "Opção Invalida");
			}
		}
	}

}
