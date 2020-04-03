import com.*;
import com.comparator.*;

import java.time.LocalDateTime;
import java.util.*;

class Studio {

    public static void main(String[] args) {
        PresedinteExecutiv.set("Michael", "Johnson", 2000000);

        System.out.println("Presedinte executiv ->" + PresedinteExecutiv.get());
        System.out.println();

        Actor actor = new Actor("Brad", "Pitt", 250000, (byte) 125);
        Personaj personaj = new Personaj("Aldo", "Raine", (short) 30);

        ArrayList<String> recuzita = new ArrayList<String>(3);
        recuzita.add("dinamita");
        recuzita.add("role film");
        recuzita.add("covor rosu");

        Locatie locatie = new Locatie("cinematograj", recuzita);


        Angajat angajat = new Angajat("Quentin", "Tarantino", 70000);
        Angajat angajat1 = new Angajat("Jef", "Richard", 200);

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
        System.out.println();

        Actor actor1 = new Actor("Cristoph","Walter",120000, (byte) 90);


        System.out.println("Getter si setter pt clasa Actor");
        System.out.println(actor1.getPrenume()+" "+  actor1.getImportanta());
        actor1.setPrenume("Waltz");
        actor1.setImportanta((byte)120);
        System.out.println(actor1.getPrenume()+" "+  actor1.getImportanta());
        System.out.println();


        film.addDistributie(actor1,new Personaj("Col Hans","Landa",(short) 52));

        Incasari incasari = new Incasari(316915264	,2000,500000,27800);
        film.setIncasari(incasari);


        System.out.println("Modificatori incasari si cum afecteaza si profitul");
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


        System.out.println("Recuzita de la locatia 0 (getter)");
        System.out.println(film.getLocatie(0).getRecuzita());
        System.out.println();



        ArrayList<Angajat>angajati = film.getEchipa();

        System.out.println("Angajati in ordine alfabetica:");

        Collections.sort(angajati, new AlfabeticComparePersoana());
        for (Angajat ang:angajati){
            System.out.println(ang);
        }

        System.out.println("\nAngajati in ordine alfabetica:");

        Collections.sort(angajati, new SalariuCompare().reversed());
        for (Angajat ang:angajati){
            System.out.println(ang);
        }



        Actor actor2 = new Actor("Melanie", "Laurent", 65000, (byte) 70);
        film.addDistributie(actor2, new Personaj("Shosanna", (short) 22));

        film.addDistributie(new Actor("Michael","Fassbender",70000,(byte)50), new Personaj("Archie", "Hicox"));

        film.addDistributie(new Actor("Eli", "Roth", 80000,(byte)80), new Personaj("Donny","Donowitz", (short) 25));


        ArrayList<Actor> actori = film.getActori();

        Collections.sort(actori, new ImportantaCompare().reversed());

        System.out.println("\nActori in ordinea importantei");
        for (Actor act:actori){
            System.out.println(act);
        }
        System.out.println();

        System.out.println("Distributia filmului");
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

