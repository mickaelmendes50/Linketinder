package test.co.mesquita.linketinder.entity;

import co.mesquita.linketinder.model.entity.Empresa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void testGetName() {
        Empresa empresa = new Empresa("Hiper Festa", "hiperfesta@employer.com", "hf123", "12.345.678/0001-10", "Brasil", "96325-452", "Rede de festa");
        assertEquals("Hiper Festa", empresa.getName());
    }

    @Test
    void testGetEmail() {
        Empresa empresa = new Empresa("Hiper Festa", "hiperfesta@employer.com", "hf123", "12.345.678/0001-10", "Brasil", "96325-452", "Rede de festa");
        assertEquals("hiperfesta@employer.com", empresa.getEmail());
    }

    @Test
    void testGetId() {
        Empresa empresa = new Empresa("1", "Hiper Festa", "hiperfesta@employer.com", "hf123", "12.345.678/0001-10", "Brasil", "96325-452", "Rede de festa");
        assertEquals("1", empresa.getId());
    }

    @Test
    void testGetCounty() {
        Empresa empresa = new Empresa("Hiper Festa", "hiperfesta@employer.com", "hf123", "12.345.678/0001-10", "Brasil", "96325-452", "Rede de festa");
        assertEquals("Brasil", empresa.getCountry());
    }

    @Test
    void testGetCep() {
        Empresa empresa = new Empresa("Hiper Festa", "hiperfesta@employer.com", "hf123", "12.345.678/0001-10", "Brasil", "96325-452", "Rede de festa");
        assertEquals("96325-452", empresa.getCep());
    }

    @Test
    void testGetDescription() {
        Empresa empresa = new Empresa("Hiper Festa", "hiperfesta@employer.com", "hf123", "12.345.678/0001-10", "Brasil", "96325-452", "Rede de festa");
        assertEquals("Rede de festa", empresa.getDescription());
    }
}