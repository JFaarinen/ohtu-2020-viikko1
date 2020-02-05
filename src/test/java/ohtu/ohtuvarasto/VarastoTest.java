package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto, varasto2, varasto3, varasto4, varasto5;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(-1);
        varasto3 = new Varasto(10, 5);
        varasto4 = new Varasto(-2, 5);
        varasto5 = new Varasto(10, -3);
        
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void kuormitettuKonstruktoriLuoVarastonJossaTavaraa() {
        assertEquals(10, varasto3.getTilavuus(), vertailuTarkkuus);
        assertEquals(5, varasto3.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void kuormitettuKonstruktoriEiLuoVirheellistaVarastoa() {
        //Varaston koko ei voi olla negatiivinen
        assertEquals(-1, varasto4.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test 
    public void uudellaVarastollaEpakelpoTilavuus() {       
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysEiVoiOllaNegatiivinen() {
        varasto.lisaaVarastoon(-8);
        //Saldon pitäisi olla edelleen 0
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonTilaaEiSaaYlittaa() {
        double lisays = 10 + (varasto.getTilavuus());
        varasto.lisaaVarastoon(lisays);
        
        //varaston saldo ei voi ylittää varaston vapaata tilaa
        assertEquals(varasto.getSaldo(), varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaNegatiivistaMaaraa() {
        varasto.lisaaVarastoon(1);
        varasto.otaVarastosta(-1);
        
        //varastossa tulisi olla edelleen sinne lisätty määrä
        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaEnempaaKuinVarastoituna() {
        varasto.lisaaVarastoon(5);
        double otettu = varasto.otaVarastosta(10);
        
        //varaston pitäisi olla tyjä, palautettua kamaa 5.0
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(5, otettu, vertailuTarkkuus);
    }
    
    @Test
    public void merkkijononTulostusOikein() {
        double lisays = 5.0;
        varasto.lisaaVarastoon(lisays);
        
        assertEquals("saldo = 5.0, vielä tilaa 5.0", varasto.toString());
    }

}