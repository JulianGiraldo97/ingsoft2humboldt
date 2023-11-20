import socket

# Crear un socket del cliente
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 12345)
client_socket.connect(server_address)

# Enviar un correo electrónico al servidor
email_data = "De: usuario1@gmail.com\nPara: usuario2@gmail.com\nAsunto: Hola\n\nEste es un correo de prueba."
client_socket.send(email_data.encode('utf-8'))

# Recibir la respuesta del servidor
response = client_socket.recv(1024).decode('utf-8')
print("Respuesta del servidor:", response)

# Cerrar el socket del cliente
client_socket.close()
