package creational.patterns.factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactoryInstrumentTest {

    @Test
    public void shouldReturnAcousticGuitar() throws InstantiationException, IllegalAccessException {

        Instrument instrument = FactoryInstrument.get(TypeInstrument.ACOUSTIC_GUITAR);
        assertEquals("Acoustic Guitar", instrument .getName());
    }

    @Test
    public void shouldReturnGuitar() throws InstantiationException, IllegalAccessException {

        Instrument instrument = FactoryInstrument.get(TypeInstrument.GUITAR);
        assertEquals("Guitar", instrument.getName());
    }

    @Test(expected =  IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInstrumentNotFound() throws InstantiationException, IllegalAccessException {

        FactoryInstrument.get(TypeInstrument.DRUMS);
    }

}
