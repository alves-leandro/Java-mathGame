package model;

import java.util.Random;

public class Calcular {
	private int dificuldade;
	private int valor1;
	private int valor2;
	private int operacao;
	private int resultado;
	private int pontuacao;

	public Calcular() {
		this.dificuldade = 1; // Inicia na dificuldade 1 (fácil)
		this.pontuacao = 0;
		gerarNovaOperacao();
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void aumentarPontuacao() {
		pontuacao++;
		if (pontuacao % 10 == 0 && dificuldade < 5) { // Aumenta a dificuldade a cada 10 pontos
			dificuldade++;
		}
	}

	public int getValor1() {
		return valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public int getOperacao() {
		return operacao;
	}

	public int getResultado() {
		return resultado;
	}

	private void gerarNovaOperacao() {
		Random rand = new Random();
		Random randValor = new Random();

		switch (dificuldade) {
		case 1: // Nível fácil: apenas soma e subtração
			valor1 = rand.nextInt(10); // Números de 0 a 9
			valor2 = rand.nextInt(10); // Números de 0 a 9
			operacao = rand.nextInt(2); // 0 - somar, 1 - subtrair
			break;
		case 2: // Nível médio: soma, subtração, multiplicação e divisão
			valor1 = rand.nextInt(10); // Números de 0 a 9
			valor2 = rand.nextInt(10); // Números de 0 a 9
			operacao = rand.nextInt(4); // 0 - somar, 1 - subtrair, 2 - multiplicar, 3 - dividir
			break;
		case 3: // Nível difícil: aumento da faixa de valores
			valor1 = randValor.nextInt(100); // Números de 0 a 99
			valor2 = randValor.nextInt(100); // Números de 0 a 99
			operacao = rand.nextInt(4); // 0 - somar, 1 - subtrair, 2 - multiplicar, 3 - dividir
			break;
		case 4: // Nível muito difícil: aumento da faixa de valores
			valor1 = randValor.nextInt(1000); // Números de 0 a 999
			valor2 = randValor.nextInt(1000); // Números de 0 a 999
			operacao = rand.nextInt(4); // 0 - somar, 1 - subtrair, 2 - multiplicar, 3 - dividir
			break;
		case 5: // Nível insano: aumento da faixa de valores
			valor1 = randValor.nextInt(10000); // Números de 0 a 9999
			valor2 = randValor.nextInt(10000); // Números de 0 a 9999
			operacao = rand.nextInt(4); // 0 - somar, 1 - subtrair, 2 - multiplicar, 3 - dividir
			break;
		default:
			break;
		}
	}

	public String getNomeOperacao() {
		switch (operacao) {
		case 0:
			return "Somar";
		case 1:
			return "Subtrair";
		case 2:
			return "Multiplicar";
		case 3:
			return "Dividir";
		default:
			return "Operação Desconhecida";
		}
	}

	public boolean verificarResposta(int resposta) {
		switch (operacao) {
		case 0:
			resultado = valor1 + valor2;
			break;
		case 1:
			resultado = valor1 - valor2;
			break;
		case 2:
			resultado = valor1 * valor2;
			break;
		case 3:
			resultado = valor1 / valor2;
			break;
		default:
			return false;
		}
		return resposta == resultado;
	}

	public void novaRodada() {
		gerarNovaOperacao();
	}
}
