import java.util.Random;

class No{
  int dado;
  No prox; 
}

class ListaLigadaSimples {
  No primeiro, ultimo;
  int qtde;

  ListaLigadaSimples (){
    this.qtde = 0;
    this.primeiro = this.ultimo = null;
  }

  void inserirNoComeco (int dado){
    No novo = new No();
    novo.dado = dado;
    novo.prox = this.primeiro;
    this.primeiro = novo;
    if (this.estaVazia())
      this.ultimo = this.primeiro;
    this.qtde++;
  }

  void exibirLista(){
    No aux = this.primeiro;
    while (aux != null){
      System.out.printf ("%d ", aux.dado);
      aux = aux.prox;
    }
    System.out.println();
  }

  int obter (int indice){
    if (indice < 0 || indice >= this.qtde)return -1;
    No aux = this.primeiro;
    for (int i = 0; i < indice; i++, aux = aux.prox);
    return aux.dado;

  }

  boolean estaVazia(){
    return this.qtde <= 0;
  }

  void inserirNoFinal (int dado){
    if (this.estaVazia()){
      inserirNoComeco(dado);
      return;
    }
    No novo = new No();
    novo.dado = dado;
    novo.prox = null;
    No aux = this.primeiro;
    while (aux.prox != null){
      aux = aux.prox;
    }
    aux.prox = novo;
    this.ultimo = novo;
    this.qtde++;

  }
}

class Main{
  public static void main (String [] args){
    ListaLigadaSimples lista = new ListaLigadaSimples();
    Random gerador = new Random();
    for (int i = 0; i < 10; i++){
      int dado = gerador.nextInt(20) + 1;
      lista.inserirNoComeco(dado);
      lista.exibirLista();
      int posicao = gerador.nextInt(lista.qtde);
      //Melhor caso, tempo constante: O(1)
      //Pior caso, tempo linear em N: O(n)
      System.out.printf("lista[%d]=%d\n", posicao, lista.obter(posicao));
    }
  }
}


// class Main {
//   public static void main(String[] args) {
//     ListaLigadaSimples lista = new ListaLigadaSimples();
//     Random gerador = new Random();
//     for (int i = 0; i < 100; i++){
//       int dado = gerador.nextInt(20) + 1;
//       lista.inserirNoComeco(dado);
//       lista.exibirLista();
//       System.out.println("\n*********************");
//     }
//   }
// }