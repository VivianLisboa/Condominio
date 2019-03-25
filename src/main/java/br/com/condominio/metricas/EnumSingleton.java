package br.com.condominio.metricas;

public enum EnumSingleton {
	INSTANCE;

	private int counter = 0;

	public void inc() {
		counter++;
	}

	public int getCounter() {
	return counter;

}

}
