import React, { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";


  const AgregarMovimiento = () => {
    let history = useHistory();
    const [movimiento, setMovimiento] = useState({
      numeroCuenta: "",
      tipoMovimiento: "",  
      descripcion: "",
      importe: "",
    });
  
    const { numeroCuenta, tipoMovimiento, importe, descripcion } = movimiento;
    
    const handleinputchange = e => {
      setMovimiento({ ...movimiento, [e.target.name]: e.target.value });
    };
  
    const handleSubmit = async e => {
      e.preventDefault();
      await axios.post("http://localhost:8080/api/movimiento/agregar", movimiento);
      history.push("/cuenta-corriente");
    };

    return (
      <div className="container">
        <div className="w-75 mx-auto shadow p-5">
          <h2 className="text-center mb-4">Ingresar movimiento</h2> 
          <form onSubmit={handleSubmit}>
            <div className="form-group">
                <input
                  type="number"
                  className="form-control form-control-lg"
                  placeholder="Ingrese su numero de cuenta"
                  required
                  name="numeroCuenta"
                  value={numeroCuenta}
                  onChange={handleinputchange}
                />
              </div>  
  
              <div className="form-group">
                <input
                  type="text"
                  className="form-control form-control-lg"
                  placeholder="Ingrese tipo de movimiento"
                  name="tipoMovimiento"
                  value={tipoMovimiento}
                  onChange={handleinputchange}
                />
              </div>
              
            <div className="form-group">
                <input
                  type="text"
                  className="form-control form-control-lg"
                  placeholder="Motivo"
                  required
                  name="descripcion"
                  value={descripcion}
                  onChange={handleinputchange}
                />
              </div>

              <div className="form-group">
                <input
                  type="number"
                  className="form-control form-control-lg"
                  placeholder="ingrese el importe"
                  required
                  name="importe"
                  value={importe}
                  onChange={handleinputchange}
                />
              </div>
              
              <button className="btn btn-primary btn-block">Agregar movimiento</button>
  
          </form>
        </div>
      </div>
    );
  };

export default AgregarMovimiento;
