package tests.co.mesquita.linketinder.crud

import static co.mesquita.linketinder.crud.CreatePessoa.createPessoa
import static org.junit.jupiter.api.Assertions.*

import co.mesquita.linketinder.entity.Pessoa
import co.mesquita.linketinder.entity.Candidato
import co.mesquita.linketinder.entity.Empresa
import org.junit.jupiter.api.Test

class testCreatePessoa {
    @Test
    void testCreatePF() {
        Pessoa pf = new Candidato("Joao", "joao@worker.com", "123.456.789-01", 23, "Goias", "74659-156", "Legal e extrovertido")
        Pessoa pessoa = createPessoa(1, "Joao", "joao@worker.com", "123.456.789-01", 23, "Goias", "74659-156", "Legal e extrovertido")
        assertEquals(pf, pessoa)
    }

    @Test
    void testCreatePJ() {
        Pessoa pj = new Empresa("Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        Pessoa pessoa = createPessoa(0, "Hiper Festa", "hiperfesta@employer.com", "12.345.678/0001-10", "Brasil", "São Paulo", "96325-452", "Rede de festa")
        assertEquals(pj, pessoa)
    }
}
