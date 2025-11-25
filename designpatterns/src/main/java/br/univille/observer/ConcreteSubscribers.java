package br.univille.observer;

public class ConcreteSubscribers 
    implements Subscriber{

    @Override
    public void update(String context) {
            System.out.println(context);
        }
    }
