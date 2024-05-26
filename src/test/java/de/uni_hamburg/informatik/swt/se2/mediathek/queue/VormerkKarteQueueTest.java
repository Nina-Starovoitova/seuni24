package de.uni_hamburg.informatik.swt.se2.mediathek.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VormerkKarteQueueTest {
    @Test
    void testEnQueue() {
        VormerkKarteQueue vormerkKarteQueue1 = VormerkKarteQueue.getInstance ();
        VormerkKarteQueue vormerkKarteQueue2 = VormerkKarteQueue.getInstance ();
        assertSame(vormerkKarteQueue1,vormerkKarteQueue2);
        assertNotNull(vormerkKarteQueue1);
        vormerkKarteQueue1.enqueue(_medium)
    }
    @Test
    void testDeQueue() {
    }

}