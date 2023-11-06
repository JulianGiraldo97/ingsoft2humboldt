import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Crear un socket de servidor en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);

            System.out.println("Servidor esperando conexiones...");

            while (true) {
                // Aceptar una conexión entrante
                Socket clientSocket = serverSocket.accept();

                // Crear flujos de entrada y salida para comunicarse con el cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Leer datos del cliente
                String clientMessage = in.readLine();
                System.out.println("Mensaje del cliente: " + clientMessage);

                // Convertir el mensaje a mayúsculas
                String response = clientMessage.toUpperCase();

                // Enviar la respuesta al cliente
                out.println(response);

                // Cerrar la conexión con el cliente
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
