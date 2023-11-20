import socket

# Crear un socket del servidor
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 12345)
server_socket.bind(server_address)
server_socket.listen(1)

print("Servidor de correo electrónico en ejecución...")

while True:
    # Esperar una conexión entrante
    client_socket, client_address = server_socket.accept()
    print("Conexión entrante desde:", client_address)

    # Recibir el correo electrónico del cliente
    email_data = client_socket.recv(1024).decode('utf-8')

    # Procesar el correo electrónico (en una implementación real, se almacenaría en una base de datos)
    print("Correo electrónico recibido:", email_data)

    # Enviar una respuesta al cliente
    response = "El correo electrónico se ha recibido y procesado."
    client_socket.send(response.encode('utf-8'))

    # Cerrar la conexión con el cliente
    client_socket.close()
