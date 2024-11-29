package com.di;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

class Psychologist extends Person {

    private double cost;

    // public Psychologist(){
    //     super();
    //     this.cost = 200.0;  
    // }
    // @Inject
    // public Psychologist(@Named("Name") String name, 
    //                     @Named("Cost") double cost){
    //     super(name);
    //     this.cost = cost;
    // }

    @Inject
    public void setName(@Named("Name") String name) {
       super.setName(name); 
    }

    @Inject
    public void setCost(@Named("Cost") Double cost ) {
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
