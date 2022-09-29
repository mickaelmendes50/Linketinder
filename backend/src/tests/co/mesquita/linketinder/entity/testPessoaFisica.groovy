package tests.co.mesquita.linketinder.entity

import co.mesquita.linketinder.entity.Pessoa
import co.mesquita.linketinder.entity.PessoaFisica
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

class testPessoaFisica {
    @Test
    void testGetName() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getName().equals("João"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetEmail() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getEmail().equals("joao@worker.com"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetId() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getId().equals("123.456.789-01"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetAge() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getAge().equals("23"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetEstate() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getEstate().equals("Goiás"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetCep() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getCep().equals("74659-156"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetDescription() {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        if (pf.getDescription().equals("Legal e extrovertido"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testAddSkills () {
        Pessoa pf = new PessoaFisica("João", "joao@worker.com", "123.456.789-01", 23, "Goiás", "74659-156", "Legal e extrovertido")
        pf.addSkill("Java")
        pf.addSkill("JUnit")

        if (pf.getSkills().equals("Java, JUnit, "))
            assertTrue(true)
        else
            assertTrue(false)
    }
}
