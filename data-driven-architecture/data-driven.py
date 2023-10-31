class Task:
    def __init__(self, task_id, description, completed):
        self.task_id = task_id
        self.description = description
        self.completed = completed

class TaskDatabase:
    def __init__(self):
        self.tasks = []

    def add_task(self, description):
        task_id = len(self.tasks) + 1
        new_task = Task(task_id, description, False)
        self.tasks.append(new_task)

    def mark_task_as_completed(self, task_id):
        for task in self.tasks:
            if task.task_id == task_id:
                task.completed = True

    def get_all_tasks(self):
        return self.tasks

    def get_incomplete_tasks(self):
        return [task for task in self.tasks if not task.completed]

    def get_completed_tasks(self):
        return [task for task in self.tasks if task.completed]

# Crear una instancia de la base de datos de tareas
task_db = TaskDatabase()

# Agregar tareas
task_db.add_task("Hacer compras")
task_db.add_task("Preparar la cena")

# Marcar una tarea como completada
task_db.mark_task_as_completed(1)

# Obtener todas las tareas
print("Todas las tareas:")
for task in task_db.get_all_tasks():
    print(f"Tarea {task.task_id}: {task.description} (Completada: {task.completed})")

# Obtener tareas incompletas
print("\nTareas incompletas:")
for task in task_db.get_incomplete_tasks():
    print(f"Tarea {task.task_id}: {task.description} (Completada: {task.completed})")

# Obtener tareas completadas
print("\nTareas completadas:")
for task in task_db.get_completed_tasks():
    print(f"Tarea {task.task_id}: {task.description} (Completada: {task.completed})")
