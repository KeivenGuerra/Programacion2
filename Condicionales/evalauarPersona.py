def evaluar_persona(nombre, apellido, edad, sexo):
    if edad >= 18:
        print(f"{nombre} {apellido} es mayor de edad.")
    else:
        print(f"{nombre} {apellido} es menor de edad.")
    
    if sexo.lower() == "masculino":
        print(f"{nombre} es un Hombre.")
    elif sexo.lower() == "femenino":
        print(f"{nombre} es una Mujer.")
    else:
        print("Sexo no reconocido.")

def main():
    nombre = input("Ingrese su nombre: ")
    apellido = input("Ingrese su apellido: ")
    edad = int(input("Ingrese su edad: "))
    sexo = input("Ingrese su sexo (Masculino/Femenino): ")
    
    evaluar_persona(nombre, apellido, edad, sexo)

if __name__ == "__main__":
    main()
