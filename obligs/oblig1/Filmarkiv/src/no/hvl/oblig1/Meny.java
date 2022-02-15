package no.hvl.oblig1;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    
    public void start(){
     // legg inn en del forhåndsdefinerte filmer
        String[] filmtitler = {"Intruder Of Eternity",
            "Creature Of Exploration",
            "Angel On My Ship",
            "Medic Of The Moon",
            "Man In The Future",
            "Volunteer In The Portal",
            "Androids Of The Universe",
            "Girls Of The Moon",
            "Guests Of Darkness",
            "Directors",
            "Martians Of Our Culture",
            "Armies From Outer Space",
            "Clones And Hunters",
            "Figures And Creators",
            "Leaders And Strangers",
            "Rebels And Commanders",
            "Volunteers And Androids",
            "Armies And Aliens",
            "Border Of The Past",
            "Battle Of The Outlands",
            "Extinction From Outer Space",
            "Statues Of The Dead",
            "Statue Of The Worlds",
            "Inception Of Time",
            "Basic The Titans",
            "Secrets Of The Robotic Police",
            "Life After Time Travellers",
            "Puzzle Of The Truth",
            "Fixed In Orbit",
            "Basic Moon Rocks",
            "Bored By The Truth",
            "Devoted To Droids"
        };
        String[] filmselskap = {
            "Universal",
            "Svensk Film",
            "21th Fox",
            "Disney"
        };
        String[] produsenter = {
            "J. J Abrams",
            "Mel Gibson",
            "Don Simpson",
            "Quentin Tarantino"
        };
        int nr = 0;
        for(String f : filmtitler){
            Sjanger sjanger = Sjanger.values()[nr % Sjanger.values().length];
            Film nyfilm = new Film(nr++, produsenter[nr % produsenter.length], f, (1970 + nr), sjanger, filmselskap[nr % produsenter.length]);
            filmarkiv.leggTilFilm(nyfilm);
        }

        menyloop();
    }

    public void menyloop(){
        System.out.print("Filmarkiv CLI\n======================\n1. Legg til ny film\n2. Vis en film i arkivet\n3. Søk etter en film med en delstring\n4. Søk etter filmer med produsent\n5. Skriv ut statistikk for hele arkivet\nCtrl+c for å avslutte");
        while(true){
            switch(tekstgr.lesInput("Valg (1-5): ")){
                case 1: 
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    break;
                case 2:
                    Film[] filmer = filmarkiv.soekTittel(tekstgr.lesInputString());
                    if(filmer.length > 0){
                        tekstgr.visFilm(filmer[0]);
                    }
                    break;
                case 3:
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tekstgr.lesInputString());
                    break;
                case 4:
                    tekstgr.skrivUtFilmProdusent(filmarkiv, tekstgr.lesInputString());
                    break;
                case 5:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                default:
                    System.out.print("Filmarkiv CLI\n======================\n1. Legg til ny film\n2. Vis en film i arkivet\n3. Søk etter en film med en delstring\n4. Søk etter filmer med produsent\n5. Skriv ut statistikk for hele arkivet\nCtrl+c for å avslutte");
                    break;
            }
        }
    }
}