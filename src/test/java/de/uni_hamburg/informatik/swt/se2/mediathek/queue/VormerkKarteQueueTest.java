package de.uni_hamburg.informatik.swt.se2.mediathek.queue;

import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.DVD;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.PCVideospiel;
import de.uni_hamburg.informatik.swt.se2.mediathek.wertobjekte.Kundennummer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class VormerkKarteQueueTest {
    @Mock
    private Kundennummer kundennummer1;
    @Mock
    private Kundennummer kundennummer2;
    @Mock
    private Kundennummer kundennummer3;

    private Kunde kunde1;
    private Kunde kunde2;
    private Kunde kunde3;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.kunde1 = new Kunde(kundennummer1, "Vorname1", "Nachname1");
        this.kunde2 = new Kunde(kundennummer2, "Vorname2", "Nachname2");
        this.kunde3 = new Kunde(kundennummer3, "Vorname3", "Nachname3");
    }

    @Test
    void testEnQueue() {
        // check if it is a Singletone


        //Test enQueued no more than 3
        CD cd = new CD("titel", "kommentar", "interpret", 30);
        VormerkKarte vormerkKarteQueue1 = new VormerkKarte(cd);
        assertEquals(vormerkKarteQueue1.getVormerker().size(), 0);
        vormerkKarteQueue1.merkeVor(kunde1);
        vormerkKarteQueue1.merkeVor(kunde2);
        vormerkKarteQueue1.merkeVor(kunde3);
        assertEquals(vormerkKarteQueue1.getVormerker().size(), 3);
        vormerkKarteQueue1.merkeVor(kunde1);
        assertEquals(vormerkKarteQueue1.getVormerker().size(), 3);

//TODO, remove the first client

        DVD dvd = new DVD("titel", "kommentare", "regisseur", 20);
        VormerkKarte vormerkKarteQueue2 = new VormerkKarte(dvd);
        vormerkKarteQueue1.merkeVor(kunde1);
        vormerkKarteQueue1.merkeVor(kunde2);
        vormerkKarteQueue1.merkeVor(kunde3);
        assertEquals(vormerkKarteQueue1.getVormerker().size(), 3);

    }

    @Test
    void testLoescheVormerker() {
        CD cd = new CD("titel", "kommentar", "interptet", 30);
        VormerkKarte vormerkKarteQueue1 = new VormerkKarte(cd);
        assertEquals(vormerkKarteQueue1.getVormerker().size(), 0);
        vormerkKarteQueue1.merkeVor(kunde1);
        vormerkKarteQueue1.merkeVor(kunde2);
        vormerkKarteQueue1.merkeVor(kunde3);
        vormerkKarteQueue1.loescheVormerker();
        assertEquals(2, vormerkKarteQueue1.getVormerker().size());

    }

    @Test
    void testIstVormerkeMoeglich() {
        CD cd = new CD("titel", "kommentar", "interptet", 30);
        VormerkKarte vormerkKarteQueue1 = new VormerkKarte(cd);
        assertEquals(vormerkKarteQueue1.getVormerker().size(), 0);
        assertTrue(vormerkKarteQueue1.istVormerkeMoeglich());
        vormerkKarteQueue1.merkeVor(kunde1);
        vormerkKarteQueue1.merkeVor(kunde2);
        vormerkKarteQueue1.merkeVor(kunde3);
        assertFalse(vormerkKarteQueue1.istVormerkeMoeglich());
    }


}