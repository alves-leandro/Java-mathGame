package view;

import java.util.Scanner;

import model.Calcular;

public class Game {

	static Scanner teclado = new Scanner(System.in);
	static int pontos = 0;
	static Calcular calc;

	public static void main(String[] args) {
		Game.jogar();
	}

	public static void jogar() {
		System.out.println("Informe o nível de dificuldade desejado [1, 2, 3 ou 4]: ");
		int dificuldade = Game.teclado.nextInt();

		Game.calc = new Calcular(dificuldade);

		System.out.println("Informe o resultado para a seguinte operação: ");

		// somar
		if (calc.getOperação() == 0) {
			System.out.println(calc.getValor1() + " + " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.somar(resposta)) {
				// ganha 1 pto
				Game.pontos += 1;
				System.out.println("Você tem " + Game.pontos + " ponto(s).");
			}
		}

		// diminuir
		else if (calc.getOperação() == 1) {
			System.out.println(calc.getValor1() + " - " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.diminuir(resposta)) {
				// ganha 1 pto
				Game.pontos += 1;
				System.out.println("Você tem " + Game.pontos + " ponto(s).");
			}
		}

		// multiplicar
		else if (calc.getOperação() == 2) {
			System.out.println(calc.getValor1() + " X " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.multiplicar(resposta)) {
				// ganha 1 pto
				Game.pontos += 1;
				System.out.println("Você tem " + Game.pontos + " ponto(s).");
			}
		}

		// dividir
		else if (calc.getOperação() == 3) {
			System.out.println(calc.getValor1() + " / " + calc.getValor2());
			int resposta = Game.teclado.nextInt();

			if (calc.dividir(resposta)) {
				// ganha 1 pto
				Game.pontos += 1;
				System.out.println("Você tem " + Game.pontos + " ponto(s).");
			}
		} else {
			System.out.println("A operação " + calc.getOperação() + " não é reconhecida.");
		}
		
		System.out.println("Deseja continuar? [1 - sim, 0 - não]");
		int continuar = Game.teclado.nextInt();
		
		if(continuar ==1) {
			Game.jogar();
		} else {
			System.out.println("Você fez " + Game.pontos + " ponto(s).");
			System.out.println("Até a próxima!");
			System.exit(0);
		}
	}

}
