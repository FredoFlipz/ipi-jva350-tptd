package com.ipi.jva350.service;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.LinkedHashSet;


public class SalarieAideADomicileServiceTest {
   @Test
    public void testAjouteCongesTrue(){
      SalarieAideADomicileService salarieAideADomicileService = new SalarieAideADomicileService();
        //Given
        SalarieAideADomicile salarieAideADomicile = new SalarieAideADomicile(
                "Jean Dupont",  // Nom du salarié
                LocalDate.of(2023, 6, 15),  // Mois de début de contrat
                LocalDate.now(),  // Mois en cours
                180,  // Jours travaillés en année N
                15,   // Congés payés acquis en année N
                170,  // Jours travaillés en année N-1
                12,   // Congés payés acquis en année N-1
                10    // Congés payés pris en année N-1
        );
       // Boolean SalarieAutoriseAAvoirDesJoursDeConge = salarieAideADomicile.aLegalementDroitADesCongesPayes();

        LocalDate jourDebut = LocalDate.of(2024,05,4);
        LocalDate jourFin = LocalDate.of(2024,05,17);

      /*Mockito.when(salarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage(jourDebut,jourFin)).thenReturn(jourFin);

        //When

        salarieAideADomicileService.ajouteConge(salarieAideADomicile,jourDebut,jourFin);
        //Then
        Assertions.assertEquals();*/


    }
}
