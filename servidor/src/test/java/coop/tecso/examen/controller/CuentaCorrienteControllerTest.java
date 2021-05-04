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

import coop.tecso.examen.enums.Moneda;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.service.CuentaService;

@RunWith(SpringRunner.class)
@WebMvcTest(CuentaCorrienteController.class)
public class CuentaCorrienteControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private CuentaCorrienteController controller;
	    
    @MockBean
	private CuentaService cuentaService;
    
    @Test
    public void findAllWithEmptyResult() throws Exception {
    	
    	when(cuentaService.obtenerCuentasCorrientes()).thenReturn(Collections.emptyList());
    	
    	String root = controller.getClass().getAnnotation(RequestMapping.class).value()[0];
        
    	mvc.perform(get(root +"/obtener-cuentas"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(0)))
    							.andReturn();	
    }
    
    @Test
    public void findAllWithOneResultElement() throws Exception {
    	
    	CuentaCorriente cc = new CuentaCorriente();
    	cc.setMoneda(Moneda.DOLAR);
    	cc.setNumeroCuenta(236785L);
    	cc.setSaldo(new BigDecimal("45.78"));
    	cc.setMovimientos(null);    
    	
    	when(cuentaService.obtenerCuentasCorrientes()).thenReturn(Arrays.asList(cc));
    	
    	String root = controller.getClass().getAnnotation(RequestMapping.class).value()[0];
        
    	mvc.perform(get(root +"/obtener-cuentas"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(1)))
    							.andExpect(jsonPath("$[0].moneda", is(Moneda.DOLAR.toString())))
    							.andExpect(jsonPath("$[0].numeroCuenta", is(236785)))
    							.andExpect(jsonPath("$[0].saldo", is(45.78)))
    							.andReturn();	
    }

}
