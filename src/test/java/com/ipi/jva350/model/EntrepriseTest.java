package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntrepriseTest {
    @ParameterizedTest(name="{1}")
    @CsvSource({
            "'2024-02-22','2024-02-20','2024-02-23',true",
            "'2024-02-19','2024-02-20','2024-02-23',false",
            "'2024-02-20','2024-02-20','2024-02-23',true",
            "'2024-02-23','2024-02-20','2024-02-23',true",
    })
    public void testEstDansPlage(String d,String dateDebut, String dateFin, Boolean expected) {
        // Given
        LocalDate dParse = LocalDate.parse(d);
        LocalDate dateDebutParse = LocalDate.parse(dateDebut);
        LocalDate dateFinParse = LocalDate.parse(dateFin);

        // When
        Boolean estDansPlage = Entreprise.estDansPlage(dParse,dateDebutParse,dateFinParse);

        //Then
        Assertions.assertEquals(expected, estDansPlage);
    }


    @ParameterizedTest(name= "La ponderation que l'on veut voir est {2}")
    @CsvSource({
            "'2022-01-24',0.7333333333333333", // Cas 1
            "'2022-07-23',0.23333333333333334",
            "'2022-10-23',0.5333333333333333",
    })
    public void testproportionPondereeDuMois(String moisDuConge, double expected){
        // Given
        LocalDate moisDucongeParse = LocalDate.parse(moisDuConge);
        // When
        double proportionPondereeDuMois = Entreprise.proportionPondereeDuMois(moisDucongeParse);
        // Then
        Assertions.assertEquals(expected, proportionPondereeDuMois);

    }






    @ParameterizedTest(name= "La date que l'on veut voir est {1}")
    @CsvSource({
        "'2022-06-24','2022-06-01'",
        "'2022-05-22','2021-06-01'", // mois numero 5 est aux bornes
        "'2022-04-23','2021-06-01'"
    })
    public void testGetPremierJourAnneeDeConges(String dateChoisie, String expected){
        Entreprise entreprise = new Entreprise(); //Modification Entreprise.java : Private Entreprise en public entreprise
        // Given
        LocalDate dateChoisieParse = LocalDate.parse(dateChoisie);
        LocalDate expectedParse = LocalDate.parse(expected);
        // When
        LocalDate PremierJourAnneeDeConges = entreprise.getPremierJourAnneeDeConges(dateChoisieParse);
        // Then
        Assertions.assertEquals(expectedParse,PremierJourAnneeDeConges);
        // Une erreur dans le code de la class Entreprise.Java a été corrigée :
        // d.getMonthValue() > 5 ? LocalDate.of(d.getMonthValue(), 6, 1) devient :
        //d.getMonthValue() > 5 ? LocalDate.of(d.getYear), 6, 1)
    }
}
