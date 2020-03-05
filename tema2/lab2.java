
import java.util.Scanner;
public class lab2
{
    public static void main(String[] args){
        Person x = new Person("John", "Doe", (short) 24, 12342l, "student");
        Person y = new Person("Jane", "Roe", (short) 33, 879655l, "teacher");
        
        System.out.println(x.get_full_name()+", "+x.get_age()+", "+x.get_identity_nr()+", "+x.get_type());
        System.out.println(y.get_full_name()+", "+y.get_age()+", "+y.get_identity_nr()+", "+y.get_type());
        
        Room r = new Room("12A", "normal",(short) 3);
        Room t = new Room("12B", "tech", (short)7);
        
        System.out.println(r.get_number()+", "+r.get_room_type()+", "+r.get_floor());
        System.out.println(t.get_number()+", "+t.get_room_type()+", "+t.get_floor());        
        
        
        Subject s = new Subject(30, r, x);
        Subject z = new Subject(44, t, y);
        
        System.out.println(s.get_nr()+", "+s.get_room()+", "+s.get_teacher()); 
        System.out.println(z.get_nr()+", "+z.get_room()+", "+z.get_teacher());
        
    }
}


class ex
{
    
    int[] note = new int[20];
    double medie_note;   
   
    void afisare_medie(){
        
        Scanner reader = new Scanner(System.in);
        
        for(int i=0;i<note.length;i++){
             note[i] = reader.nextInt();
             
             if(note[i] == -1){
                note[i] = 0;
                medie_note /= i;
                break;
              }
             
             medie_note += note[i];
             
        }
        
        System.out.println(medie_note);
    }
}


class Person{
    
    String name;
    String surname;
    short age;
    long identity_nr;
    String type;
    
    public Person(){
    
    
    }
    
    
    public Person(String name, String surname,
        short age, long identity_nr,String type ){
        
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.identity_nr = identity_nr;
            this.type = type;
        
    }
    
    
    public Person(Person person){
        name = person.get_name();
        surname = person.get_surname();
        age = person.get_age();
        type = person.get_type();
        identity_nr = person.get_identity_nr();
    
    
    }
    
    
    public void set_type(String new_type){type = new_type;}
    public void set_identity_nr(long new_identity_nr){identity_nr = new_identity_nr;}
    public void set_name(String new_name){name = new_name;}
    public void set_surname(String new_surname){surname = new_surname;}
    public void set_age(short new_age){age = new_age;}
    
    
    
    public String get_full_name(){ return name+' '+surname;}
    public String get_name(){return name;}
    public String get_surname(){return surname;}
    public short get_age(){ return age;}
    public String get_type(){return type;}
    public long get_identity_nr(){return identity_nr;}

}



class Room{
    
     String number;
     String room_type;
     short floor;
     
     
     public Room(){
     
      }
      
     public Room(String number, String room_type, short floor){
         this.number = number;
         this.room_type = room_type;
         this.floor = floor;
     }
     
     public Room(Room room){
         number = room.get_number();
         room_type = room.get_room_type();
         floor = room.get_floor();
         
       }
     
     public void set_number(String new_number){number = new_number;}
     public void set_room_type(String new_room_type){room_type = new_room_type;}
     public void set_floor(short new_floor){floor = new_floor;}
     
     public String get_number(){return number;}
     public String get_room_type(){return room_type;}
     public short get_floor(){return floor;}
}




class Subject{
    
    int noOfStudents;
    Room room;
    Person teacher;
    
    
    public Subject(){
        room = new Room();
        teacher = new Person();
    }
    
    public Subject(int nr, Room room, Person teacher){
        noOfStudents = nr;
        this.room = new Room(room);
        this.teacher = new Person(teacher);
        
    }
    
    public int get_nr(){return noOfStudents;}
    public String get_room(){return room.get_number()+", "+room.get_room_type()+", "+room.get_floor() ;}
    public String get_teacher(){return teacher.get_full_name()+", "+teacher.get_age()+", "+teacher.get_identity_nr()+", "+teacher.get_type();}
    
}
