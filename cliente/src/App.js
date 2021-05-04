import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import Navegacion from "./Componentes/BarraNavegacion/Navegacion";
import {
  BrowserRouter as Router,
  Route,
  Switch,
} from "react-router-dom";
import Titulares from "./Componentes/Paginas/Titulares";
import AgregarTitular from "./Componentes/Paginas/AgregarTitular";
import TitularFisico from "./Componentes/Titulares/TitularFisico";
import TitularJuridico from "./Componentes/Titulares/TitularJuridico";
import EditarTitular from "./Componentes/Titulares/EditarTitular";
import InfoTitulares from "./Componentes/Titulares/InfoTitulares";
import CuenteCorriente from "./Componentes/Paginas/CuenteCorriente";
import CrearCuentaCorriente from "./Componentes/Cuenta-Corriente/CrearCuentaCorriente";
import HistorialMovimientos from "./Componentes/Cuenta-Corriente/HistorialMovimientos";
import AgregarMovimiento from "./Componentes/Cuenta-Corriente/AgregarMovimiento";

function App() {
  return (
    <Router>
      <div className="App">
        <Navegacion />

        <Switch>
          <Route exact path="/" component={Titulares} />
          <Route exact path="/abrir-cuenta" component={AgregarTitular} />
          <Route exact path="/titulares/persona-fisica" component={TitularFisico} />
          <Route exact path="/titulares/persona-juridica" component={TitularJuridico} />
          <Route exact path="/titulares/edit/:id" component={EditarTitular} />
          <Route exact path="/titulares/:id" component={InfoTitulares} />
          <Route exact path="/cuenta-corriente" component={CuenteCorriente} />
          <Route exact path="/cuenta-corriente/cuenta-corriente" component={CrearCuentaCorriente} />
          <Route exact path="/cuenta-corriente/agregar-movimiento" component={AgregarMovimiento} />
          <Route exact path="/cuenta-corriente/:numerocuenta" component={HistorialMovimientos} />
          
        </Switch>
      </div>
    </Router>
  );
}

export default App;
