import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Crear un socket de cliente y conectar al servidor en el puerto 8080
            Socket clientSocket = new Socket("127.0.0.1", 8080);

            // Crear flujos de entrada y salida para comunicarse con el servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Enviar un mensaje al servidor
            out.println("Hola, servidor!");

            // Leer la respuesta del servidor
            String serverResponse = in.readLine();
            System.out.println("Respuesta del servidor: " + serverResponse);

            // Cerrar la conexión con el servidor
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
