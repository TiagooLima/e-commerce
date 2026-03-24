import mysql.connector


def get_conexao():
    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="univille",
        database="dimatti"
    )

def cadastrar(nome, email, telefone):
    con = get_conexao
    cursor = con.cursor()

    sql = "INSERTO INTO usuarios(nome, email, telefone) VALUES (%s, %s, %s)"
    dados = ("Joao", "hfgshfs@gmail.com", "12445679986")
    cursor.execute(sql,dados (nome,email,telefone))
    con.commit()
    con.close()
    print("Usuario cadastrado com sucesso!")

def login():
    con = get_conexao
    curs

    