import socket

# Crear un socket del servidor
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Definir la dirección y el puerto en el que escuchará el servidor
server_address = ('127.0.0.1', 8080)

# Enlazar el socket al servidor
server_socket.bind(server_address)

# Comenzar a escuchar conexiones entrantes (máximo 5 conexiones en espera)
server_socket.listen(5)

print("Esperando conexiones entrantes...")

while True:
    # Aceptar una conexión entrante
    client_socket, client_address = server_socket.accept()
    print(f"Conexión entrante desde {client_address}")

    # Enviar un mensaje al cliente
    message = "¡Hola, cliente!"
    client_socket.send(message.encode('utf-8'))

    # Cerrar la conexión con el cliente
    client_socket.close()
