import React from "react";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import data from "./mockupData.json";
import "./overview.css";
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Employee from "./employee"
import TicketHistory from "./ticketHistory"
import WorkHistory from "./workHistory"
import Employees from "./employees"
import topSellers from "./topSellers"
import Divider from '@mui/material/Divider';
import Button from '@mui/material/Button';
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
const components = [Employee, TicketHistory, WorkHistory, Employees,topSellers];

export default function Overview (){
	const [tabIndex, setTabIndex] = React.useState(0);

	function handleChange(event, newValue){
		setTabIndex(newValue);
	}

	function renderComponent(){
		const Component = components[tabIndex];
		return <Component />;
	}
	function onClick(path){
  	window.location.href = "/"+ path;
  }
	return (<div>
		 <Button variant="contained" onClick={()=>onClick('')} startIcon={<ArrowBackIcon />}>Back</Button>	
		 <Box sx={{ width: '100%', maxWidth: 500, paddingLeft:"160px" }}>
		 	 <Typography variant="h4" gutterBottom>
       			{data.name}
     		 </Typography>	
     		 <Typography variant="subtitle1" gutterBottom>
		        {data.position}
		      </Typography>	
		      
		 </Box>
		 <Divider />
		  <Box sx={{bgcolor: 'background.paper', display: 'flex', height: "100%" }}>
		        <Tabs value={tabIndex} onChange={handleChange} orientation="vertical" sx={{ borderRight: 1, borderColor: 'divider', minWidth:200 }}>
		          <Tab label="About" />
		          <Tab label="Ticket History" />
		          <Tab label="Work History" />
		    		<Tab label="Employees" />
		    		<Tab label="Top Sellers" />
		        </Tabs>
		      <Box sx={{width: "100%"}}>{renderComponent()}</Box>
		    </Box>
	</div>)
}