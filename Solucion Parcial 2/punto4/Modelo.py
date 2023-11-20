# Clase que representa un producto
class Product:
    def __init__(self, name, price):
        self.name = name
        self.price = price

# Clase que representa un carrito de compras
class ShoppingCart:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(ShoppingCart, cls).__new__(cls)
            cls._instance.items = []
        return cls._instance

    def add_item(self, product, quantity):
        self.items.append({'product': product, 'quantity': quantity})

# Ejemplo de uso del Modelo
product1 = Product("Laptop", 1000)
product2 = Product("Smartphone", 500)

cart = ShoppingCart()
cart.add_item(product1, 2)
cart.add_item(product2, 1)
print(cart.items)
