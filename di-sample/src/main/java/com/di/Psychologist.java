package com.di;

class Psychologist extends Person {

    private double cost;

    public Psychologist(){
        super();
        this.cost = 200.0;  
    }
    public Psychologist(String name, double cost){
        super(name);
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
    @Override
    public void displayInfo() {
        System.out.println("Name: "+ this.getName());
        System.out.println("Cosy: "+ this.getCost());
        
    }
  
}
