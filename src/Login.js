import React from "react";
import axiosInstance from "./axios";
import { Grid, Link, Paper, Avatar, Typography, TextField, Button, Container} from "@material-ui/core";
import FitnessCenter from '@material-ui/icons/LockOutlined';
import MyLogin from './MyLogin';
import './MyLogin.css';


class Login extends React.Component {
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
            <FitnessCenter />
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
			  color="secondary"
			  InputProps = {{style: {
			  	  color:'white'
			  }}}
			  InputLabelProps = {{style: {
			  	  color:'white'
			  }}}
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
			  color="secondary"
			  InputProps = {{style: {
			  	  color:'white'
			  }}}
			  InputLabelProps = {{style: {
			  	  color:'white'
			  }}}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="secondary"
              className="submit"
            >
              Sign In
            </Button>
            <Grid container>
              <Grid item>
                <Link href="http://localhost:3000/register" variant="body2" color="secondary">
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

export default Login;