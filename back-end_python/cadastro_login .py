from conexao import get_conexao

#CADASTRO

def cadastrar(nome,email,senha):
    conn = get_conexao()
    cursor = conn.cursor() 

    sql = "INSERT INTO usuarios(nome,email,senha) VALUES (%s, %s, %s)"
    valores = (nome,email, senha)

    try:
        cursor.execute(sql,valores)
        conn.commit()
        conn.close()

        print(f"Usuario {nome} cadastrado com sucesso!")
    
    except ValueError as err:
        print("Erro na:", err)
    
    finally:
        if 'conn' in locals() and conn.is_connected:
            conn.close()
            cursor.close()
            print("Conexão encerrada!")

if __name__ == "__main__":
    digitar_nome = input("Digite seu nome: ")
    digitar_email = input("Digite seu email: ")
    digitar_senha = input("Digite sua senha: ")
    cadastrar(digitar_nome,digitar_email,digitar_senha)

    #LOGIN

def login():
    nome_digitado = input("Digite seu nome: ")
    senha_digitada = input("Digite sua senha:")

    conn = get_conexao()
    cursor = conn.cursor() 

    sql = "SELECT * FROM usuarios WHERE nome = %s AND senha = %s"
    valores = (nome_digitado,senha_digitada)

    cursor.execute(sql,valores)

    usuario = cursor.fetchone()

    if usuario:
        print(f"Usuario logado com sucesso {usuario[1]}")

    else:
        print("Erro ao logar")

    conn.close()
    cursor.close()


login()