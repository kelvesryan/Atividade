package br.edu.ifs.ED.lista;

public class No<T> {
    protected T elemento;
    protected No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}
