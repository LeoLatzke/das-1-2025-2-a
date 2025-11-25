package br.univille.observer;

import java.util.ArrayList;

public class Publisher {
    // lista estática
    // private Subscriber[] subscribers = new Subscriber[10];
    // lista dinâmica
    private ArrayList<Subscriber> subscribers =
        new ArrayList<>(); 
    private String mainState; 

    public String getMainsString(){
        return mainState;
    }

    public void setMainState(String mainState) {
        this.mainState = mainState;
    }

        //inscreve um assinante na lista de assinante
    public void subscribers(Subscriber assinante){
        subscribers.add(assinante);
    }

        //notifica todo mundo de uma mensagem nova
    public void notifySubscriber(){
        for(Subscriber umAssinante: subscribers){
            umAssinante.update(mainState);
        }
    }






}
