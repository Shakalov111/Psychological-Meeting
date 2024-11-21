package com.di;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("Client " + client.getName() + " They are holding a meeting with " + psychologist.getName() + " via the link:" + zoom.getURL() ); 
    }

    public void Meeting_Cost(){
        double Meetingcost = psychologist.getCost() - client.getDiscount(); 
        System.out.println("Meeting cost: " + Meetingcost);
    }
    public static void main(String[] args){
        List<Meeting> meetings = new ArrayList<>();
        Client ivan = new Client("Ivan");
        Client dima = new Client("Dima", 100);
        Psychologist polina = new Psychologist("polina", 2000);
        Zoom meet1 = new Zoom("Zoom/U1vqQ","18:00");
        Zoom meet2 = new Zoom("Zoom/U1vqQ","19:00");
        Meeting meeting1 = new Meeting(dima,polina,meet1);
        meetings.add(meeting1);
        Meeting meeting2 = new Meeting(ivan,polina,meet2);
        meetings.add(meeting2);
        for(Meeting meeting: meetings){
            meeting.doMeet();
        }
    }
}