
/**
 * Classe ListaLigada implementa uma lista simplesmente encadeada.
 * Possui referenciad para o início e fim da lista, além dos métodos de manipulação principais como, por exemplo, inserirNoComeco, removerNoFinal álem de métodos auxiliares.
 */  
public class ListaLigada {
    private No inicio; // Referência para o primeiro nó da lista
    private No fim; // Referência para o último nó da lista


    //-------------------- Inserir no começo----------------------------------//
    // ---------------------------------------------//
    // Cria um novo nó apontando para o antigo início.
    // Se a lista estava vazia, o novo nó também é o fim, pois só existi um único no.
    public void inserirNoComeco(String elemento) {
        No novoNo = new No(elemento, inicio); // Cria o novo nó apontando para o antigo início , por meio do parametro inicio passado no construtor da classe No
        inicio = novoNo;// Atualiza a referência do início para o novo nó, sem isso a lista perderia o acesso ao novo nó criado e não realizaria a função do método corretamente

        if (fim == null) { // Verificação necessária: sem isso, 'fim' ficaria nulo, mas ele precisa receber o novo nó criado 
            fim = novoNo;
        }
    }

    // ---------------------------------------------
    //----------------------------- Inserir no fim-------------------------------//
    // ---------------------------------------------
    // Adiciona um novo nó ao final da lista.

    public void inserirNoFim(String elemento) {
        No novoNo = new No(elemento, null);

        if (estaVazia()) {      // Necessário: evita acessar 'fim' quando nulo
            inicio = novoNo;   // Se a lista estiver vazia, o nó é início e fim.
            fim = novoNo;
        // sem essa verificação, ocorrerá NullPointerException ao tentar acessar 'fim' quando a lista estiver vazia

        } else {
            fim.setProximo(novoNo); // Liga o último nó ao novo
            fim = novoNo;           // Atualiza referência ao fim
        }
    }

  
    //--------------------------------- Método: Remover do começo---------------------------//
    // Remove o primeiro nó da lista.
    //-----------------------------------
    public void removerNoComeco() {
        if (estaVazia()) {
            System.out.println("A lista está vazia!");  // se a lista estiver vazia, exibe uma mensagem no terminal
            return;
        }

        inicio = inicio.getProximo();
        // Avança o ponteiro início,perdendo a referência ao primeiro nó

        if (inicio == null) { // Se a lista ficar vazia, fim também deve ser nulo.
            fim = null;
        }
    }

   
    //----------------------------- Método: Remover do fim---------------------------//
    // Remove o último nó da lista.
    //-----------------------------------//
    public void removerNoFim() {//Esse método percorre até o penúltimo nó e o torna o novo fim.
        if (estaVazia()) {
            System.out.println("A lista está vazia!");// se a lista estiver vazia, exibe uma mensagem no terminal
            return;
        }

        if (inicio == fim) { // Caso especial quando existe apenas um nó, então inicio e fim recebem null
            inicio = null;
            fim = null;
        } else { 
            // mas caso contrário, percorre a lista para encontrar o penúltimo nó e exercer a funçaõ do método

            No noAtual = inicio;
            while (noAtual.getProximo() != fim) { // percorre a lista até encontrar o penúltimo nó que aponta para o fim utiliizando o getProximo
                noAtual = noAtual.getProximo(); // avança para o próximo nó
            }
            noAtual.setProximo(null);
             // remove a referência para o último nó, retirando ele da lista pois o nó anterior não possui mais a referência para ele,devido ao parametro passado como null, sem esse passo o nó final continuaria existindo na lista e não seria removido corretamente

            fim = noAtual; // atualiza o ponteiro fim para o novo último nó (o penúltimo), finalizando a remoçãodo nó 

        }
    }

  
    //------------------Método: Inserir por posição--------------------------/
    // Insere um nó em uma posição específica, ampliando as opções.
    
    public void inserirPorPosicao(String elemento, int posicao) {// inicializa o método e passa o elemento e a posição como parâmetros
        if (posicao <= 0) {
            inserirNoComeco(elemento);// Se posição <= 0, insere no começo, com o método que já foi criado anteriormente
            return;
        }

        int contador = 0; // inicializa o contador em 0
        No noAtual = inicio; // cria um nó auxiliar para percorrer a lista, começando do início
        // Essas duas variaveis acima são necessárias para controlar a posição atual na lista enquanto percorremos os nós, por meio do while abaixo

        while (noAtual != null && contador < posicao - 1) {// percorre a lista até a posição anterior à desejada , a posição deve ser menos 1 pois o contador começa em 0 mas a posição começa em 1, a posição deve ser menos 1 para que o novo seja inserido na posição correta

            noAtual = noAtual.getProximo();// avança para o próximo nó até que a condição do while seja falsa, ou seja, até que o nó atual seja nulo ou o contador seja igual a posição -1

            contador++;// incrementa o contador em 1, assim a posição atual e é atualizada
        }

        if (noAtual == null || noAtual.getProximo() == null) {// se o nó atual for nulo ou o próximo nó for nulo, significa que a posição é maior que o tamanho da lista
            inserirNoFim(elemento);// eentão utilizamos o método de inserir no fim criado anteriormante 
        } else {
            No novoNo = new No(elemento, noAtual.getProximo());// cria o novo nó apontando para o próximo nó do nó atual , utilizando o noAtual.getProximo() que possui a referencia para o próximo nó
            noAtual.setProximo(novoNo); //atualiza o próximo no da lista para o novo nó
        }
    }

    //-----------------------------------Método: Remover por posição---------------------------//
    // Remove o nó na posição indicada, ampliando as opções de remoção além do começo e fim.
    public void removerPorPosicao(int posicao) {// inicializa o método e passa a posição como parâmetro
        if (estaVazia()) {// verifica se a lista está vazia
            System.out.println("A lista está vazia!"); // mensagem exibida no terminal
            return;
        }

        if (posicao == 0) { // se a posição for 0, remove do começo, utilizando o método já criado anteriormente
            removerNoComeco();
            return;
        }

        int contador = 0; // inicializa o contador em 0
        No noAtual = inicio; // cria um nó auxiliar para percorrer a lista, começando do início
        //Essas duas variaveis acima são necessárias para controlar a posição atual na lista enquanto percorremos os nós, por meio do while abaixo

        while (noAtual != null && contador < posicao - 1) {// percorre a lista até a posição anterior à desejada , a posição deve ser menos 1 pois o contador começa em 0 mas a posição começa em 1, a posição deve ser menos 1 para que o novo seja inserido na posição correta
            noAtual = noAtual.getProximo(); // avança para o próximo nó
            contador++; // incrementa o contador em 1 para atualizar a posição atual
        }

        if (noAtual == null || noAtual.getProximo() == null) {// se o nó atual for nulo ou o próximo nó for nulo, significa que a posição é inválida
            System.out.println("Posição inválida!"); // mensagem exibida no terminal
            return;
        }

        noAtual.setProximo(noAtual.getProximo().getProximo());// atualiza o próximo nó do nó atual para pular o nó na posição desejada, por meio da repetição do noAtual.getProximo duas vezes, removendo, assim, o nó na posição desejada da lista

        if (noAtual.getProximo() == null) {// se o proximo nó for nulo , ou seja não houver mais nós na lista , no criado é o último nó
            fim = noAtual;
        }
    }

    //-------------------------- Método: Buscar por elemento---------------------------------//
    // Percorre os nós até encontrar o elemento desejado.
    public boolean buscarNaLista(String elemento) {
        No noAtual = inicio;
        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento)) {
                return true;
            }
            noAtual = noAtual.getProximo();
        }
        return false;
    }

    // ---------------------------------------------
    // Buscar por posição
    // ---------------------------------------------
    // Retorna o elemento na posição indicada.
    public String buscarPorPosicao(int posicao) {
        int contador = 0;
        No noAtual = inicio;

        while (noAtual != null) {
            if (contador == posicao) {
                return noAtual.getElemento();
            }
            contador++;
            noAtual = noAtual.getProximo();
        }
        return null;
    }

    // ---------------------------------------------
    //------------------------ Exibir lista -------------------------//
    // ---------------------------------------------
    // Percorre a lista e imprime os elementos.
    public void exibirLista() {
        if (estaVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        No noAtual = inicio;
        while (noAtual != null) {
            System.out.print(noAtual.getElemento() + " -> ");
            noAtual = noAtual.getProximo();
        }
        System.out.println("null");
    }

    // ---------------------------------------------
    //-------------------------- Verificar se está vazia--------------------------//
    // ---------------------------------------------//
    public boolean estaVazia() {
        //Se este método faltar pode ocorrer  NullPointerException(Exceção de Ponteiro Nulo) ao  tentar acessar inicio ou fim quando são null, é como tentar acessar algo que não existe na memoria por esse motivo esse método foi utilzado diversas vezes logo ápos a inicialização de vários métodos para evitar essa quebra , álem de evitar que o programa execute uma operação desnecessariamente o restante do método , sendo ,assim essencial ter esse método para evitar erros.

        return inicio == null;
    }

    // ---------------------------------------------
    // Obter tamanho
    // ---------------------------------------------
    // Conta quantos nós existem na lista.
    public int tamanhoDaLista() {
        int contador = 0;// inicializa o contador
        No noAtual = inicio; // cria um nó auxiliar para percorrer a lista, começando do início
        while (noAtual != null) { // percorre a lista até o final enquanto for diferente de nulo
            contador++; // incrementa o contador em 1
            noAtual = noAtual.getProximo(); // avança para o próximo nó
        }
        return contador;// retorna o tamanho total daa lista contado e registrado pelo contador
    }
}