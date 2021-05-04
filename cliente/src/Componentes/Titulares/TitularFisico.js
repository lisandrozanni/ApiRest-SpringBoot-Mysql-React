import React, { useState } from "react";
import axios from 'axios'
import { useHistory } from "react-router-dom";

const TitularFisico = () => {
  let history = useHistory();
  const [fisico, setFisico] = useState({
    nombre: "",
    apellido: "",
    cuentaCorriente: "",  
    rut: "",
    razon: "-",
    anio: " -",
    caracteristica: "Persona física",
  });

  const { nombre, cuentaCorriente, rut, apellido } = fisico;
  
  const onInputChange = e => {
    setFisico({ ...fisico, [e.target.name]: e.target.value });
  };

  const onSubmit = async e => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/titular/crear-titular", fisico);
    history.push("/");
  };

  return (
    <div className="container">
      <div className="w-75 mx-auto shadow p-5">
        <h2 className="text-center mb-4">Abrir cuenta para persona física</h2> 
        <form onSubmit={e => onSubmit(e)}>
          <div className="form-group">
            <input
              type="text"
              className="form-control form-control-lg"
              placeholder="Ingrese su nombre"
              required
              name="nombre"
              value={nombre}
              onChange={e => onInputChange(e)
              }
            />
          </div>

          <div className="form-group">
            <input
              type="text"
              className="form-control form-control-lg"
              placeholder="Ingrese su apellido"
              required
              name="apellido"
              value={apellido}
              onChange={e => onInputChange(e)
              }
            />
          </div>

          <div className="form-group">
            <input
              type="number"
              className="form-control form-control-lg"
              placeholder="Ingrese su numero de cuenta corriente"
              required
              name="cuentaCorriente"
              value={cuentaCorriente}
              onChange={e => onInputChange(e)}
            />
          </div>
          
          <div className="form-group">
            <input
              type="number"
              className="form-control form-control-lg"
              placeholder="Ingrese su RUT"
              required
              name="rut"
              value={rut}
              onChange={e => onInputChange(e)}
            />
          </div>
        
          <button className="btn btn-primary btn-block">Crear cuenta</button>

        </form>
      </div>
    </div>
  );
};

export default TitularFisico;