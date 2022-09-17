import axios from 'axios';
import React, { useState, useEffect } from 'react';

const url = 'http://localhost:8080/api/shippers';
// const url = 'http://localhost:3000/shipper-list.json';

const ShipperList = () => {
    let [shippers, setShippers] = useState([]);

    useEffect(() => {
        axios
            .get(url, { headers: { Accept: 'application/json' } })
            .then((resp) => resp.data) // response body is accessed via resp.data
            .then((data) => data.shipperList)
            .then(setShippers);
    }, []);

    return (
        <>
            <h3>Here is the list of all shipping companies</h3>
            <table className='table table-bordered'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Company name</th>
                        <th>Phone number</th>
                    </tr>
                </thead>
                <tbody>
                    {shippers.map((sh) => (
                        <tr key={sh.shipperId}>
                            <td>{sh.shipperId}</td>
                            <td>{sh.companyName}</td>
                            <td>{sh.phone}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );
};

export default ShipperList;
