package main;

import java.time.LocalDate;
import java.util.*;

import Aluno.Aluno;
import presenca.Presenca;
import service.PresencaService;

public class Main {

	static List<Aluno> alunos = new ArrayList<>();
	static List<Presenca> presencas = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static PresencaService service = new PresencaService();

	public static void main(String[] args) {

		for (;;) {

			System.out.println("\n=== SISTEMA DE PRESENÇA ===");
			System.out.println("1 - Cadastrar aluno");
			System.out.println("2 - Registrar presença");
			System.out.println("3 - Ver percentual");
			System.out.println("4 - Listar alunos");
			System.out.println("0 - Sair");

			int opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				cadastrarAluno();
			} 
			else if (opcao == 2) {
				registrarPresenca();
			} 
			else if (opcao == 3) {
				verPercentual();
			} 
			else if (opcao == 4) {
				listarAlunos();
			} 
			else if (opcao == 0) {
				System.out.println("Encerrando...");
				break;
			} 
			else {
				System.out.println("Opção inválida.");
			}
		}
	}

	static void cadastrarAluno() {
		System.out.print("Nome do aluno: ");
		String nome = sc.nextLine();

		int id = alunos.size() + 1;
		alunos.add(new Aluno(id, nome));

		System.out.println("Aluno cadastrado com ID: " + id);
	}

	static void registrarPresenca() {
		listarAlunos();

		System.out.print("ID do aluno: ");
		int id = sc.nextInt();
		sc.nextLine();

		Aluno aluno = buscarAluno(id);

		if (aluno == null) {
			System.out.println("Aluno não encontrado.");
			return;
		}

		System.out.print("Presente? (true/false): ");
		String presenca = sc.next();
		if(presenca.equalsIgnoreCase("s")) {
			boolean presente = true;
			//boolean presente = sc.nextBoolean();

			presencas.add(new Presenca(aluno, LocalDate.now(), presente));

			System.out.println("Presença registrada.");
		} else {
			System.out.println("Falta registrada.");
		}


	}

	static void verPercentual() {
		listarAlunos();

		System.out.print("ID do aluno: ");
		int id = sc.nextInt();

		Aluno aluno = buscarAluno(id);

		if (aluno == null) {
			System.out.println("Aluno não encontrado.");
			return;
		}

		double percentual = service.calcularPercentual(presencas, aluno);

		System.out.println("Percentual: " + percentual + "%");

		if (percentual >= 75) {
			System.out.println("Status: APROVADO");
		} else {
			System.out.println("Status: REPROVADO");
		}
	}

	static void listarAlunos() {
		System.out.println("\nAlunos:");
		for (Aluno a : alunos) {
			System.out.println(a.getId() + " - " + a.getNome());
		}
	}

	static Aluno buscarAluno(int id) {
		for (Aluno a : alunos) {
			if (a.getId() == id) return a;
		}
		return null;
	}
}