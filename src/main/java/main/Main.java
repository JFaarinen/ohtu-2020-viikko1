package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);
        kaynnista(mehua, olutta);

    }
    
    public static void kaynnista(Varasto mehua, Varasto olutta) {
        tulostaTiedot(mehua, olutta);
        testaaGetterit("Olut", olutta);
        testaaSetterit("Mehu", mehua);
        testaaVirhetilanteita();
        testaaLisays("Olut", olutta, 1000.0);
        testaaLisays("Mehu", mehua, -666.0);
        testaaOtto("Olut", olutta, 1000);
        testaaOtto("Mehu", mehua, -32.9);
    }
    
    private static void testaaVirhetilanteita() {
        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);
        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(100.0, -50.7);
        System.out.println(huono);
    }
    
    private static void tulostaTiedot(Varasto mehua, Varasto olutta) {
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
    }
    
    private static void testaaGetterit(String otsikko, Varasto v) {
        System.out.println(otsikko+ "getterit:");
        System.out.println("getSaldo()     = " + v.getSaldo());
        System.out.println("getTilavuus    = " + v.getTilavuus());
        System.out.println("paljonkoMahtuu = " + v.paljonkoMahtuu());
    }
    
    private static void testaaSetterit(String otsikko, Varasto v) {        
        System.out.println(otsikko +"setterit:");
        System.out.println("Lisätään 50.7");
        v.lisaaVarastoon(50.7);
        System.out.println(otsikko +"varasto: " + v);
        System.out.println("Otetaan 3.14");
        v.otaVarastosta(3.14);
        System.out.println(otsikko +"varasto: " + v);
    }
    
    private static void testaaLisays(String otsikko, Varasto v, double maara) {
        System.out.println(otsikko +"varasto: " + v);
        System.out.println("lisaaVarastoon(" +maara+ ")");
        v.lisaaVarastoon(maara);
        System.out.println(otsikko +"varasto: " + v);
    }
    
    private static void testaaOtto(String otsikko, Varasto v, double maara) {
        System.out.println(otsikko +"varasto: " + v);
        System.out.println("otaVarastosta("+maara+")");
        double saatiin = v.otaVarastosta(maara);
        System.out.println("saatiin " + saatiin);
        System.out.println(otsikko +"varasto: " + v);
    }
}
