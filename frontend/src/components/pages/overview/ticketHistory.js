import React from "react";
import data from "./mockTickets.json";
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';

console.log(data);


export default function TicketHistory(){
	 return (
	<Paper sx={{ width: '100%', overflow: 'hidden', padding: 2 }}>
    <TableContainer  sx={{ maxHeight: 440 }}>
      <Table stickyHeader aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Table Number</TableCell>
            <TableCell align="right">ID</TableCell>
            <TableCell align="right">Total</TableCell>
            <TableCell align="left">Creating Time</TableCell>
            <TableCell align="left">Closing time</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row, index) => (
            <TableRow key={index}>
              <TableCell align="right">{row.tableNum}</TableCell>
              <TableCell align="right">{row.ticketID}</TableCell>
              <TableCell align="right">{row.total}</TableCell>
              <TableCell align="left">{row.creatingTime}</TableCell>
              <TableCell align="left">{row.closingTime}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </Paper>
  );
}