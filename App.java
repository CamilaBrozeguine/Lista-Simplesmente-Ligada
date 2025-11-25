public class App {

    public static void main(String[] args) {  // 
        ListaLigada lista = new ListaLigada(); // cria uma nova lista ligada vazia

//-----------------------------//----------------------------//
        //Metodos da ListaLigada
        // Testando inserção no começo da lista
        System.out.println("------------Adicionando elementos à lista:-----------");
        lista.inserirNoComeco("processo 1");
        lista.inserirNoComeco("processo 2");
        lista.inserirNoComeco("processo 3");

//-----------------------------//----------------------------//
        //exibindo a lista
        System.out.println("Elementos na lista:");
        lista.exibirLista();

//-----------------------------//----------------------------//
        // Testando remoção no começo da lista
        System.out.println("----------Removendo o elemento processo 3:-----------");
        lista.removerNoComeco();
// exibindo a lista após remoção
//-----------------------------//----------------------------//
        lista.exibirLista();

//-----------------------------//----------------------------//

        //testando remoção por posição
        System.out.println("Removendo o elemento processo 2:");
        lista. removerPorPosicao(1);
        lista.exibirLista();

//-----------------------------//----------------------------//

        System.out.println("---------------Tentativa de remoção em possição inxistente:--------------");
        lista. removerPorPosicao(5);
        lista.exibirLista();

//-----------------------------//----------------------------//
        // Testando inserção no fim da lista
        // Testando tamanho da lista
        System.out.println("Tamanho da lista:" + lista.tamanhoDaLista());
 //-----------------------------//----------------------------//
        System.out.println("--------------Esvaziando a lista:----------------------"); // testando se a lista está vazia
        lista. removerNoFim();
        lista.exibirLista();
//-----------------------------//----------------------------//----------------------------//

        System.out.println("---------Testando a validade do métoodo de remoções com a lista vazia----------");
        lista. removerNoFim();
        lista. removerNoComeco();
    }

}
