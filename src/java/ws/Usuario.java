/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

/**
 *
 * @author jhudy
 */
public class Usuario {

    private String Username;
    private String pass;
    private String rpass;
    private float liquidacioninicial;

    public Usuario() {
    }

    public Usuario(String Username, String pass, String rpass, float liquidacioninicial) {
        this.Username = Username;
        this.pass = pass;
        this.rpass = rpass;
        this.liquidacioninicial = liquidacioninicial;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRpass() {
        return rpass;
    }

    public void setRpass(String rpass) {
        this.rpass = rpass;
    }

    public float getLiquidacioninicial() {
        return liquidacioninicial;
    }

    public void setLiquidacioninicial(float liquidacioninicial) {
        this.liquidacioninicial = liquidacioninicial;
    }
}
