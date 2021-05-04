import React, { useState, useEffect } from "react";
import axios from "axios";
import { useHistory, useParams } from "react-router-dom";


  const EditarTitular = () => {
    let history = useHistory();
  
    const [users, setUser] = useState({
      nombre: "",  
      rut: "",
      cuentaCorriente: "",
      razon: "",
      año: ""
    });
  
    const handleinputchange = e => {
      setUser({ ...users, [e.target.name]: e.target.value });
    };
  
  
    const { id } = useParams();
    useEffect(() => {
      loadUser();
    }, []);
  
    const loadUser = async () => {
      const res = await axios.get(`http://localhost:8080/api/titular/buscar-titular/${id}`);
      setUser(res.data);
    };
  
  

    const handleSubmit = async e => {
      e.preventDefault();
      await axios.put(`http://localhost:8080/api/titular/editar-titular/${id}`, users);
      history.push("/");
    };
  
  
    return (
      <div className="container">
        <div className="w-75 mx-auto shadow p-5">
          <h2 className="text-center mb-4">Editar</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <input
                type="text"
                className="form-control form-control-lg"
                placeholder="Ingrese su nombre completo"
                name="nombre"
                value={users.nombre}
                onChange={handleinputchange}
              />
            </div>
          
            <div className="form-group">
              <input
                type="number"
                className="form-control form-control-lg"
                placeholder="Ingrese su numero de cuenta corriente"
                name="cuentaCorriente"
                value={users.cuentaCorriente}
                onChange={handleinputchange}
              />
            </div>
            <div className="form-group">
              <input
                type="number"
                className="form-control form-control-lg"
                placeholder="Ingrese RUT"
                name="rut"
                value={users.rut}
                onChange={handleinputchange}
              />
            </div>
            <div className="form-group">
              <input
                type="text"
                className="form-control form-control-lg"
                placeholder="Ingrese razón social"
                name="razon"
                value={users.razon}
                onChange={handleinputchange}
              />
            </div>
            <div className="form-group">
              <input
                type="number"
                className="form-control form-control-lg"
                placeholder="Ingrese año de fundacion"
                name="año"
                value={users.año}
                onChange={handleinputchange}
              />
            </div>
            <button className="btn btn-warning btn-block">Editar</button>
          </form>
        </div>
      </div>
    );
  };

export default EditarTitular;
