import React from "react";
import { Link } from "react-router-dom";

const AgregarTitular = () => {
 
  return (
    <div className="container">
      <div className="w-75 mx-auto shadow p-5">
        <h2 className="text-center mb-4">¿Que tipo de cuenta desea abrir?</h2> 
        
        <Link className="btn btn-primary btn-block" to="/Titulares/persona-fisica">Abrir cuenta para Persona Fisica</Link>

        <Link className="btn btn-primary btn-block" to="/titulares/persona-juridica">Abrir cuenta para Persona Juridica</Link>

        <Link className="btn btn-primary btn-block" to="/cuenta-corriente/cuenta-corriente">Abrir cuenta corriente</Link>

      </div>
    </div>
  );
};

export default AgregarTitular;
