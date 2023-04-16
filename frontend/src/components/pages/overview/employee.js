import React from "react";
import Box from '@mui/material/Box';
import data from "./mockupData.json";
import Typography from '@mui/material/Typography';

export default function Employee(){
	return <div style={{padding:"20px"}}>
		<Box sx = {{display : 'flex',alignItems: "center"}}>
			<Typography variant = "body2" sx={{width: 150}}>
				Date of Birth: 
			</Typography>
			<Typography variant = "subtitle2" >
				{data.dob}
			</Typography>
		</Box>

		<Box sx = {{display :'flex',alignItems: "center"}}>
			<Typography variant = "body2" sx={{width: 150}}>
				Address: 
			</Typography>
			<Typography variant = "subtitle2" >
				{data.address}
			</Typography>
		</Box>  

		<Box sx = {{display : 'flex',alignItems: "center"}}>
			<Typography variant = "body2" sx={{width: 150}}>
				Phone: 
			</Typography>
			<Typography variant = "subtitle2" >
				{data.phone}
			</Typography>
		</Box>

		<Box sx = {{display : 'flex',alignItems: "center"}}>
			<Typography variant = "body2" sx={{width: 150}}>
				Email: 
			</Typography>
			<Typography variant = "subtitle2" >
				{data.email}
			</Typography>
		</Box>    
	</div>
}