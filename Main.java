import java.util.Random;

class No{
  int dado;
  No prox; 
}

class ListaLigadaSimples {
  No primeiro;
  int qtde;

  ListaLigadaSimples (){
    this.qtde = 0;
    this.primeiro = null;
  }

  void inserirNoComeco (int dado){
    No novo = new No();
    novo.dado = dado;
    novo.prox = this.primeiro;
    this.primeiro = novo;
    this.qtde++;
  }

  void exibirLista(){
    No aux = this.primeiro;
    while (aux != null){
      System.out.printf ("%d ", aux.dado);
      aux = aux.prox;
    }
  }
}


class Main {
  public static void main(String[] args) {
    ListaLigadaSimples lista = new ListaLigadaSimples();
    Random gerador = new Random();
    for (int i = 0; i < 100; i++){
      int dado = gerador.nextInt(20) + 1;
      lista.inserirNoComeco(dado);
      lista.exibirLista();
      System.out.println("\n*********************");
    }
  }
}