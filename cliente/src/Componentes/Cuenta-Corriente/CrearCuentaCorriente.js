import React, { useState } from "react";
import axios from 'axios'
import { useHistory } from "react-router-dom";

const CrearCuentaCorriente = () => {
  let history = useHistory();
  const [crear, setCrear] = useState({
    numeroCuenta: "",
    moneda: "",  
    saldo: ""
  });

  const { numeroCuenta, moneda, saldo } = crear;

  const handleinputchange = e => {
    setCrear({ ...crear, [e.target.name]: e.target.value });
  };

  const handleSubmit = async e => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/cuenta/crear", crear);
    history.push("/cuenta-corriente");
  };

  return (
    <div className="container">
      <div className="w-75 mx-auto shadow p-5">
        <h2 className="text-center mb-4">Abrir cuenta corriente</h2> 
        <form onSubmit={handleSubmit}>
          <div className="form-group">
              <input
                type="number"
                className="form-control form-control-lg"
                placeholder="Ingrese numero de cuenta"
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
                placeholder="Ingrese tipo de moneda"
                name="moneda"
                value={moneda}
                onChange={handleinputchange}
              />
            </div>
            
          <div className="form-group">
              <input
                type="number"
                className="form-control form-control-lg"
                placeholder="ingrese el saldo inicial"
                required
                name="saldo"
                value={saldo}
                onChange={handleinputchange}
              />
            </div>
            
            <button className="btn btn-primary btn-block">Crear cuenta</button>

        </form>
      </div>
    </div>
  );
};

export default CrearCuentaCorriente;