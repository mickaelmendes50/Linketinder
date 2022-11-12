package test.co.mesquita.linketinder.entity;

import co.mesquita.linketinder.entity.Candidato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidatoTest {
    @Test
    void testGetName() {
        Candidato candidato = new Candidato("João", "Pedro", "joao@worker.com", "jo123", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido");
        assertEquals("João", candidato.getName());
    }

    @Test
    void testGetEmail() {
        Candidato candidato = new Candidato("João", "Pedro", "joao@worker.com", "jo123", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido");
        assertEquals("joao@worker.com", candidato.getEmail());
    }

    @Test
    void testGetId() {
        Candidato candidato = new Candidato("1", "João", "Pedro", "joao@worker.com", "jo123", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido");
        assertEquals("1", candidato.getId());
    }

    @Test
    void testGetAge() {
        Candidato candidato = new Candidato("João", "Pedro", "joao@worker.com", "jo123", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido");
        assertEquals("23", candidato.getAge());
    }

    @Test
    void testGetCep() {
        Candidato candidato = new Candidato("João", "Pedro", "joao@worker.com", "jo123", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido");
        assertEquals("74659-156", candidato.getCep());
    }

    @Test
    void testGetDescription() {
        Candidato candidato = new Candidato("João", "Pedro", "joao@worker.com", "jo123", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido");
        assertEquals("Legal e extrovertido", candidato.getDescription());
    }
}