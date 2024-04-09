package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Calcular;

public class Game {

	private static final Scanner scanner = new Scanner(System.in);
	private static int pontos = 0;
	private static Calcular calcular;

	public static void main(String[] args) {
		calcular = new Calcular(); // Inicializa o objeto calcular

		while (true) {
			try {
				clearScreen(); // Limpa a tela antes de exibir a próxima pergunta

				System.out.println("Bem-vindo ao jogo de matemática!");
				System.out.println("Você está no nível de dificuldade " + calcular.getDificuldade());
				System.out.println("Informe o resultado para a seguinte operação: ");
				exibirPergunta();

				int resposta = scanner.nextInt();

				if (calcular.verificarResposta(resposta)) {
					pontos++;
					System.out.println("Resposta correta! Você tem " + pontos + " ponto(s).");

					if (pontos % 10 == 0) {
						System.out.println("Parabéns! Você avançou para o próximo nível de dificuldade.");
					}
				} else {
					System.out.println("Resposta errada! O valor correto é: " + calcular.getResultado());
				}

				calcular.aumentarPontuacao();
				calcular.novaRodada();

				System.out.println("Deseja continuar? [1 - sim, 0 - não]");
				int continuar = scanner.nextInt();

				if (continuar == 0) {
					System.out.println("Você fez " + pontos + " ponto(s).");
					System.out.println("Até a próxima!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, insira um número.");
				scanner.nextLine(); // Limpa o buffer do scanner
			}
		}
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J"); // Código ANSI para limpar a tela
		System.out.flush();
	}

	private static void exibirPergunta() {
		System.out.println(calcular.getValor1() + " " + calcular.getNomeOperacao() + " " + calcular.getValor2());
	}
}
