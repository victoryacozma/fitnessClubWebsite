import React from "react"
import { Button } from '@material-ui/core';
import axiosInstance from "./axios"; 
import {Avatar, ListItem, ListItemIcon, ListItemText, List} from '@material-ui/core';

class First extends React.Component{
	
	//state-ceva ce tine de clasa respectiva(ca variabile instanta)
	//probs - se pot trimite intre pagini
	constructor() {
		super();
		this.state = {
			clienti: []
		}
	};

	//setam totul din state (preluam din backend)
	componentDidMount(){
		axiosInstance.get(
			"http://localhost:8080/client",
		).then( res => {
			const val = res.data;
			this.setState({ 
				clienti: val
			});
			console.log(this.state.clienti);
			console.log(val);
		}
			
		
		).catch(error => {
			console.log(error);
		});
	}


	render(){
		return(
			<React.Fragment>
				<Button color="primary">Hello There</Button>
				<List>
					{this.state.clienti.map(
						client => (
							<ListItem>
								<ListItemIcon>
									<Avatar>{"M"}</Avatar>
								</ListItemIcon>
							<ListItemText
								primary = {client.cnp + " " + client.name}
								secondary = {"City: " + client.address}
								/>
							</ListItem>

						)
					)}
				</List>
			</React.Fragment>
		)
	}
}

export default First;