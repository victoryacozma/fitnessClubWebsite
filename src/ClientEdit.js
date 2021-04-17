import React from "react";
import {
    ListItem,
    List,
    ListItemText,
    Avatar,
    ListItemIcon,
	TextField,
	Modal
} from "@material-ui/core";
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import axiosInstance from "./axios"; 
import MySimpleCard from "./MySimpleCard";
import ClientSubscr from "./ClientSubscr";




class ClientEdit extends React.Component {
    constructor(props) {
		super(props);
		this.state = {
			idClient: null,
			infoClient: [],
			subscription: [],
			newName: "",
			newAddress: "",
			newPassword: "",
			saved: false
		};
		this.displayClient.bind(this);
	};

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
	   }

	   handleInput1 = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name] : value
        })
		console.log("New name is: " + this.state.newName);
        }


		handleInput2 = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name]: value
        })
		console.log("New address is: " + value);
        }

		handleInput3 = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name]: value
        })
        }

		displayPopup = () => {
			this.setState({
				saved: true
			})
		}


		onSubmitFun = event => {
        event.preventDefault();
        let personalInfo = {
			address: this.state.newAddress,
			id : this.state.idClient, 
            name: this.state.newName,
			password: this.state.newPassword
        } 
		axiosInstance.put("/client", personalInfo)
			.then( res => {
				this.displayPopup();
				personalInfo = res.data;
			})
			.catch(error => {
			console.log(error);
			});

        }


    render() {
        return (
            <React.Fragment>
			
                      <form onSubmit={this.handleSubmit}>
                    <Typography variant="h6" color="textPrimary" component="h6">
                        Update Personal Information
            </Typography>
                    <div>
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Name 
                </Typography>
                            <TextField
                                required={false}
                                id="required"
                                //label="Name"
								//value = {this.state.infoClient.name}
                                name="newName"
                                placeholder={this.state.infoClient.name}
                                onChange={this.handleInput1}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Address
                </Typography>
                            <TextField
                                required={false}
                                id="required"
                                //label="Car ID"
                                name="newAddress"
                                placeholder={this.state.infoClient.address}
                                onChange={this.handleInput2}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
				<div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Password
                </Typography>
                            <TextField
                                required={false}
                                id="required"
                                //label="newUsername"
								//value = {this.state.infoClient.name}
                                name="newPassword"
                                placeholder="new password"
                                onChange={this.handleInput3}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                    </div>
				
                    <div id="buttons">
                        <Button
                            variant="contained"
                            color="primary"
                            id="create"
                            type="submit"
							onClick={this.onSubmitFun}
                        >
                            Save
              </Button>
                    </div>
                </form>

				{this.state.saved ? 
				  <h1> Saved </h1>: null}
            </React.Fragment>
        )
        
    }
}

export default ClientEdit;