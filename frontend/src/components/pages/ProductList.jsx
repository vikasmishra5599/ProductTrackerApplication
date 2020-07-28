import React, {useEffect, useState} from 'react'

const ProductList = React.memo(() => {
    const [products, setProducts] = useState([{id: '', type: '', color: '', gblimit: '', price: '', address: ''}])

    useEffect(() => {
        fetch('/api/product', {
            dataType: 'json',
            method: 'GET'
        }).then(response => {
            return response.json()
        }).then(data => {
            setProducts(data.data)
        })
    }, [])

    return (<>
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>type</th>
                <th>color</th>
                <th>gblimit</th>
                <th>price</th>
                <th>address</th>
            </tr>
            </thead>
            <tbody>

            {products && products.map(product => {
                return (<tr>
                    <td>{product.id}</td>
                    <td>{product.type}</td>
                    <td>{product.color}</td>
                    <td>{product.gblimit}</td>
                    <td>{product.price}</td>
                    <td>{product.address}</td>
                </tr>)
            })}
            </tbody>
        </table>
    </>);
})

export default ProductList;