import java.util.List;

abstract class Person {

    private String name;

    public Person(){
        this.name = "No_name";
    }

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void displayInfo();

    public final String getFullDetails() {
        return "Name: " + getName();
    }
}

public class Client extends Person {

    private double discount;

    public Client(){
        super();
        this.discount = 0.0;  
    }
    public Client(String name, double discount){
        super(name);
        this.discount = discount;
    }
    public double getDiscount() {
        return discount;
    }
  
}

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
class Zoom{
    private String URL;
    private String Time;
    public Zoom(String URL, String Time){
        this.Time = Time;
        this.URL = URL;
    }

    public String getURL(){
        return URL;
    }
    public String getTime(){
        return Time;
    }
    public void setURL(String newURL){
        this.URL = newURL;
    }
    public void setTime(String newTime){
        this.Time = newTime;
    }
} 
class Meeting{
    private Client client;
    private Psychologist psychologist;
    private Zoom zoom;
    public Meeting(Client client,Psychologist psychologist, Zoom zoom){
        this.client = client;
        this.psychologist = psychologist;
        this.zoom = zoom;
    }
    public void doMeet(){
        System.out.println("Client " ,client.getName(), " They are holding a meeting with ",psychologist.getName()," via the link:" zoom.getURL() ); 
    }

    public void Meeting_Cost(){
        double Meetingcost = psychologist.getCost() - client.getDiscount(); 
        System.out.println("Meeting cost: " Meetingcost);
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
    }
}








