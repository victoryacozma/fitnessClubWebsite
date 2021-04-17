import React from 'react';

import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import {Container, Typography, Box, Grid, Link, Checkbox, FormControlLabel,TextField,Button,Avatar} from '@material-ui/core';
import axiosInstance from "./axios";

import './Register.css';


class Register extends React.Component {
    constructor() {
        super();
        this.state = {
			firstName: "",
			lastName: "",
			address: "",
            username: "",
            password: "",

            signUpSucces: {
                role: "Client",
                id: 0
            }
        };
    }

	handleInput = event => {
        const { value, name } = event.target;
        this.setState({
            [name]: value
        });
        console.log(value);
    };

	onSubmitFun = event => {
        event.preventDefault();
        let newUser = {
			firstName: this.state.firstName,
			lastName: this.state.lastName,
			address: this.state.address,
            username: this.state.username,
            password: this.state.password
        }

        axiosInstance.post("/newUser", newUser)
            .then(
                res => {
                    const val = res.data;
                    this.setState({
                        signUpSucces: val
                    });
                    console.log("Succes");
                    console.log(this.state.signUpSucces);
					this.props.history.push("/log-in");
                    //localStorage.setItem("USER", res.data.role);
                    //localStorage.setItem("USER_ID", res.data.id);

                    /*if (this.state.loginSucces.role === "CLIENT") {
                        this.props.history.push("/clientpage");
                    }
                    if (this.state.loginSucces.role === "ADMIN") {
                        this.props.history.push("/administration");
                    }*/
                }
            )
            .catch(error => {
                console.log(error)
            })
    }



render(){
 return (
    <Container component="main" maxWidth="xs">
      <div className="paper">
        <Avatar className="avatar">
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign up
        </Typography>
        <form onSubmit={this.onSubmitFun}>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="fname"
                name="firstName"
                variant="outlined"
                required
                fullWidth
                id="firstName"
                label="First Name"
				onChange={this.handleInput}
                autoFocus
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="lastName"
                label="Last Name"
                name="lastName"
                autoComplete="lname"
				onChange={this.handleInput}
              />
            </Grid>
			<Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="address"
                label="Address"
                name="address"
                autoComplete="Address"
				onChange={this.handleInput}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                id="username"
                label="Username"
                name="username"
                autoComplete="email"
				onChange={this.handleInput}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
				onChange={this.handleInput}
              />
            </Grid>
            <Grid item xs={12}>
              <FormControlLabel
                control={<Checkbox value="allowExtraEmails" color="primary" />}
                label="I want to receive inspiration, marketing promotions and updates via email."
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="submit"
          >
            Sign Up
          </Button>
          <Grid container justify="flex-end">
            <Grid item>
              <Link href="#" variant="body2">
                Already have an account? Sign in
              </Link>
            </Grid>
          </Grid>
        </form>
      </div>
    </Container>
  );}
 
}
export default Register;