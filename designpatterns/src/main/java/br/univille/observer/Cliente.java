package br.univille.observer;

public class Cliente {

    public static void main(String[] args) {
        var grupoFamilia = new Publisher();
        
        var zezinho = new ConcreteSubscribers();
        var huguinho = new ConcreteSubscribers();
        var tia = new ConcreteSubscribers();

        grupoFamilia.subscribers(tia);
        grupoFamilia.subscribers(huguinho);
        grupoFamilia.subscribers(zezinho);

        grupoFamilia.setMainState("Bom dia");
        grupoFamilia.notifySubscriber();
    }
}
