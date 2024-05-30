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


class VormerkKarteQueue {

    public static final int QUEUELENGTH = 3;
    private Queue cdQueue;
    private Queue dvdQueue;
    private Queue videoSpielQueue;
    private static VormerkKarteQueue instance;

    private VormerkKarteQueue() {
        cdQueue = new LinkedList<>();
        dvdQueue = new LinkedList();
        videoSpielQueue = new LinkedList();
    }

    public synchronized static VormerkKarteQueue getInstance() {
        if (instance == null) {
            instance = new VormerkKarteQueue();
        }
        return instance;
    }

    public void enqueue(Kunde kunde, Medium medium) {
        if (medium instanceof CD) {
            addToQueue(cdQueue, kunde);
        } else if (medium instanceof DVD) {
            addToQueue(dvdQueue, kunde);
        } else if (medium instanceof PCVideospiel) {
            addToQueue(videoSpielQueue, kunde);
        }
    }

    private void addToQueue(Queue queue, Kunde kunde) {
        if (queue.size() < QUEUELENGTH) {
            queue.add(kunde);
        }

    }

    public int getQueuelength(Medium medium) {
        return this.cdQueue.size();
    }

    public void dequeue(Medium medium) {
        if (medium instanceof CD) {
            removeFromQueue(cdQueue);
        } else if (medium instanceof DVD) {
            removeFromQueue(dvdQueue);
        } else if (medium instanceof PCVideospiel) {
            removeFromQueue(videoSpielQueue);
        }
    }

    private void removeFromQueue(Queue queue) {
        if (!isEmpty(queue))
            queue.poll();
    }

    public boolean isEmpty(Queue queue) {
        return queue == null;
    }

    public void  listeKunden(Medium medium) {
        //List<Kunde> kundenliste

    }

}
