package test.co.mesquita.linketinder.entity;

import co.mesquita.linketinder.entity.Competencia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetenciaTest {

    @Test
    void getId() {
        Competencia competencia = new Competencia(1,"Java");
        if (competencia.getId() == 1) assertTrue(true);
    }

    @Test
    void getNome() {
        Competencia competencia = new Competencia("Java");
        assertEquals("Java", competencia.getNome());
    }
}