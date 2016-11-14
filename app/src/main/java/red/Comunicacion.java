package red;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by andre on 11/7/2016.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;


public class Comunicacion extends Thread {
    private static Comunicacion c;
    private Socket s;
    private InetAddress adress;
    private boolean conectado;

    public Comunicacion() {
        try {
            s = new Socket("192.168.0.11", 5000);
            conectado = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public Comunicacion getInstance() {
        if (c == null) c = new Comunicacion();
        return c;
    }

    public Object recibir() {
        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream(s.getInputStream());
            return entrada.readObject();


        } catch (IOException e) {
            try {
                if (entrada != null) {
                    entrada.close();
                }
                s.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            s = null;
            conectado = false;
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void enviar(Object o) {
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(s.getOutputStream());
            salida.writeObject(o);
            System.out.println("Se envió el mensaje: " + o);
        } catch (IOException e) {
            try {
                if (salida != null) {
                    salida.close();
                }
                s.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            s = null;
            conectado = false;
            e.printStackTrace();
        }
    }
}
