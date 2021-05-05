import React, { useState, useEffect } from "react";
import axios from "axios";

import { Link } from "react-router-dom";

const CuenteCorriente = () => {
  const [cuenta, setCuenta] = useState({
    numeroCuenta: "",
    moneda: "",  
    saldo: ""
  });

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/api/cuenta/visualizar");
    setCuenta(result.data.reverse());
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Cuentas corriente</h2>
        <table className="table border shadow">
          
          <thead className="thead-dark">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Numero de cuenta</th>
              <th scope="col">Moneda</th>
              <th scope="col">Saldo</th>
              <th scope="col">Cuenta creada</th>
              <th>Accion</th>
            </tr>
          </thead>
          {cuenta.length ?
          <tbody>
            {cuenta.map((cuentas, index) => (
              <tr>
                <th scope="row">{index + 1}</th>
                <td>{cuentas.numeroCuenta}</td>
                <td>{cuentas.moneda}</td>
                <td>$ {cuentas.saldo}</td>
                <td>{cuentas.fechaCreacion}</td>
                <td>
                  <Link
                    className="btn btn-outline-primary mr-2"
                    to={"/cuenta-corriente/agregar-movimiento"}
                  >
                    Agregar Movimiento
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
          <div class="trans text-center">
            <Link className="btn btn-primary mr-2" to={`/Cuenta-Corriente/${cuenta.id}`}>
              Historial de movimientos
            </Link>
          </div>
    </div>
  );
}

export default CuenteCorriente;

