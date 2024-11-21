package com.di;

class Client extends Person {

    private double discount;

    public Client(String name){
        super();
        this.setName(name);
        this.discount = 0.0;  
    }
    public Client(String name, double discount){
        super(name);
        this.discount = discount;
    }
    public double getDiscount() {
        return discount;
    }
    @Override
    public void displayInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayInfo'");
    }
  
}
