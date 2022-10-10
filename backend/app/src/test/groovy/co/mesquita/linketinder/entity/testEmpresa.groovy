package tests.co.mesquita.linketinder.entity

import co.mesquita.linketinder.entity.Pessoa
import co.mesquita.linketinder.entity.Empresa
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertTrue

class testEmpresa {
    @Test
    void testGetName() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getName().equals("Hiper Festa"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetEmail() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getEmail().equals("hiperfesta@employer.com"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetId() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getId().equals("12.345.678/0001-10"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetCounty() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getCountry().equals("Brasil"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetEstate() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getEstate().equals("São Paulo"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetCep() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getCep().equals("96325-452"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testGetDescription() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        if (pj.getDescription().equals("Rede de festa"))
            assertTrue(true)
        else
            assertTrue(false)
    }

    @Test
    void testAddSkills () {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        pj.addSkill("Liderança")
        pj.addSkill("Experiencia")

        if (pj.getSkills().equals("Liderança, Experiencia, "))
            assertTrue(true)
        else
            assertTrue(false)
    }
}
