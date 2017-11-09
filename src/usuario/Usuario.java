package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import dados.Nota;
import utilitarios.Console;

public class Usuario {

	private static HashMap<Integer, Nota> listaNotas = new HashMap<Integer, Nota>();
	
	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("1-Incluir nota");
			System.out.println("2-Consultar nota pela matricula");
			System.out.println("3-Consultar notas pelo nome");
			System.out.println("4-Excluir nota");
			System.out.println("0-Sair");
			opcao=Console.readInt("Informe a opção: ");
			switch (opcao) {
			case 1:
				incluir();
				break;
			case 2:
				pesqMat();
				break;
			case 3:
				pesqNome();
				break;
			case 4:
				excluir();
				break;
			case 0 : break;	
			default:
				System.out.println("Opção Inválida.");
				break;
			}
		} while (opcao!=0);
		
	}

	private static void excluir() {
		System.out.println("\nExcluir nota\n");
		Integer matricula = Console.readInt("Informa a Matricula: ");
		if (listaNotas.containsKey(matricula)) {
			System.out.println(listaNotas.get(matricula).toString());
			if (Console.readLine("Excluir nota? s/n : ").equalsIgnoreCase("s")) {
				listaNotas.remove(matricula);
				System.out.println("Nota excluida.");
			}
		}else {
			System.out.println("Não existe nota para a matricula.");
		}
	}

	private static void incluir() {
		System.out.println("\nIncluir nota\n");
		Integer reg = 0;
		while (true) {
			reg = Console.readInt("Matricula: ");
			if (listaNotas.containsKey(reg)) {
				System.out.println("Já existe nota cadastrada para o aluno.");
			} else break;
		}
		String nome = Console.readLine("Nome: ");
		int nota = Console.readInt("Nota: ");
		listaNotas.put(reg, new Nota(reg, nome, nota));
		System.out.println("Nota cadastrada.");
		
	}

	private static void pesqMat() {
		System.out.println("\nPesquisar nota pela matricula\n");
		Integer reg = Console.readInt("Informe a matricula: ");
		if (listaNotas.containsKey(reg)) {
			System.out.println(listaNotas.get(reg).toString());
		} else {
			System.out.println("Não existe nota para a matricula.");
		}
		
	}

	private static void pesqNome() {
		System.out.println("\nPesquisar nota pelo nome\n");
		String nome = Console.readLine("Informe o nome: ");
		ArrayList<Nota> resp = new ArrayList<Nota>();
		for (Nota obj : listaNotas.values()) {
			if (obj.getNome().contains(nome)) {
				resp.add(obj);
			}
		}
		
		Collections.sort(resp, new Comparator<Nota>() {

			@Override
			public int compare(Nota o1, Nota o2) {
				// TODO Auto-generated method stub
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		for (Nota objNota : resp) {
			System.out.println(objNota.toString());
		}
	}

}
