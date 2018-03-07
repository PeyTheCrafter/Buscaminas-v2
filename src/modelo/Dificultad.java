package modelo;

public enum Dificultad {
	facil(10), normal(20), dificil(30);
	private int valor;

	private Dificultad(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
