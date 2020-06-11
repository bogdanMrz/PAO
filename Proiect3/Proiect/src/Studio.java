import com.*;
import com.ReaderCSV.ActorCSV;
import com.ReaderCSV.AngajatCSV;
import com.ReaderCSV.PersonajCSV;
import com.comparator.AlfabeticComparePersoana;
import com.database.*;


import java.util.*;
class Studio {

    public static void main(String[] args) {

        initData.initAngajati();
        initData.initActori();
        initData.initIncasari();
        initData.initPersonaje();


        initData.addAngajati();

        RepositoryAngajat.insertAngajat(new Angajat("Andrew","Jackson",500));
        RepositoryAngajat.insertAngajat(new Angajat("Jeff", "Chang", 1000));

        System.out.println("Toti angajatii");
        System.out.println(RepositoryAngajat.getAngajati());

        RepositoryAngajat.deleteById(4);
        System.out.println("Dupa stergere id = 4");
        System.out.println(RepositoryAngajat.getAngajati()+"\n");

        System.out.println("Angajatii care se numes Jeff");
        System.out.println(RepositoryAngajat.getAngajatiByName("Jeff")+"\n");


        System.out.println("Angajatul cu Id = 3");
        System.out.println(RepositoryAngajat.getAngajatById(3));
        RepositoryAngajat.updateAngajatNume("Denis",3);
        System.out.println("Dupa update nume");
        System.out.println(RepositoryAngajat.getAngajatById(3));
        RepositoryAngajat.updateAngajatPreme("Franklin",3);
        System.out.println("Dupa update prenume");
        System.out.println(RepositoryAngajat.getAngajatById(3));

        RepositoryAngajat.updateAngajatSalariu(2500,3);
        System.out.println("Dupa update prenume");
        System.out.println(RepositoryAngajat.getAngajatById(3)+"\n\n");


        RepositoryIncasari.insertIncasari(new Incasari(909,200,222,878), "Inglorius Bastards");
        RepositoryIncasari.insertIncasari(new Incasari(500,100,50,999), "Shuter Island");
        RepositoryIncasari.insertIncasari(new Incasari(1000,30,565,800), "Kill Bill");
        RepositoryIncasari.insertIncasari(new Incasari(200,200,400,100), "The Departed");



        System.out.println("Incasari Kill Bill");
        System.out.println(RepositoryIncasari.getIncasariById("Kill Bill"));


        System.out.println("Incasari The Departed");
        System.out.println(RepositoryIncasari.getIncasariById("The Departed"));

        System.out.println("Incasari Inglorious Bastards");
        System.out.println(RepositoryIncasari.getIncasariById("Inglorius Bastards"));

        System.out.println("Modificari:");
        RepositoryIncasari.updateCinema(1200,"Inglorius Bastards");

        System.out.println(RepositoryIncasari.getIncasariById("Inglorius Bastards"));
        RepositoryIncasari.updateDrepturiAutor(1500,"Inglorius Bastards");

        System.out.println(RepositoryIncasari.getIncasariById("Inglorius Bastards"));
        System.out.println(RepositoryIncasari.getIncasariById("Inglorius Bastards"));

        RepositoryIncasari.updatePublicitate(500,"Inglorius Bastards");
        System.out.println(RepositoryIncasari.getIncasariById("Inglorius Bastards"));

        RepositoryIncasari.updateStream(400,"Inglorius Bastards");
        System.out.println(RepositoryIncasari.getIncasariById("Inglorius Bastards"));

        System.out.println("\n\n");

        RepositoryPersonaj.insertPersonaj(new Personaj("Aldo","Rayne",(short)35));
        RepositoryPersonaj.insertPersonaj(new Personaj("Hans","Landa",(short)51));
        RepositoryPersonaj.insertPersonaj(new Personaj("Bruce","Wayne",(short)30));


        System.out.println("Toate personajele");
        System.out.println(RepositoryPersonaj.getPersonaje());

        RepositoryPersonaj.deleteById(3);
        System.out.println("Dupa stergere id = 3");
        System.out.println(RepositoryPersonaj.getPersonaje());

        System.out.println("Personajul cu id = 1");
        System.out.println(RepositoryPersonaj.getPersonajById(1));

        RepositoryPersonaj.updatePersonajPrenume("Apache",1);
        System.out.println("Dupa modificarea numelui");
        System.out.println(RepositoryPersonaj.getPersonajById(1));
        System.out.println("\n\n");

        RepositoryActor.insertActor(new Actor("Brad","Pitt",80000,(byte) 100));
        RepositoryActor.insertActor(new Actor("Cristoph","Waltz",65000,(byte)120));
        RepositoryActor.insertActor(new Actor("Eli","Roth",32000,(byte)55));
        RepositoryActor.insertActor(new Actor("Melanie","Laurent",15000));

        System.out.println("Toti actorii");
        System.out.println(RepositoryActor.getActori());

        RepositoryActor.updateActorSalariu(92000,1);
        System.out.println("Dupa modificare salariu pt id = 1");
        System.out.println(RepositoryActor.getActorById(1));

        RepositoryActor.deleteById(2);
        System.out.println("Toti actorii dupa stergere");
        System.out.println(RepositoryActor.getActori());

        System.out.println("\n\n\n");
        System.out.println("Raspunde cu da sau nu daca vrei ca tabele sa fie sterse");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String drop = scanner.nextLine();

            if (drop.equals("da")  || drop.equals("Da") || drop.equals("DA")){
                initData.dropTables();
                break;
            } else if (drop.equals("nu") || drop.equals("Nu") || drop.equals("NU")){
                break;
            }
        }
    }





    ArrayList<Film>filme = new ArrayList<Film>();
    //Reprezinta numarul de filme pe care actorul trebuie sa-l mai realizeze in cadrul Studioului
    HashMap<Actor,Integer>contract = new HashMap<Actor,Integer>();


    public ArrayList<Film> getFilme() {
        ArrayList<Film>copieFilme = new ArrayList<Film>(filme.size());

        for(Film film:filme){
            copieFilme.add(film);
        }

        return copieFilme;
    }

    public void setFilme(ArrayList<Film> filme) {
        this.filme = new ArrayList<Film>(filme.size());

        for(Film film:filme){
            this.filme.add(film);
        }

    }

    public void addFilm(Film film){
        for(Actor actor:film.getDistributie().keySet()){
            if(contract.containsKey(actor)){
                Integer filme_ramase = contract.get(actor)-1;
                contract.put(actor,filme_ramase);
            }
        }
        this.filme.add(film);
    }

    public int getProfit(){
        int profit = 0;

        for(Film film:filme){
            profit += film.getProfit();
        }

        return profit;
    }
    public int getProfit(int an){
        int profit = 0;

        for(Film film:filme) {
            if (film.getPremiera().getYear() == an) {
                profit += film.getProfit();
            }
        }
        return profit;
    }

    public int getIncasari(){
        int incasari = 0;

        for(Film film:filme){
            incasari += film.getTotalIncasari();
        }

        return incasari;
    }
    public int getIncasari(int an){
        int incasari = 0;

        for (Film film:filme){
            if(film.getPremiera().getYear() == an){
                incasari += film.getTotalIncasari();
            }
        }
        return incasari;
    }


    public int getCheltuieli(){
        int cheltuieli = 0;

        for(Film film:filme){
            cheltuieli += film.getCheltuieli();
        }
        return cheltuieli;
    }
    public int getCheltuieli(int an){
        int cheltuieli = 0;

        for(Film film:filme){
            if(film.getPremiera().getYear() == an){
                cheltuieli += film.getCheltuieli();
            }
        }
        return cheltuieli;
    }



}

