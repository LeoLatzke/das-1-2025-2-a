package br.univille.singleton;

public class Cliente {
    public static void main(String[] args) {
        var segredo = "Palmeiras tem mundial";

        var singleton = Singleton.getInstance();
        singleton.setSegredo(segredo);

        //muitas linhas de código depois

        System.out.println(Singleton.getInstance().getSegredo());




    }
}
