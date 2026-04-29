package com.example.workshop2026;

import javafx.beans.property.DoubleProperty;

public class ExampleThread extends Thread{
    private PortfolioManager myManager;
    private boolean stopIt;
    public ExampleThread(String name, PortfolioManager pm){
        super(name);
        myManager = pm;
        stopIt = false;
    }

    @Override
    public void start() {
        stopIt = false;
        super.start();
    }

    @Override
    public void run() {
        while(!stopIt){
            myManager.setMarketValue(myManager.getMarketValue() + 10);
            myManager.setProfitLoss(myManager.getProfitLoss() + 15);
            System.out.println("marketValue: " + myManager.getMarketValue());
            System.out.println("ProfitLoss: " + myManager.getProfitLoss());
           try {
               sleep(2000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        }
        System.out.println("Bye!......");
    }
    public void stopIt(){
        stopIt = true;
    }
}
