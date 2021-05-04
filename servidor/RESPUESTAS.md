## Comando para ejecutar la aplicacion base utilizando Maven:
	mvn spring-boot:run


## Crear un titular fisico:
	curl -X POST "http://localhost:8080/api/titular/crear-titular"
	-H "Content-Type:application/json" -H "Accept:application/json"
	-d "{
   	     \"nombre\": \"nombre1\",
   	     \"apellido\": \"apellido2\",
  	      \"rut\": \"223132\",
		\"cuentaCorriente\": \"9541234\",
 	       \"caracteristica\": \"tipo de titular\",
		\"razon\": \"razon social\",
 	       \"anio\": \"2021\"
	}"


## Obtener todos los titulares:
	curl -X GET "http://localhost:8080/api/titular/todos"


## Obtener cuenta por id:
	curl -X GET "http://localhost:8080/api/titular/buscar-titular/1"


## Editar cuenta:
	curl -X PUT "http://localhost:8080/api/titular/editar-titular/1"
	-H "Content-Type:application/json" -H "Accept:application/json"
	-d "{
		\"nombre\": \"nombre2\",
      	  \"apellido\": \"apellido3\",
     	   \"cuentaCorriente\": \"9541234\",
		\"rut\": \"223132\",
    	    \"razon\": \"crear\",
		\"anio\": \"2022\",
        	\"caracteristica\": \"juridica\"
	}"


## Eliminar titular:
	curl -X DELETE "http://localhost:8080/api/titular/eliminar-titular/1"



## Crear cuenta Corriente:
	curl -X POST "http://localhost:8080/api/cuenta/crear"
	-H "Content-Type:application/json" -H "Accept:application/json"
	-d "{
        	\"numeroCuenta\": \"123456\",
	        \"moneda\": \"peso\",
        	\"saldo\": "200"
	}"


## Visualizar cuenta Corriente:
	curl -X GET "http://localhost:8080/api/cuenta/visualizar"


## Agregar movimiento:
	curl -X POST "http://localhost:8080/api/movimiento/agregar"
	-H "Content-Type:application/json" -H "Accept:application/json"
	-d "{
   	     \"numeroCuenta\": \"123456\",
   	     \"tipoMovimiento\": \"debito\",
   	     \"descripcion\": \"transferencia\",
   	     \"importe\": "10"
	}"

## Obtener todos los movimientos:
	curl -X GET "http://localhost:8080/api/movimiento/lista"