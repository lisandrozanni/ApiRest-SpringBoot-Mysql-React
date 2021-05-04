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

import coop.tecso.examen.enums.TipoMovimiento;
import coop.tecso.examen.model.Movimiento;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovimientoRepositoryTest {

    @Autowired
    private MovimientoRepository movimientoRepository;
    
    @Before
    public void setUp() {
    	Movimiento mov = new Movimiento();
    	mov.setDescripcion("THIS_TETS");
    	mov.setImporte(new BigDecimal("23.56"));
    	mov.setTipoMovimiento(TipoMovimiento.DEBITO);
    	movimientoRepository.save(mov);
    }
        
    @Test
    public void findAllMustReturnAllMovim() {
    	List<Movimiento> result = movimientoRepository.findAll();
    	assertEquals(1, result.size());
    }
    
}
