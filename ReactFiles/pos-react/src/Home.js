import { useState } from "react";
import React from 'react';
import menuitems from "./menuitems";

const Home = () => {
    const [msg, setMsg] = useState('hi guys');
    const [idnum, setIdNum] = useState(350);
    const [tickets, setTickets] = useState([
        {ticketID: 5, orders: 'water, coke, chips', total: 53.21},
        {ticketID: 2, orders: 'cookie, juice', total: 13.10},
        {ticketID: 3, orders: 'steak, potatoes', total: 125.00}
    ]);


    const handeClick = () => {
        console.log('greetings');
        setMsg('new msg');
        setIdNum(25);
    }

    return (  
        
        <><React.Fragment>
            <section>
            < div className="home">
                <div className="w-screen h-250 grid grid-rows-2 text-4xl md:grid-cols-2">
                    <div className='w-full h-900 '>
                        <div className="ticket-map">
                    
                        {tickets.map((ticket) => (
                         <div className="ticket-preview" key={ticket.ticketID}>
                                <h2>ticketID: {ticket.ticketID}</h2>
                                <h3>Orders: {ticket.orders}</h3>
                                <p>total: {ticket.total}</p>

                            </div>
                        ))}
                        </div> 
                    </div>

                    {/* <div className="flex w-full h-100 justify-center md:h-screen">
                        <div className="menu-items"><p>Menu</p>
                        </div>
                    </div> */}
                    <div>
                        <menuitems/>
                        <p>test</p>
                        
                    </div>
                </div>
            </div>
            </section>
        </React.Fragment></>
        
    );
}
 
export default Home;