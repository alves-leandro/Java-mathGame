package model;

import java.util.Random;

public class Calcular {
	private int dificuldade;
	private int valor1;
	private int valor2;
	private int operacao;
	private int resultado;

	public Calcular(int dificuldade) {
		Random rand = new Random();
		this.operacao = rand.nextInt(4);
		this.dificuldade = dificuldade;
		setValores(rand);
	}

	private void setValores(Random rand) {
		switch (dificuldade) {
		case 1:
			valor1 = rand.nextInt(10);
			valor2 = rand.nextInt(10);
			break;
		case 2:
			valor1 = rand.nextInt(100);
			valor2 = rand.nextInt(100);
			break;
		case 3:
			valor1 = rand.nextInt(1000);
			valor2 = rand.nextInt(1000);
			break;
		case 4:
			valor1 = rand.nextInt(10000);
			valor2 = rand.nextInt(10000);
			break;
		default:
			valor1 = rand.nextInt(100000);
			valor2 = rand.nextInt(100000);
			break;
		}
	}

	public int getDificuldade() {
		return dificuldade;
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

	public String getNomeOperacao() {
		switch (operacao) {
		case 0:
			return "Somar";
		case 1:
			return "Diminuir";
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
}
