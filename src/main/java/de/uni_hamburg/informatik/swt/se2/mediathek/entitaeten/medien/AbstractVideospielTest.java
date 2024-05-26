package de.uni_hamburg.informatik.swt.se2.mediathek.entitaeten.medien;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public abstract class AbstractVideospielTest extends AbstractMediumTest
{

    protected static final String SYSTEM = "System";
    protected AbstractVideospiel _videoSpiel;

    public AbstractVideospielTest()
    {
        _videoSpiel = getMedium();
    }

    @Test
    public void testeAbstractVideospiel()
    {
        assertEquals(SYSTEM, _videoSpiel.getSystem());
    }

    @Test
    public final void testAbstractVideospielSetter()
    {
        _videoSpiel.setSystem("System2");
        assertEquals("System2", _videoSpiel.getSystem());
    }

    @Override
    protected abstract AbstractVideospiel getMedium();

}
