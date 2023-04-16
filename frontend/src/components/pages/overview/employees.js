import * as React from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import Button from '@mui/material/Button';
import AddIcon from '@mui/icons-material/Add';
import WorkHistory from "./workHistory"
import data from './mockEmployees.json';
function createData(id, data) {
  return {
    id,
    ...data,
    history: [
      {
        date: '2020-01-05',
        customerId: '11091700',
        amount: 3,
      },
      {
        date: '2020-01-02',
        customerId: 'Anonymous',
        amount: 1,
      },
    ],
  };
}

function Row(props) {
  const { row } = props;
  const [open, setOpen] = React.useState(false);

  return (
    <React.Fragment>
      <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
        <TableCell>
          <IconButton
            aria-label="expand row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
        </TableCell>
        <TableCell>{row.id}</TableCell>
        <TableCell>{row.name}</TableCell>
        <TableCell>{row.position}</TableCell>
        <TableCell>{row.dob}</TableCell>
        <TableCell>{row.phone}</TableCell>
        <TableCell>{row.email}</TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            <Box>
              <Typography variant="h6" gutterBottom component="div">
                History
              </Typography>
              <WorkHistory size={"small"} employeeId={row.id} maxHeight={300}/>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </React.Fragment>
  );
}


const rows = [
  createData('Frozen yoghurt', 159, 6.0, 24, 4.0, 3.99),
  createData('Ice cream sandwich', 237, 9.0, 37, 4.3, 4.99),
  createData('Eclair', 262, 16.0, 24, 6.0, 3.79),
  createData('Cupcake', 305, 3.7, 67, 4.3, 2.5),
  createData('Gingerbread', 356, 16.0, 49, 3.9, 1.5),
];

export default function EmployeesTable() {
  return (
   <Box sx={{padding: 2, display: 'flex', width:'100%'}}>
   	  <Box sx={{width:'100%'}}>
   		<Box sx={{display:'flex',width:'100%'}}><Button variant="outlined" startIcon={<AddIcon />}>New Employee</Button></Box>
	    <TableContainer component={Paper} sx={{marginTop:5, maxHeight: 440}} >
	      <Table aria-label="collapsible table">
	        <TableHead>
	          <TableRow>
	          	<TableCell/>
	            <TableCell>ID</TableCell>
	            <TableCell>Name</TableCell>
	            <TableCell >Position</TableCell>
	            <TableCell >Date of Birth</TableCell>
	            <TableCell >Phone Number</TableCell>
	            <TableCell >Email</TableCell>
	          </TableRow>
	        </TableHead>
	        <TableBody>
	          {data.map((row, id) => (
	            <Row key={id} row={createData(id, row)} />
	          ))}
	        </TableBody>
	      </Table>
	    </TableContainer>
	  </Box>
    </Box>
  );
}