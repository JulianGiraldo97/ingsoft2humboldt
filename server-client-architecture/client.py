import socket

# Crear un socket del cliente
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Definir la dirección y el puerto del servidor al que conectarse
server_address = ('127.0.0.1', 8080)

# Conectar al servidor
client_socket.connect(server_address)

# Recibir datos del servidor
data = client_socket.recv(1024)
print("Mensaje del servidor: " + data.decode('utf-8'))

# Cerrar la conexión con el servidor
client_socket.close()
