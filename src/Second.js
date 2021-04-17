import React from "react"
import { Button } from '@material-ui/core';
import axiosInstance from "./axios"; 
import {Avatar, ListItem, ListItemIcon, ListItemText, List} from '@material-ui/core';

class Second extends React.Component{
    constructor() {
        super()
        this.state = {
            subscriptions: []
        }
    };

	//setam totul din state (preluam din backend)
	componentDidMount(){
		axiosInstance.get(
			"http://localhost:8080/subscriptions",
		).then( res => {
			const val = res.data;
			this.setState({ 
				subscriptions: val
			});
			//console.log(this.state.subscriptions);
			//console.log(val);
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
					{this.state.subscriptions.map(
						subscription => (
							<ListItem>
								<ListItemIcon>
									<Avatar>{"M"}</Avatar>
								</ListItemIcon>
							<ListItemText
								primary = {subscription.tip} />
							</ListItem>

						)
					)}
				</List>
			</React.Fragment>
		)
	}
}

export default Second;