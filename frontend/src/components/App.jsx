import React from 'react';
import {Route, Switch} from 'react-router-dom';
import Home from './pages/Home';
import Contactus from './pages/Contactus';
import Container from 'react-bootstrap/Container';
import ProductList from './pages/ProductList';
import NotFound from './pages/NotFound'

function App() {
    return (
        <Container>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/list" component={ProductList}/>
                <Route exact path="/contact" component={Contactus}/>
                <Route component={NotFound}/>
            </Switch>
        </Container>
    );
}

export default App;