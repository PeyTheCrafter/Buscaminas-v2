package modelo;

public class Casilla {
	protected boolean mina = false, velada = true, marcada = false;
	protected int numeroMinas = 0;
	protected int posX, posY;

	public Casilla(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
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

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

}
