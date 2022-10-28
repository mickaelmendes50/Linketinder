package test.co.mesquita.linketinder.entity;

import co.mesquita.linketinder.entity.Vaga;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VagaTest {

    @Test
    void getId() {
        Vaga vaga = new Vaga(1,2, "Analista", "TI", "Brasil");
        if (vaga.getId() == 1) assertTrue(true);
    }

    @Test
    void getIdEmpresa() {
        Vaga vaga = new Vaga(1, "Analista", "TI", "Brasil");
        if (vaga.getIdEmpresa() == 1) assertTrue(true);
    }

    @Test
    void getNome() {
        Vaga vaga = new Vaga(1, "Analista", "TI", "Brasil");
        assertEquals("Analista", vaga.getNome());
    }

    @Test
    void getDescricao() {
        Vaga vaga = new Vaga(1, "Analista", "TI", "Brasil");
        assertEquals("TI", vaga.getDescricao());
    }

    @Test
    void getLocal() {
        Vaga vaga = new Vaga(1, "Analista", "TI", "Brasil");
        assertEquals("Brasil", vaga.getLocal());
    }
}