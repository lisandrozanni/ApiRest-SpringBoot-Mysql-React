import React, { useState } from "react";
import axios from 'axios'
import { useHistory } from "react-router-dom";

const TitularJuridico = () => {
  let history = useHistory();
  const [juridico, setJuridico] = useState({
    nombre: "",
    apellido: " -",
    cuentaCorriente: " -",
    razon: "",
    anio: "",
    rut: "",
    caracteristica: " Persona juridica"
  });

  const { nombre, razon, anio, rut } = juridico;

  const handleinputchange = e => {
    setJuridico({ ...juridico, [e.target.name]: e.target.value });
  };

  const handleSubmit = async e => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/titular/crear-titular", juridico);
    history.push("/");
  };

  return (
    <div className="container">
      <div className="w-75 mx-auto shadow p-5">
        <h2 className="text-center mb-4">Abrir cuenta para persona jurídica</h2> 
        <form onSubmit={handleSubmit}>
          <div className="form-group">
              <input
                type="text"
                className="form-control form-control-lg"
                placeholder="Nombre de la Empresa"
                required
                name="nombre"
                value={nombre}
                onChange={handleinputchange}
              />
            </div>  

          <div className="form-group">
              <input
                type="text"
                className="form-control form-control-lg"
                placeholder="Razón social"
                required
                name="razon"
                value={razon}
                onChange={handleinputchange}
              />
            </div>
            
            <div className="form-group">
              <input
                type="number"
                className="form-control form-control-lg"
                placeholder="Año de fundación"
                required
                name="anio"
                value={anio}
                onChange={handleinputchange}
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
                onChange={handleinputchange}
              />
            </div>
            
            <button className="btn btn-primary btn-block">Crear cuenta</button>

        </form>
      </div>
    </div>
  );
};

export default TitularJuridico;