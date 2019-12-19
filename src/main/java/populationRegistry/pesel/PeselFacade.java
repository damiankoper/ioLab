package populationRegistry.pesel;

import java.util.ArrayList;

import populationRegistry.registryApplication.services.IPeselFacade;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * PeselFacade
 */
public class PeselFacade implements IPeselFacade {
    private boolean isChecksumValid(String pesel) {
        String integers[] = pesel.split("");
        if (integers.length != 11) {
            return false;
        }
        ArrayList<Integer> values = new ArrayList<>();
        for (String string : integers) {
            values.add(Integer.parseInt(string));
        }
        int[] m = { 1, 3, 7, 9 };
        int sum = 0;
        for (int i = 0; i < values.size() - 1; i++) {
            sum += m[i % 4] * values.get(i);
        }
        sum += values.get(values.size() - 1);
        sum %= 10;

        return sum == 0;
    }

    private boolean isDataValid(RegistryApplicationDTO dto) {
        /**
         * Validation hidden behind facade. Connection to PESEL system.
         */
        return true;
    }

    public boolean isValid(RegistryApplicationDTO dto) {
        if (!isChecksumValid(dto.pesel))
            return false;
        return isDataValid(dto);
    }

}