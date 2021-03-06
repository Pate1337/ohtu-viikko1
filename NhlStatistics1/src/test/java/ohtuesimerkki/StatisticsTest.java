/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paavo
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
//    public StatisticsTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void palauttaaJoukkueenPelaajat() {
        List<Player> lista = stats.team("PIT");
        assertEquals("Lemieux", lista.get(0).getName());
    }
    
    @Test
    public void hakuToimiiOikeallaSyötteellä() {
        Player pelaaja = stats.search("Kurri");
        assertEquals("Kurri", pelaaja.getName());
    }
    
    @Test
    public void hakuToimiiVäärälläSyötteellä() {
        Player pelaaja = stats.search("Koira");
        assertEquals(null, pelaaja);
    }
    
    @Test
    public void palauttaaParhaatPisteidentekijät() {
        List<Player> lista = stats.topScorers(1);
        assertEquals("Gretzky", lista.get(0).getName());
    }
    
//    @After
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
