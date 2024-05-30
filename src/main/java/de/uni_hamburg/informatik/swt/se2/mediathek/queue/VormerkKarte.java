package de.uni_hamburg.informatik.swt.se2.mediathek.queue;


import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.DVD;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien.PCVideospiel;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class VormerkKarte {

    private int queueLength = 3;
    private Queue<Kunde> _vormerker;
    private final Medium _medium;

    public VormerkKarte(Medium medium) {
        _vormerker = new LinkedList<>();
        _medium = medium;

    }

    public Queue<Kunde> getVormerker() {
        return _vormerker;
    }

    public void merkeVor(Kunde kunde) {

        if (istVormerkeMoeglich()) {
            _vormerker.add(kunde);
        }
    }

    public Medium getMedium() {
        return _medium;
    }

    public boolean istVormerkeMoeglich() {
        return _vormerker.size() < queueLength;
    }

    public void loescheVormerker() {
        if (!isEmpty())
            _vormerker.poll();
    }

    public boolean isEmpty() {
        return _vormerker == null;
    }



}
