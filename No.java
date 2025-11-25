

/**
 * Classe No representa cada elemento da lista ligada.
 * Cada nó guarda um elemento (String) e uma referência para o próximo nó.
 *
 * Objetivo: permitir o encadeamento de elementos na lista.
 * Se omitirmos a referência 'proximo', não haveria como ligar os nós.
 */
public class No {
    private String elemento;
    private No proximo;

    // Construtor: inicializa o nó com o elemento e a referência para o próximo.
    // Se 'proximo' for nulo, significa que este nó é o último da lista.
    public No(String elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public void setElemento(String elemento) { 
        this.elemento = elemento; 
    }

    public String getElemento() { 
        return elemento; 
    }

    public void setProximo(No proximo) { 
        this.proximo = proximo; 
    }

    public No getProximo() { 
        return proximo; 
    }
}