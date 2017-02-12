import React from 'react'

class Login extends React.Component {
    constructor(props){
        super(props);
        alert(JSON.stringify(this.props));
    }
    render() {
        return(
            <div>
                <span> Usename
                    <input type="text" ref={node => {
                    this.username = node}}/>
                </span>
                <span> Password
                    <input type="password" ref={node => { this.password = node}}/>
                </span>
                <button className="btn btn-default" onClick={()=> {this.props.loginUser(this.username.value, this.password.value)}}>
                    Submit
                </button>
            </div>
        );
    }
}

export default Login