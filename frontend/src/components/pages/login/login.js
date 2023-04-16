import * as React from 'react';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';

export default function BasicButtons() {
  function onClick(path){
  	window.location.href = "/"+ path;
  }
  return (
    <Stack spacing={2} direction="row">
      <Button variant="contained" onClick={()=>onClick('kitchens')}>Kitchens</Button>

      <Button variant="contained" onClick={()=>onClick('overview')}>Overview</Button>

    </Stack>
  );
}