import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

const HistorialMovimientos = () => {
  const [historial, setHistorial] = useState({
    numeroCuenta: "",
    tipoMovimiento: "",
    descripcion:"",  
    importe: ""
  });

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/api/movimiento/lista");
    setHistorial(result.data.reverse());
  };

  return (
    <div className="container">
      <div className="py-4">
      <Link className="btn btn-primary" to="/cuenta-corriente">
        volver a cuentas corriente
      </Link>
      <h2>Titulares cuenta corriente</h2>
      <table className="table border shadow">
        
        <thead className="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Numero de cuenta</th>
            <th scope="col">Tipo de movimiento</th>
            <th scope="col">Importe</th>
            <th>Descripcion</th>
            <th scope="col">Fecha de movimiento</th>
          </tr>
        </thead>
        {historial.length ?
        <tbody>
          {historial.map((hm, index) => (
            <tr>
              <th scope="row">{index + 1}</th>
              <td>{hm.numeroCuenta}</td>
              <td>{hm.tipoMovimiento}</td>
              <td>$ {hm.importe}</td>
              <td>{hm.descripcion}</td>
              <td>{hm.fechaCreacion}</td>
            </tr>
          ))} 
        </tbody>
        : (
            <tbody>
              <tr>
                <th>No hay movimientos registrados</th>
              </tr>
            </tbody>
          ) }
      </table>
      </div>
  </div>
  );
};

export default HistorialMovimientos;
