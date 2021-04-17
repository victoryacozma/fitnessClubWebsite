import React from "react";
import {
    ListItem,
    List,
    ListItemText,
    Avatar,
    ListItemIcon,
} from "@material-ui/core";


class ClientSubscr extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            <React.Fragment>
                <List>
                    {this.props.subscriptions.map(subscription => (
                        <ListItem key={subscription.id}>
                            <ListItemIcon>
                                <Avatar>{"O"}</Avatar>
                            </ListItemIcon>
                            <ListItemText
                                primary={subscription.id + " " + subscription.tip} />

                        </ListItem>
                    ))}
                </List>
            </React.Fragment>
        )
        
    }
}

export default ClientSubscr;