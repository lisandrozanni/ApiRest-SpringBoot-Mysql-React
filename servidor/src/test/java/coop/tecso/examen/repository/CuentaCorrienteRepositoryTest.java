package coop.tecso.examen.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import coop.tecso.examen.enums.Moneda;
import coop.tecso.examen.model.CuentaCorriente;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CuentaCorrienteRepositoryTest {
	
    @Autowired
    private CuentaCorrienteRepository cuentaCorrienteRepository;
    
    @Before
    public void setUp() {
    	CuentaCorriente cc = new CuentaCorriente();
    	cc.setMoneda(Moneda.DOLAR);
    	cc.setNumeroCuenta(236785L);
    	cc.setSaldo(new BigDecimal("45.78"));
    	cc.setMovimientos(null);    	
    	cuentaCorrienteRepository.save(cc);
    }
        
    @Test
    public void findAllMustReturnAllCounts() {
    	List<CuentaCorriente> result = cuentaCorrienteRepository.findAll();
    	assertEquals(1, result.size());
    }
}
