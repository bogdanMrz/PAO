import com.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


class Studio {

    public static void main(String[] args) {
        PresedinteExecutiv.set("Michael", "Johnson", 2000000);

        System.out.println(PresedinteExecutiv.get());

        Actor actor = new Actor("Brad", "Pit", 250000, (byte) 125);
        Personaj personaj = new Personaj("Aldo", "Apache", (short) 30);

        ArrayList<String> recuzita = new ArrayList<String>(3);
        recuzita.add("dinamita");
        recuzita.add("role film");
        recuzita.add("covor rosu");

        Locatie locatie = new Locatie("cinematograj", recuzita);


        Angajat angajat = new Angajat("Jef", "Richard", 200);
        Angajat angajat1 = new Angajat("Quentin", "Tarantino", 70000);

        String trailer = "https://www.youtube.com/watch?v=KnrRy6kSFF0";
        LocalDateTime premiera = LocalDateTime.of(2009, Calendar.MAY, 20, 22, 35);

        int buget = 70000000;
        Film film = new Film("Inglorious Bastards", buget, premiera);


        film.setTrailer(trailer);

        //De aici porneste trailer-ul
        film.playTrailer();
        //

        film.addLocatie(locatie);

        film.addEchipa(angajat);
        film.addEchipa(angajat1);

        film.addDistributie(actor, personaj);

        System.out.println(film.getNume()+" a avut premiera pe "+film.getPremiera());

        actor = new Actor("Cristoph","Walter",20000, (byte) 90);
        System.out.println(actor.getPrenume()+" "+  actor.getImportanta());
        actor.setPrenume("Waltz");
        actor.setImportanta((byte)120);
        System.out.println(actor);
        film.addDistributie(actor,new Personaj("Col Hans","Landa",(short) 52));

        Incasari incasari = new Incasari(2400,20000,5000,20000);
        film.setIncasari(incasari);

        System.out.print(incasari+" = ");
        System.out.println(film.getTotalIncasari());

        film.plataDrepturi(12050);

        System.out.print(film.getIncasari()+" = ");
        System.out.println(film.getTotalIncasari());

        System.out.println(film.getLocatie(0).getRecuzita());

        HashMap<Actor, Personaj>dist = film.getDistributie();

        for (Actor act:dist.keySet()){
            System.out.println(act+ " --> "+dist.get(act));
        }
    }


    ArrayList<Film>filme = new ArrayList<Film>();
    //Reprezinta numarul de filme pe care actorul trebuie sa-l mai realizeze in cadrul Studioului
    HashMap<Actor,Integer>contract = new HashMap<Actor,Integer>();

    PresedinteExecutiv presedinte = null;


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

