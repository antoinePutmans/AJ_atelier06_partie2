package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MoniteurTest {
    Stage stage;
    Sport sport;

    Moniteur moniteur;
    @BeforeEach
    void setUp() {
        stage = Mockito.mock(Stage.class);
        sport = Mockito.mock(Sport.class);
        moniteur = new MoniteurImpl("Antoine");
    }

    @Test
    void ajouterStage() {
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(1);

        assertTrue(moniteur.ajouterStage(stage));
        Mockito.verify(stage).enregistrerMoniteur(moniteur);
    }

    @Test
    void ajouterStage2() {
        ammenerALEtat(1,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(2);
        assertTrue(moniteur.ajouterStage(stage));
        assertEquals(2,moniteur.nombreDeStages());
        Mockito.verify(stage).enregistrerMoniteur(moniteur);
    }

    @Test
    void ajouterStage3() {
        ammenerALEtat(2,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(3);
        assertTrue(moniteur.ajouterStage(stage));

        assertEquals(3,moniteur.nombreDeStages());
        Mockito.verify(stage).enregistrerMoniteur(moniteur);
    }

    @Test
    void ajouterStage4() {
        ammenerALEtat(3,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(4);
        assertTrue(moniteur.ajouterStage(stage));

        assertEquals(4,moniteur.nombreDeStages());
        Mockito.verify(stage).enregistrerMoniteur(moniteur);
    }

    @Test
    void ajouterStage5() {
        ammenerALEtat(3,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(4);
        assertTrue(moniteur.ajouterStage(stage));
        assertFalse(moniteur.ajouterStage(stage));
        assertEquals(4,moniteur.nombreDeStages());
        Mockito.verify(stage).enregistrerMoniteur(moniteur);
    }

    @Test
    void ajouterStage6() {
        ammenerALEtat(4,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(3);
        assertFalse(moniteur.ajouterStage(stage));
        assertEquals(4,moniteur.nombreDeStages());
    }

    @Test
    void ajouterStage7() {
        Moniteur moniteur2 = new MoniteurImpl("Jean");
        ammenerALEtat(4,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur2)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(5);
        assertTrue(moniteur2.ajouterStage(stage));
        assertEquals(1,moniteur2.nombreDeStages());
        Mockito.when(stage.getMoniteur()).thenReturn(moniteur2);
        assertFalse(moniteur.ajouterStage(stage));
        assertEquals(4,moniteur.nombreDeStages());
    }

    @Test
    void ajouterStage8() {
        ammenerALEtat(4,moniteur);
        Mockito.when(stage.getSport()).thenReturn(sport);
        Mockito.when(stage.getMoniteur()).thenReturn(null);
        Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
        Mockito.when(stage.getNumeroDeSemaine()).thenReturn(3);
        assertFalse(moniteur.ajouterStage(stage));
        assertEquals(4,moniteur.nombreDeStages());
    }


    private void ammenerALEtat(int etat, Moniteur moniteur){
        for (int i = 0; i < etat ; i++) {
            Stage mock = Mockito.mock(Stage.class);
            Mockito.when(mock.getMoniteur()).thenReturn(null);
            Mockito.when(mock.getSport()).thenReturn(sport);
            Mockito.when(sport.contientMoniteur(moniteur)).thenReturn(true);
            Mockito.when(mock.getNumeroDeSemaine()).thenReturn(i+1);
            moniteur.ajouterStage(mock);
        }

    }
}