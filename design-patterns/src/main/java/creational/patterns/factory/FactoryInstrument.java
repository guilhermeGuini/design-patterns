package creational.patterns.factory;

import java.util.EnumMap;
import java.util.Map;

public class FactoryInstrument {

    private static Map<TypeInstrument, Class<? extends Instrument>> mapInstruments = new EnumMap<>(TypeInstrument.class);
    static {
        mapInstruments.put(TypeInstrument.ACOUSTIC_GUITAR, AcousticGuitar.class);
        mapInstruments.put(TypeInstrument.GUITAR, Guitar.class);
        mapInstruments.put(TypeInstrument.BASS, Bass.class);
    }

    public static Instrument get(TypeInstrument typeInstrument) throws IllegalAccessException, InstantiationException {

        Class<? extends Instrument> clazz = mapInstruments.get(typeInstrument);

        if (clazz == null) {
            throw new IllegalArgumentException("Type instrument [" + typeInstrument + "] can't found.");
        } else {
            return clazz.newInstance();
        }
    }
}
