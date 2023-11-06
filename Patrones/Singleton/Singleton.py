class Singleton:
    _instance = None  # Variable privada para almacenar la única instancia.

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Singleton, cls).__new__(cls)
            cls._instance.initialized = False
        return cls._instance

    def __init__(self):
        if not self.initialized:
            self.initialized = True
            # Coloca aquí cualquier inicialización que necesites para tu instancia.

    def some_method(self):
        print("Método de la instancia Singleton.")


# Ejemplo de uso
singleton1 = Singleton()
singleton2 = Singleton()

if singleton1 is singleton2:
    print("Las dos instancias son la misma instancia Singleton.")
else:
    print("Las dos instancias no son la misma instancia Singleton.")

singleton1.some_method()