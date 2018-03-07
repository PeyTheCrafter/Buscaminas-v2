package modelo;

public class Casilla {
	protected boolean mina = false, velada = true;
	protected int numeroMinas = 0;
	protected Coordenada coordenadas;

	public Casilla(Coordenada coordenadas) {
		super();
		this.coordenadas = coordenadas;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public int getNumeroMinas() {
		return numeroMinas;
	}

	public void setNumeroMinas(int numeroMinas) {
		this.numeroMinas = numeroMinas;
	}

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}

}
