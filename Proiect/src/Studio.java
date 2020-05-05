import com.*;
import com.ReaderCSV.ActorCSV;
import com.ReaderCSV.AngajatCSV;
import com.ReaderCSV.PersonajCSV;
import com.comparator.AlfabeticComparePersoana;

import java.time.LocalDateTime;
import java.util.*;

class Studio {

    public static void main(String[] args) {

        System.out.println("Presedinte executiv ->" + Presedinte.get());
        System.out.println();


        String trailer = "https://www.youtube.com/watch?v=KnrRy6kSFF0";
        LocalDateTime premiera = LocalDateTime.of(2009, Calendar.MAY, 20, 22, 35);

        int buget = 70000000;
        Film film = new Film("Inglorious Bastards", buget, premiera);


        film.setTrailer(trailer);

        //De aici porneste trailer-ul
        //film.playTrailer();
        //

        ActorCSV citireActori = new ActorCSV("actori.csv");
        ArrayList<Actor>actori = citireActori.getList();

        PersonajCSV citirePersonaje = new PersonajCSV("personaje.csv");
        ArrayList<Personaj>personaje = citirePersonaje.getList();


       for (int i=0;i<Integer.min(actori.size(),personaje.size());i++){
           film.addDistributie(actori.get(i),personaje.get(i));
       }

       AngajatCSV citireAngajati = new AngajatCSV("angajat.csv");
       ArrayList<Angajat>angajati = citireAngajati.getList();

        for (Angajat angajat: angajati) {
            film.addEchipa(angajat);
        }


       Incasari incasari = new Incasari(316915264	,2000,500000,27800);
       film.setIncasari(incasari);

        ArrayList<String> recuzita = new ArrayList<String>(3);
        recuzita.add("dinamita");
        recuzita.add("role film");
        recuzita.add("covor rosu");

        Locatie locatie = new Locatie("cinematograj", recuzita);
        film.addLocatie(locatie);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(incasari+" = ");
        System.out.println(film.getTotalIncasari());
        System.out.println("Profit="+film.getProfit());

        film.plataDrepturi(1205000);
        film.plataPublicitate(989000);

        System.out.print(film.getIncasari()+" = ");
        System.out.println(film.getTotalIncasari());
        System.out.println("Profit="+film.getProfit());
        System.out.println();

        System.out.println("Cheltuieli = "+film.getCheltuieli());
        System.out.println("Adaugare cheltuiala");
        film.adugaCheltuiala(11111110);

        System.out.println("Cheltuieli = "+film.getCheltuieli());
        System.out.println("Profit="+film.getProfit());
        System.out.println();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HashMap<Actor, Personaj>dist = film.getDistributie();
        for (Actor act:dist.keySet()){
            System.out.println(act+ " --> "+dist.get(act));
        }

        System.out.println();
        angajati = film.getEchipa();

        System.out.println("Angajati in ordine alfabetica:");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.sort(angajati, new AlfabeticComparePersoana());
        for (Angajat ang:angajati){
            System.out.println(ang.getNume());
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

