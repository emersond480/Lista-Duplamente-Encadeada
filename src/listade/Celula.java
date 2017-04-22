package listade;

public class Celula {
	private Celula proxima;
	private Celula anterior;
	private Aluno elemento;

	public Celula(Celula proxima, Aluno elemento) {
		this.proxima = proxima;
		this.anterior = null;
		this.elemento = elemento;
	}

	public Celula getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}

	public Celula(Aluno elemento) {
		this.elemento = elemento;
	}

	public Celula getProxima() {
		return proxima;
	}

	public void setProxima(Celula proxima) {
		this.proxima = proxima;
	}

	public Aluno getElemento() {
		return elemento;
	}

	public void setElemento(Aluno elemento) {
		this.elemento = elemento;
	}

}
