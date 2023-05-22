/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ws;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jhudy
 */
@WebService(serviceName = "Cajero")
public class Cajero {

    /**
     * This is a sample web service operation
     */
    //Declarar arraylist de users
    ArrayList<Usuario> userList = new ArrayList<>();
    Usuario user;

    @WebMethod(operationName = "registro")
    public void registro(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave, @WebParam(name = "repclave") String repclave, @WebParam(name = "saldoinical") float saldoinical) {
        // Buscar si ya existe un usuario con el mismo nombre
        Usuario nuevoUsuario = buscarUsuario(usuario);
        // Verificar si no se encontró un usuario con el mismo nombre y si la clave coincide con la repetición de clave
        if (nuevoUsuario == null && clave.equals(repclave)) {
            // Crear un nuevo usuario y agregarlo a la lista de usuarios
            nuevoUsuario = new Usuario(usuario, clave, repclave, saldoinical);
            userList.add(nuevoUsuario);
        }
    }

    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "usuario") String usuario, @WebParam(name = "clave") String clave) {
        // Buscar el usuario correspondiente al nombre de usuario proporcionado
        Usuario usuarioEncontrado = buscarUsuario(usuario);
        // Verificar si se encontró el usuario y si la clave coincide con la proporcionada
        return usuarioEncontrado != null && usuarioEncontrado.getPass().equals(clave);
    }

    @WebMethod(operationName = "saldo")
    public float saldo(@WebParam(name = "usuario") String usuario) {
        // Buscar el usuario correspondiente al nombre de usuario proporcionado
        Usuario usuarioEncontrado = buscarUsuario(usuario);
        // Devolver el saldo inicial del usuario si se encontró, de lo contrario, devolver 0
        return (usuarioEncontrado != null) ? usuarioEncontrado.getLiquidacioninicial() : 0;
    }

    @WebMethod(operationName = "depositar")
    public void depositar(@WebParam(name = "saldo") float saldo, @WebParam(name = "usuario") String usuario) {
        // Buscar el usuario correspondiente al nombre de usuario proporcionado
        Usuario usuarioEncontrado = buscarUsuario(usuario);
        // Verificar si se encontró el usuario
        if (usuarioEncontrado != null) {
            // Obtener el saldo actual del usuario
            float saldoActual = usuarioEncontrado.getLiquidacioninicial();
            // Actualizar el saldo sumando la cantidad depositada
            usuarioEncontrado.setLiquidacioninicial(saldoActual + saldo);
        }
    }

    @WebMethod(operationName = "retirar")
    public void retirar(@WebParam(name = "valor") float valor, @WebParam(name = "usuario") String usuario) {
        // Buscar el usuario correspondiente al nombre de usuario proporcionado
        Usuario usuarioEncontrado = buscarUsuario(usuario);
        // Verificar si se encontró el usuario
        if (usuarioEncontrado != null) {
            // Obtener el saldo actual del usuario
            float saldoActual = usuarioEncontrado.getLiquidacioninicial();
            // Verificar si el saldo actual es mayor o igual al valor a retirar
            if (saldoActual >= valor) {
                // Actualizar el saldo restando el valor retirado
                usuarioEncontrado.setLiquidacioninicial(saldoActual - valor);
            }
        }
    }

    private Usuario buscarUsuario(String nombreUsuario) {
        // Recorrer la lista de usuarios
        for (Usuario miUsuario : userList) {
            // Verificar si el nombre de usuario coincide
            if (nombreUsuario.equals(miUsuario.getUsername())) {
                // Devolver el usuario encontrado
                return miUsuario;
            }
        }
        return null;
    }

}
