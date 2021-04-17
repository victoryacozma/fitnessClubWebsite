import logo from './logo.svg';
import './App.css';
import Login from './Login';
import First from './First';
import Second from './Second';
import ClientPage from './ClientPage';
import MyLogin from './MyLogin';
import ClientEdit from './ClientEdit';
import Register from './Register';
import { Button } from '@material-ui/core';

import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect
} from "react-router-dom";


function App() {
  const defaultRoute = window.location.pathname === "/" ? <Redirect to="/log-in" /> : undefined;
  return (
    
    <Router>
      <Switch>
        <Route exact path="/log-in" component={Login} />
        <Route exact path="/register" component={Register} />
		<Route exact path="/clientpage" component={ClientPage} />
        <Route exact path="/administration" component={First} />
		<Route exact path="/subscriptions" component={Second} />
		<Route exact path="/edit-profile" component={ClientEdit} />
      </Switch>
      {defaultRoute}
    </Router>

  );
}

export default App;
