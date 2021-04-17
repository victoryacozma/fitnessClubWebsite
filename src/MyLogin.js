import './MyLogin.css';

import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Paper from '@material-ui/core/Paper';
import Box from '@material-ui/core/Box';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import axiosInstance from "./axios";

class MyLogin extends React.Component{

constructor() {
        super();
        this.state = {
            username: "",
            password: "",

            loginSucces: {
                role: "",
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
        let credentilas = {
            username: this.state.username,
            password: this.state.password
        }

        axiosInstance.post("/login", credentilas)
            .then(
                res => {
                    const val = res.data;
                    this.setState({
                        loginSucces: val
                    });
                    console.log("Succes");
                    console.log(this.state.loginSucces);

                    localStorage.setItem("USER", res.data.role);
                    localStorage.setItem("USER_ID", res.data.id);

                    if (this.state.loginSucces.role === "CLIENT") {
                        this.props.history.push("/clientpage");
                    }
                    if (this.state.loginSucces.role === "ADMIN") {
                        this.props.history.push("/administration");
                    }
                }
            )
            .catch(error => {
                console.log(error)
            })
    }

  render() {
  return (
    <Grid container className="root">
      <Grid item xs={false} sm={4} md={7} className="image" />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square className = "alignItemsAndJustifyContent">
        <div className="Paper">
          <Avatar className="avatar">
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          
		  <form onSubmit={this.onSubmitFun}>
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              id="username"
              label="Username"
              name="username"
              autoComplete="string"
			  onChange={this.handleInput}
              autoFocus
            />
            <TextField
              variant="outlined"
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
			  onChange={this.handleInput}
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className="submit"
            >
              Sign In
            </Button>
            <Grid container>
              <Grid item>
                <Link href="#" variant="body2">
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </form>
        </div>
      </Grid>
    </Grid>
  );
  }
}

export default MyLogin;