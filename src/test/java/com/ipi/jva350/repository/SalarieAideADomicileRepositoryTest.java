package com.ipi.jva350.repository;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SalarieAideADomicileRepositoryTest {
    @Autowired
    private SalarieAideADomicileRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testPartCongesPrisTotauxAnneeNMoins1() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        double salarieCPPrisNMoins1 = 12.0;
        double salarieCCPAcquisNMoins1 = 20.0;
        salarie.setCongesPayesPrisAnneeNMoins1(salarieCPPrisNMoins1);
        salarie.setCongesPayesAcquisAnneeNMoins1(salarieCCPAcquisNMoins1);
        entityManager.persist(salarie);
        entityManager.flush();
        double resultatAttendu = salarieCPPrisNMoins1/salarieCCPAcquisNMoins1;
        // When
        Double resultat = repository.partCongesPrisTotauxAnneeNMoins1();
        // Then
        Assertions.assertEquals(resultatAttendu, resultat);
        assertNotNull(resultat);
    }
}
