package de.uni_hamburg.informatik.swt.se2.mediathek.queue;


import java.util.LinkedList;
import java.util.Queue;

    class VormerkKarteQueue {
    private  Queue  cdQueue;
    private Queue dvdQueue;
    private Queue  videoSpielQueue;
    private static VormerkKarteQueue instance;

    private VormerkKarteQueue(){
         cdQueue = new LinkedList();
         dvdQueue = new LinkedList();
         videoSpielQueue = new LinkedList();



    }

    public synchronized static VormerkKarteQueue getInstance() {
    if (instance == null){
        instance = new VormerkKarteQueue();
    }
        return instance;
    }
}
