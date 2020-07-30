import React from 'react';
import {Route, Switch} from 'react-router-dom';
import Home from './pages/Home';
import CreateProduct from './pages/CreateProduct';
import Container from 'react-bootstrap/Container';
import ProductList from './pages/ProductList';

function App() {
    return (
        <Container>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/create" component={CreateProduct}/>
                <Route exact path="/list" component={ProductList}/>
            </Switch>
        </Container>
    );
}

export default App;