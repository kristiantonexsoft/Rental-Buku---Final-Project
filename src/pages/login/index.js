import React, { Component } from "react";
import { connect } from "react-redux";
import logo from "../../image/img.png"
import { Link } from "react-router-dom";
import swal from 'sweetalert';
import {
  Button,
  Input,
  Label,
  AccountPage,
  Div,
  Italic,
  Logo,
  LogoHeader,
  Fitur,
  Span,
  LinkCenter,
} from "../../component";

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      pengguna:{}
    };
  }

  setValueInput = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  doLogin = () => {
    if (this.state.username === "" || this.state.password === "") {
      swal("Gagal !", "Username atau Password harus diisi !!", "error");
    } else {
      fetch(`http://localhost:8080/api/login/?username=${this.state.username}&password=${this.state.password}`, {
            method: "get",
            headers: {
                "Content-Type": "application/json; ; charset=utf-8",
                "Access-Control-Allow-Headers": "Authorization, Content-Type",
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then(response => response.json())
        .then(json => {
            this.setState({ 
                pengguna: json
            });

            console.log("Data", this.state.pengguna)

            if(typeof json.errorMessage !== 'undefined')
            {
              swal("Gagal !", json.errorMessage , "error");
            }else if(json.status === 400){
              swal("Gagal !", "Username atau Password salah..." , "error");
            }

            if(this.state.pengguna.role === "Admin"){
              this.props.submitLogin({ userData: this.state.pengguna});
              swal("Success !", "Login berhasil, selamat datang...", "success");
            }else if(this.state.pengguna.role === "Member" || this.state.pengguna.role === "Umum"){
              this.props.submitLogin({ userData: this.state.pengguna});
              swal("Success !", "Login berhasil, selamat datang...", "success");
            }
        })
        .catch((e) => {
            console.log(e);
            swal("Gagal !", "Gagal mengambil data", "error");
        });
    }
       
  };

checkAkses= () => {
  if (this.props.checkLogin === true && this.props.dataUserLogin.password === this.props.dataUserLogin.username) {
    this.props.history.push("/ubahpassworddefault");
  }else if (this.props.checkLogin === true && this.props.dataUserLogin.role === "Admin") {
    this.props.history.push("/admin");
  }else if(this.props.checkLogin === true && this.props.dataUserLogin.role === "Member"){
    this.props.history.push("/pelanggan");
  }else if(this.props.checkLogin === true && this.props.dataUserLogin.role === "Umum"){
    this.props.history.push("/pelanggan");
  }
}

  render() {
    this.checkAkses();
    return (
      <>
        <AccountPage className="wrapper-page">
          <Logo logo={logo} />
          <Div className="p-1">
            <LogoHeader header="Aplikasi Peminjaman Buku" />
            <Div className="form-group">
              <Label>Nama Pengguna</Label>
              <Input
                type="text"
                placeholder=""
                name="username"
                onChange={this.setValueInput}
              />
            </Div>
            <Div className="form-group">
              <Label>Kata Sandi</Label>
              <Input
                type="password"
                placeholder=""
                name="password"
                onChange={this.setValueInput}
              />
            </Div>
            <Div className="form-group row m-t-20">
              <Div className="col-12 text-right">
                <Button
                  className="btn btn-success waves-effect waves-light form-control"
                  onClick={() => this.doLogin()}
                >
                  <Italic className="fas fa-sign-in-alt" /> Masuk
                </Button>
                <LinkCenter>
                  <Link to="/registrasi">
                    <Fitur onClick={() => this.props.history.push("/registrasi")}>
                      <Span> Belum punya akun ? Registrasi disini</Span>
                    </Fitur>
                  </Link>
                </LinkCenter>
              </Div>
            </Div>
          </Div>
        </AccountPage>
      </>
    );
  }
}

const mapStateToProps = (state) => ({
  checkLogin: state.AReducer.isLogin,
  dataUserLogin: state.AReducer.userLogin,
});

const mapDispatchToProps = (dispatch) => {
  return {
    submitLogin: (data) => dispatch({ type: "LOGIN_SUCCESS", payload: data }),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Login);
