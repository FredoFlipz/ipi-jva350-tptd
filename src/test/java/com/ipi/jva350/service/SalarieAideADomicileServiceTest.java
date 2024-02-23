package com.ipi.jva350.service;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class SalarieAideADomicileServiceTest {
        /**
     * testCalculeLimiteEntrepriseCongesPermis Testée sans dépendance à la base de données
     */
    @Mock
    SalarieAideADomicileRepository salarieAideADomicileRepository;
    @InjectMocks
    SalarieAideADomicileService salarieAideADomicileService;
    @Test
    public void testCalculeLimiteEntrepriseCongesPermis() {
        // Given
        LocalDate moisEnCours = LocalDate.of(2024, 2, 22);
        double congesPayesAcquisAnneeNMoins1 = 10.0; // Exemple de valeur
        LocalDate moisDebutContrat = LocalDate.of(2023, 2, 22);
        LocalDate premierJourDeConge = LocalDate.of(2024, 2, 22);
        LocalDate dernierJourDeConge = LocalDate.of(2024, 3, 29);
        double CongesPrisTotauxAnneeNMoins1 = 3.0;
        when(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1()).thenReturn(CongesPrisTotauxAnneeNMoins1);
        // When
        long limiteConges = salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(
                moisEnCours,
                congesPayesAcquisAnneeNMoins1,
                moisDebutContrat,
                premierJourDeConge,
                dernierJourDeConge);
        // Then
       Assertions.assertEquals(3, limiteConges);
    }

    /**
     * testCalculeLimiteEntrepriseCongesPermi en test d'intégration
     */
    @Test
    public void testCalculeLimiteEntrepriseCongesPermis2() {
        // Given
        LocalDate moisEnCours = LocalDate.of(2024, 2, 22);
        double congesPayesAcquisAnneeNMoins1 = 20.0;
        LocalDate moisDebutContrat = LocalDate.of(2023, 1, 1);
        LocalDate premierJourDeConge = LocalDate.of(2024, 2, 10);
        LocalDate dernierJourDeConge = LocalDate.of(2024, 2, 20);
        // When
        long limiteConges = salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(
                moisEnCours,
                congesPayesAcquisAnneeNMoins1,
                moisDebutContrat,
                premierJourDeConge,
                dernierJourDeConge
        );
        // Then
        Assertions.assertEquals(16, limiteConges);
    }
}



