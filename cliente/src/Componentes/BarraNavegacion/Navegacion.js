import React from "react";
import { Link, NavLink } from "react-router-dom";

const Navegacion = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container">
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <NavLink className="navbar-brand" exact to="/">
                Titulares
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="navbar-brand" exact to="/cuenta-corriente">
                Cuentas Corriente
              </NavLink>
            </li>
          </ul>
        </div>
           <Link className="btn btn-outline-light" to="/abrir-cuenta">Abrir una cuenta</Link>
      </div>
    </nav>
  );
};

export default Navegacion;
