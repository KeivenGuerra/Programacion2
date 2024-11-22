import json
import tkinter as tk
from tkinter import ttk, messagebox

class FormUsuarios(tk.Tk):
    def __init__(self, parent):
        self.tipo_action = "Guardar"
        self.tipo_user = ""
        self.frame = ttk.Frame(parent)
        self.frame.pack(fill=tk.BOTH, expand=True, padx=20, pady=20)

        tk.Label(self.frame, text="Registro de usuarios", font=('Times', 16)).place(x=70, y=30)

        labelcedula = tk.Label(self.frame, text="Cedula", font=('Times', 14))
        labelcedula.place(x=70, y=100)
        self.ccedula = tk.Entry(self.frame, width=40)
        self.ccedula.place(x=220, y=100)

        labelnombre = tk.Label(self.frame, text="Nombre", font=('Times', 14))
        labelnombre.place(x=70, y=130)
        self.cnombre = tk.Entry(self.frame, width=40)
        self.cnombre.place(x=220, y=130)

        labelusuario = tk.Label(self.frame, text="Username", font=('Times', 14))
        labelusuario.place(x=70, y=160)
        self.cusuario = tk.Entry(self.frame, width=40)
        self.cusuario.place(x=220, y=160)

        labelcontrasena = tk.Label(self.frame, text="Contraseña", font=('Times', 14))
        labelcontrasena.place(x=500, y=100)
        self.ccontrasena = tk.Entry(self.frame, width=40, show="*")
        self.ccontrasena.place(x=600, y=100)

        labelcorreo = tk.Label(self.frame, text="Correo", font=('Times', 14))
        labelcorreo.place(x=500, y=130)
        self.ccorreo = tk.Entry(self.frame, width=40)
        self.ccorreo.place(x=600, y=130)

        labeltipo = tk.Label(self.frame, text="Rol", font=('Times', 14))
        labeltipo.place(x=500, y=160)
        self.ctipo = ttk.Combobox(self.frame, width=40)
        self.ctipo.place(x=600, y=160)
        self.ctipo["values"] = ("Administrador", "Vendedor")

        btn_guardar = tk.Button(self.frame, text="Guardar", font=('Times', 14), command=self.guardar_usuario)
        btn_guardar.place(x=70, y=190)

        self.listar_usuarios()

    def listar_usuarios(self):
        tk.Label(self.frame, text="LISTADO DE USUARIOS", font=('Times', 16)).place(x=70, y=230)
        self.tablausuarios = ttk.Treeview(self.frame, columns=("Nombre", "Username", "Email", "Rol"))
        self.tablausuarios.heading("#0", text="Cedula")
        self.tablausuarios.heading("Nombre", text="Nombre")
        self.tablausuarios.heading("Username", text="Username")
        self.tablausuarios.heading("Email", text="Email")
        self.tablausuarios.heading("Rol", text="Rol")
        self.tablausuarios.column("#0", width=100)
        self.tablausuarios.column("Nombre", width=150)
        self.tablausuarios.column("Username", width=100)
        self.tablausuarios.column("Email", width=200)
        self.tablausuarios.column("Rol", width=100)

        with open("db_users.json", "r", encoding="utf-8") as file:
            data = json.load(file)
            for usuarios in data["users"]:
                self.tablausuarios.insert("", "end", text=f'{usuarios["id"]}', values=(
                    f'{usuarios["name"]}',
                    f'{usuarios["username"]}',
                    f'{usuarios["email"]}',
                    f'{usuarios["role"]}'
                ))

        self.tablausuarios.place(x=70, y=280)
        self.tablausuarios.bind("<Double-1>", self.seleccionar_usuario)

        btnEliminar = tk.Button(self.frame, text="Eliminar", font=('Times', 14), command=self.eliminar_usuarios).place(x=70, y=580)
        btnActualizar = tk.Button(self.frame, text="Actualizar", font=('Times', 14), command=self.actualizar_usuarios).place(x=170, y=580)

    def guardar_usuario(self):
        cedula = self.ccedula.get()
        nombre = self.cnombre.get()
        username = self.cusuario.get()
        contrasena = self.ccontrasena.get()
        correo = self.ccorreo.get()
        rol = self.ctipo.get()

        if not (cedula and nombre and username and contrasena and correo and rol):
            messagebox.showerror("Error", "Todos los campos son obligatorios")
            return

        with open("db_users.json", "r+", encoding="utf-8") as file:
            data = json.load(file)
            data["users"].append({
                "id": cedula,
                "name": nombre,
                "username": username,
                "password": contrasena,
                "email": correo,
                "role": rol
            })
            file.seek(0)
            json.dump(data, file, indent=4)

        self.tablausuarios.insert("", "end", text=cedula, values=(nombre, username, correo, rol))
        messagebox.showinfo("Éxito", "Usuario guardado correctamente")
        self.limpiar_formulario()

    def seleccionar_usuario(self, event):
        item = self.tablausuarios.selection()[0]
        datos = self.tablausuarios.item(item)
        self.ccedula.delete(0, tk.END)
        self.ccedula.insert(0, datos["text"])
        self.cnombre.delete(0, tk.END)
        self.cnombre.insert(0, datos["values"][0])
        self.cusuario.delete(0, tk.END)
        self.cusuario.insert(0, datos["values"][1])
        self.ccorreo.delete(0, tk.END)
        self.ccorreo.insert(0, datos["values"][2])
        self.ctipo.set(datos["values"][3])

    def actualizar_usuarios(self):
        cedula = self.ccedula.get()
        if not cedula:
            messagebox.showerror("Error", "Seleccione un usuario para actualizar")
            return

        with open("db_users.json", "r+", encoding="utf-8") as file:
            data = json.load(file)
            for user in data["users"]:
                if user["id"] == cedula:
                    user["name"] = self.cnombre.get()
                    user["username"] = self.cusuario.get()
                    user["email"] = self.ccorreo.get()
                    user["role"] = self.ctipo.get()
                    break
            else:
                messagebox.showerror("Error", "Usuario no encontrado")

            file.seek(0)
            json.dump(data, file, indent=4)

        self.listar_usuarios()
        messagebox.showinfo("Éxito", "Usuario actualizado correctamente")

    def eliminar_usuarios(self):
        selected = self.tablausuarios.selection()
        if not selected:
            messagebox.showerror("Error", "Seleccione un usuario para eliminar")
            return

        confirm = messagebox.askyesno("Confirmar", "¿Está seguro de eliminar este usuario?")
        if not confirm:
            return

        with open("db_users.json", "r+", encoding="utf-8") as file:
            data = json.load(file)
            user_id = self.tablausuarios.item(selected[0])["text"]
            data["users"] = [user for user in data["users"] if user["id"] != user_id]
            file.seek(0)
            file.truncate()
            json.dump(data, file, indent=4)

        self.tablausuarios.delete(selected[0])
        messagebox.showinfo("Éxito", "Usuario eliminado correctamente")

    def limpiar_formulario(self):
        self.ccedula.delete(0, tk.END)
        self.cnombre.delete(0, tk.END)
        self.cusuario.delete(0, tk.END)
        self.ccontrasena.delete(0, tk.END)
        self.ccorreo.delete(0, tk.END)
        self.ctipo.set("")


if __name__ == "__main__":
    root = tk.Tk()
    root.title("Gestión de Usuarios")
    root.geometry("900x700")
    app = FormUsuarios(root)
    root.mainloop()
