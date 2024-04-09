package view;

import java.util.Scanner;

import model.Calcular;

public class Game {

	private static final Scanner scanner = new Scanner(System.in);
	private static int pontos = 0;
	private static Calcular calcular;

	public static void main(String[] args) {
		jogar();
	}

	public static void jogar() {
		System.out.println("Informe o nível de dificuldade desejado [1, 2, 3 ou 4]: ");
		int dificuldade = scanner.nextInt();
		calcular = new Calcular(dificuldade);

		System.out.println("Informe o resultado para a seguinte operação: ");
		exibirPergunta();

		int resposta = scanner.nextInt();

		if (calcular.verificarResposta(resposta)) {
			pontos++;
			System.out.println("Resposta correta! Você tem " + pontos + " ponto(s).");
		} else {
			System.out.println("Resposta errada! O valor correto é: " + calcular.getResultado());
		}

		System.out.println("Deseja continuar? [1 - sim, 0 - não]");
		int continuar = scanner.nextInt();

		if (continuar == 1) {
			jogar();
		} else {
			System.out.println("Você fez " + pontos + " ponto(s).");
			System.out.println("Até a próxima!");
			System.exit(0);
		}
	}

	private static void exibirPergunta() {
		System.out.println(calcular.getValor1() + " " + calcular.getNomeOperacao() + " " + calcular.getValor2());
	}
}
