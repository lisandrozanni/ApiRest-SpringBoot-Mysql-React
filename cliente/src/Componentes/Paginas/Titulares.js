import React, { useState, useEffect } from "react";
import axios from "axios";

import { Link } from "react-router-dom";

const Titulares = () => {
  const [titulares, setTitulares] = useState({
    nombre: "",
    email: "",  
    rut: "",
  });

  useEffect(() => {
    cargarTitulares();
  }, []);


  const cargarTitulares = async () => {
    const result = await axios.get("http://localhost:8080/api/titular/todos");
    setTitulares(result.data.reverse());
  };


  const eliminarTitular = async id => {
    await axios.delete(`http://localhost:8080/api/titular/eliminar-titular/${id}`);
    cargarTitulares();
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Titulares cuenta corriente</h2>
        <table className="table border shadow">
          
          <thead className="thead-dark">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Nombre</th>
              <th scope="col">RUT</th>
              <th scope="col">Característica</th>
              <th>Accion</th>
            </tr>
          </thead>
          {titulares.length ?
          <tbody>
            {titulares.map((titular, index) => (
              <tr>
                <th scope="row">{index + 1}</th>
                <td>{titular.nombre}</td>
                <td>{titular.rut}</td>
                <td>{titular.caracteristica}</td>
                <td>
                  <Link className="btn btn-primary mr-2" to={`/Titulares/${titular.id}`}>
                    ver cuenta
                  </Link>
                  <Link
                    className="btn btn-outline-primary mr-2"
                    to={`/Titulares/edit/${titular.id}`}
                  >
                    Editar
                  </Link>
                  <Link
                    className="btn btn-danger"
                    onClick={() => eliminarTitular(titular.id)}
                  >
                    Eliminar cuenta
                  </Link>
                </td>
              </tr>
            ))} 
          </tbody>
          : (
              <tbody>
                <tr>
                  <th>No hay cuentas registradas</th>
                </tr>
              </tbody>
            ) }
        </table>
        </div>
    </div>
  );
}

export default Titulares;