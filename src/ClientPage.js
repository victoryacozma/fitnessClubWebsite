import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import axiosInstance from "./axios"; 
import MySimpleCard from "./MySimpleCard";
import ClientSubscr from "./ClientSubscr";
import {Avatar, ListItem, ListItemIcon, ListItemText, List} from '@material-ui/core';


class ClientPage extends React.Component{
	
	//state-ceva ce tine de clasa respectiva(ca variabile instanta)
	//props - se pot trimite intre pagini
	constructor(props) {
		super(props);
		this.state = {
			idClient: null,
			infoClient: [],
			subscription: []
		};
		this.displayClient.bind(this);
	};


	//setam totul din state (preluam din backend)
	componentDidMount(){
		this.displayClient();
	}

	   displayClient = () => {
			const data = localStorage.getItem("USER_ID");
			this.setState({idClient : localStorage.getItem("USER_ID")});
			
			axiosInstance.get(`/client/${localStorage.getItem("USER_ID")}`)
			.then( res => {
				const val = res.data;
				this.setState({ 
				infoClient: val
			});

			console.log(res.data);
			console.log(val);
			})
			.catch(error => {
			console.log(error);
			});

			axiosInstance.get(`/client/idAndSubscr/${localStorage.getItem("USER_ID")}`)
			.then( res => {
				const val = res.data;
				this.setState({ 
				subscription: val
			});

			console.log(res.data);
			console.log(val);
			
			})
			.catch(error => {
			console.log(error);
			});
	   }

	onSubmitFun = event => {
        event.preventDefault();
        let personalInfo = {
            username: this.state.infoClient.username,
            name: this.state.infoClient.name,
			address: this.state.infoClient.address
        }
		this.props.history.push("/edit-profile"); 
    }
	


	render(){
		return(
		<React.Fragment>
		 <h1>Hello, {this.state.infoClient.name}!</h1>
		 <h1>Personal info: </h1>
		 <h1>{"Name: " + this.state.infoClient.name} </h1>
		 <h1>{"Address: " + this.state.infoClient.address} </h1>
		 <h1>{"Username: " + this.state.infoClient.username} </h1>
		 <h1>{"Abonament activ : " + this.state.subscription.tip} </h1>
		 <h1>{"Data de inceput: " + this.state.subscription.data_inceput} </h1>
		 <h1>{"Durata: " + this.state.subscription.durata} </h1>
		  <Button
                            variant="contained"
                            color="primary"
                            id="create"
                            type="submit"
							onClick={this.onSubmitFun}
                        >
                            Update Personal Info
              </Button>
		</React.Fragment>
		)
	}
}

export default ClientPage;