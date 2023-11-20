# Clase que actúa como controlador para gestionar el carrito de compras
class ShoppingCartController:
    def add_to_cart(self, product, quantity):
        cart = ShoppingCart()
        cart.add_item(product, quantity)

# Ejemplo de uso del Controlador
controller = ShoppingCartController()
controller.add_to_cart(product1, 3)
controller.add_to_cart(product2, 2)
print(cart.items)
