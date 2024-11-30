package com.di;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Meeting{
    private Client client;
    private Psychologist psychologist;
    private Zoom zoom;

    public Meeting(Client client,Psychologist psychologist, Zoom zoom){
        this.client = client;
        this.psychologist = psychologist;
        this.zoom = zoom;
    }
    public void doMeet(){
        System.out.println("Client " + client.getName() + " They are holding a meeting with " + psychologist.getName() + " cost " + psychologist.getCost() + " via the link:" + zoom.getURL() );
        
        Paycheck paycheck = new Paycheck(psychologist.getCost(),zoom.getTime());
        psychologist.pay(paycheck);

    }

    public void Meeting_Cost(){
        double Meetingcost = psychologist.getCost() - client.getDiscount(); 
        System.out.println("Meeting cost: " + Meetingcost);
    }
    public static void main(String[] args){

        List<Meeting> meetings = new ArrayList<>();

        Client ivan = new Client("Ivan");
        Client dima = new Client("Dima", 100);
        
        Injector injector = Guice.createInjector(new PsychologistModule());
        Psychologist psychologist = injector.getInstance(Psychologist.class);

        Connection connection1 = injector.getInstance(Connection.class);

        Zoom meet1 = new Zoom("Zoom/U1vqQ","18:00");
        Zoom meet2 = new Zoom("Zoom/U1vqQ","19:00");

        Meeting meeting1 = new Meeting(dima,psychologist,meet1);
        meetings.add(meeting1);

        Meeting meeting2 = new Meeting(ivan,psychologist,meet2);
        meetings.add(meeting2);

        for(Meeting meeting: meetings){
            meeting.doMeet();
        }



    }
}