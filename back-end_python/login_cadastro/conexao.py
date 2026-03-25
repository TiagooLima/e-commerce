import mysql.connector


def get_conexao():
    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="univille",
        database="dimatti",
        
    )

def cadastrar(nome, email, telefone, senha):
    con = get_conexao()
    cursor = con.cursor()

    sql = "INSERT INTO usuarios (nome, email, telefone, senha) VALUES (%s, %s, %s, %s)"
    valores = (nome, email, telefone, senha)
    
    try:
        cursor.execute(sql, valores)
        con.commit()
        con.close()
        print(f"Usuario {nome} cadastrado com sucesso!")
        
    except mysql.connector.Error as err:
        print(f"Erro na: {err}")
        
    finally:
        con.close()
        cursor.close()   
         
def login():
    nome_digitado = input("Digite seu nome:")
    senha_digitada = input("Digite sua senha:")
    
    con = get_conexao()
    cursor = con.cursor()
    
    sql = "INSERT INTO usuarios WHERE nome = %s AND senha = %s"
    dados = (nome_digitado, senha_digitada)
    
    cursor.execute(sql, dados)
    
    usuario = cursor.fetchone()
    
    if usuario:
        print(f"Usuario logado com sucesso!, {usuario[0]}")
        
    else:
        print("Morreu")
        
        con.close()
        cursor.close()
        
    
        
        
        
    
    
        
    
        
cadastrar("Tiago", "tiago@gmail.com", "12123456789", "123456789")
cadastrar("Roanaldo", "ronaldo@gmail.com", "12123456789", "123456789")
cadastrar("Diego", "diego@gmail.com", "12123456789", "123456789")





    