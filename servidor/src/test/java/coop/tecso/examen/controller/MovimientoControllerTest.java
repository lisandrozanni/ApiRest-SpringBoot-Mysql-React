package coop.tecso.examen.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.enums.TipoMovimiento;
import coop.tecso.examen.service.MovimientoService;

@RunWith(SpringRunner.class)
@WebMvcTest(MovimientoController.class)
public class MovimientoControllerTest {

	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private MovimientoController controller;
	    
    @MockBean
    private MovimientoService movimientoService;
    
    
    @Test
    public void findAllWithEmptyResult() throws Exception {
    	
    	when(movimientoService.movimientosOrdenados()).thenReturn(Collections.emptyList());
    	
    	String root = controller.getClass().getAnnotation(RequestMapping.class).value()[0];
        
    	mvc.perform(get(root +"/obtener-movimientos"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(0)))
    							.andReturn();	
    }
    
    @Test
    public void findAllWithOneResultElement() throws Exception {
   
    	MovimientoDto mov = new MovimientoDto();
    	mov.setDescripcion("THIS_TETS");
    	mov.setImporte(new BigDecimal("23.56"));
    	mov.setTipoMovimiento("CREDITO");
    	
    	when(movimientoService.movimientosOrdenados()).thenReturn(Arrays.asList(mov));
    	
    	String root = controller.getClass().getAnnotation(RequestMapping.class).value()[0];
        
    	mvc.perform(get(root +"/obtener-movimientos"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(1)))
    							.andExpect(jsonPath("$[0].tipoMovimiento", is(TipoMovimiento.CREDITO.toString())))
    							.andExpect(jsonPath("$[0].descripcion", is("THIS_TETS")))
    							.andExpect(jsonPath("$[0].importe", is(23.56)))
    							.andReturn();	
    }
    
    
}
