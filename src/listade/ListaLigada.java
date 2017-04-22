package listade;

public class ListaLigada {
	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos = 0;

	public Celula getPrimeira() {
		return primeira;
	}

	public void setPrimeira(Celula primeira) {
		this.primeira = primeira;
	}

	public Celula getUltima() {
		return ultima;
	}

	public void setUltima(Celula ultima) {
		this.ultima = ultima;
	}

	public int getTotalDeElementos() {
		return totalDeElementos;
	}

	public void setTotalDeElementos(int totalDeElementos) {
		this.totalDeElementos = totalDeElementos;
	}

	public void add(Aluno elemento) {
		if (this.totalDeElementos == 0) {
			this.addInicio(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}

	public void add(int posicao, Aluno elemento) {
		if (posicao == 0) {
			this.addInicio(elemento);
		} else if (posicao == this.totalDeElementos) {
			this.add(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula proxima = anterior.getProxima();
			Celula nova = new Celula(anterior.getProxima(), elemento);
			nova.setAnterior(anterior);
			anterior.setProxima(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
	}

	public String antProx(int posicao) {
		String nomeAnt, nomeProx;
		Celula cAux = this.pegaCelula(posicao);
		Celula anterior = cAux.getAnterior();
		Celula proximo = cAux.getProxima();

		if (anterior != null) {
			nomeAnt = anterior.getElemento().getNome();
		} else {
			nomeAnt = "Nulo";
		}

		if (proximo != null) {
			nomeProx = proximo.getElemento().getNome();
		} else {
			nomeProx = "Nulo";
		}

		return " Anterior: " + nomeAnt + " Proximo: " + nomeProx;
	}

	public Aluno pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	public void remove(int posicao) {
		if (!this.posicaOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (posicao == 0) {
			this.removeInicio();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removeFim();
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula atual = anterior.getProxima();
			Celula proxima = atual.getProxima();

			anterior.setProxima(proxima);
			proxima.setAnterior(anterior);

			this.totalDeElementos--;
		}

	}

	public int tamanho() {
		return this.totalDeElementos;
	}

	public void addInicio(Aluno elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}

	public void removeInicio() {
		if (!this.posicaOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		this.primeira = this.primeira.getProxima();
		this.primeira.setAnterior(null);
		this.totalDeElementos--;

		if (this.totalDeElementos == 0) {
			this.ultima = null;
		}

	}

	public void removeFim() {
		if (!this.posicaOcupada(this.totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (this.totalDeElementos == 1) {
			this.removeInicio();
		} else {
			Celula penultima = this.ultima.getAnterior();
			penultima.setProxima(null);
			this.ultima = penultima;
			this.totalDeElementos--;
		}

	}

	private boolean posicaOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	public Celula pegaCelula(int posicao) {
		if (!this.posicaOcupada(posicao)) {
			throw new IllegalArgumentException("Posição Não Existe");
		}

		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();
		}
		return atual;
	}

	public boolean contem(Object elemento) {
		Celula atual = this.primeira;

		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProxima();
		}
		return false;
	}

	public String toString() {
		if (this.totalDeElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;

		for (int i = 0; i < this.totalDeElementos - 1; i++) {
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProxima();
		}

		builder.append(atual.getElemento());
		builder.append("]");

		return builder.toString();
	}

}
