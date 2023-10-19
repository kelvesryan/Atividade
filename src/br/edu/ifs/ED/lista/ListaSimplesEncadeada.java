package br.edu.ifs.ED.lista;

public class ListaSimplesEncadeada<T extends Comparable<T>> extends Lista<T> {
    protected No<T> primeiro;
    protected int tamanho;

    public ListaSimplesEncadeada() {
        primeiro = null;
        tamanho = 0;
    }

    @Override
    public void incluir(T elemento) {
        No<T> novoNo = new No<>(elemento);
        novoNo.proximo = primeiro;
        primeiro = novoNo;
        tamanho++;
    }

    @Override
    public T get(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição solicitada não existe na lista");
        }
        No<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.elemento;
    }

    public int getPosElemento(T elemento) {
        No<T> atual = primeiro;
        int posicao = 0;
        while (atual != null) {
            if (atual.elemento.equals(elemento)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição solicitada não existe na lista");
        }
        if (posicao == 0) {
            primeiro = primeiro.proximo;
        } else {
            No<T> anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.proximo;
            }
            No<T> atual = anterior.proximo;
            anterior.proximo = atual.proximo;
        }
        tamanho--;
    }

    @Override
    public void limpar() {
        primeiro = null;
        tamanho = 0;
    }

    @Override
    public int getTamanho() {
        int tamanho = 0;
        No<T> atual = primeiro;

        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }


    @Override
    public boolean contem(T elemento) {
        return getPosElemento(elemento) != -1;
    }

    @Override
    public int compareTo(Lista<T> outraLista) {
        ListaSimplesEncadeada<T> outraListaSimples = (ListaSimplesEncadeada<T>) outraLista;

        No<T> atual1 = primeiro;
        No<T> atual2 = outraListaSimples.primeiro;

        int cont1 = 0;
        int cont2 = 0;

        while (atual1 != null && atual2 != null) {
            int resultadoComparacao = atual1.elemento.compareTo(atual2.elemento);
            if (resultadoComparacao != 0) {
                return resultadoComparacao;
            }
            atual1 = atual1.proximo;
            atual2 = atual2.proximo;
            cont1++;
            cont2++;
        }
        while (atual1 != null) {
            atual1 = atual1.proximo;
            cont1++;
        }
        while (atual2 != null) {
            atual2 = atual2.proximo;
            cont2++;
        }
        if (cont1 == cont2) {
            return 0;
        } else if (cont1 < cont2) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public T[] TransformarEmVetor() {
        T[] vetor = (T[]) new Comparable[tamanho];
        No<T> atual = primeiro;
        int indice = 0;

        while (atual != null) {
            vetor[indice] = atual.elemento;
            atual = atual.proximo;
            indice++;
        }
        return vetor;
    }
}
