import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";

const Titular = () => {
  const [info, setInfo] = useState({
    nombre: "",
    cuentaCorriente: "",  
    rut: "",
    razon: "",
    anio: ""
  });

  const { id } = useParams();
  useEffect(() => {
    cargarInfo();
  }, []);

  const cargarInfo = async () => {
    const res = await axios.get(`http://localhost:8080/api/titular/buscar-titular/${id}`);
    setInfo(res.data);
  };

  return (
    <div className="container py-4">
      <Link className="btn btn-primary" to="/">
        volver a titulares
      </Link>
      <h1 className="display-4">Bienvenido {info.nombre}</h1>
      <hr />
      <ul className="list-group w-50">
        <li className="list-group-item">Nombre: {info.nombre}</li>
        <li className="list-group-item">Apellido: {info.apellido}</li>
        <li className="list-group-item">Cuenta corriente: {info.cuentaCorriente}</li>
        <li className="list-group-item">RUT: {info.rut}</li>
        <li className="list-group-item">Caracteristica: {info.caracteristica}</li>
        <li className="list-group-item">Año de fundación: {info.anio}</li>
        <li className="list-group-item">Razón social: {info.razon}</li>
        <li className="list-group-item">Cuenta creada: {info.fechaCreacion}</li>
        <li className="list-group-item">Ultima modificacion de la cuenta: {info.ultimaModificacion}</li>
      </ul>
    </div>
  );
};

export default Titular;
