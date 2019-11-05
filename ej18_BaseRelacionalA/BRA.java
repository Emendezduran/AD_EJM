/*
exercicio 18
baserelacionalA

 E1_1_q conectar a oracle mediante un native protocol all java driver (thin de oracle)

(Isto non fai falla facelo, xa esta feito na maq virtual:dende consola linux e como usuario root (contrasinal oracle) 
lanzar o seguinte comando: yum install  rlwrap.x86_64)

Dende  consola linux:
	- establecer a variable de entorno para conectarse a base de datos ORCL de oracle
            .oraenv
            orcl
	- iniciar  dende o servidor de oracle a base orcl mediante o cliente de texto sqlplus de oracle.
            rlwrap sqlplus sys/oracle as sysdba
            startup
	- probar que tedes conexion a base hr con contrasinal hr
            conn hr/hr
            (en caso de ter a conta expirada facer: alter user hr identified by hr )
            comprobar que hai algunhas taboas creadas : 
             select * from tab;	
	- Crear a taboa 'produtos'  . A estrutura desta taboa debe ser a que sigue:
	CODIGO     VARCHAR2(3)  primary key
	DESCRICION  VARCHAR2(15)
	PREZO	integer
	 
	- Comprobar dende sqlplus que a taboa  foi creada correctamente ( comando:  describe produtos )


	- lanzar dende linux o listener (proceso que escoita peticions de conexion a base de datos  a traves da rede):
            lsnrctl start  (previamente debes sair do sqlplus ca orde:  exit )
            lembrar que o listener tarda +- un minuto en recoñecer os portos que estan a escoita de peticions dende 
            as bases de datos existentes . Para ver se orcl esta a escoita lanzar de cando en vez o comando lsnrctl status, 
            ate que apareza entre  o texto do mensaxe devolto unha linea que conten :  Service "orcl" has 1 instance(s).


Dende esta aplicacion java :
    - (Isto xa esta feito : buscar e descargar do sitio web de oracle  o driver tipo 4 (native protocol all java driver) 
          de oracle ,  en concreto para oracle e o  Oracle Thin Driver (o seu nome deberia ser ojdbc6.jar ou ojdbc7.jar)
    - engadir dito driver (esta na carpeta /home/ oracle /Drivers)   á libreria do proxecto

- crear un metodo de nome 'conexion'  que permita conectarse a base orcl mediante o usuario hr password hr 
            driver = "jdbc:oracle:thin:";
            host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
            porto = "1521";
            sid = "orcl";
            usuario = "hr";
            password = "hr";
            url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
            //para conectar co native protocal all java driver: creamos un obxecto Connection usando o metodo getConnection da clase  DriverManager            
            Connection conn = DriverManager.getConnection(url);

	-crear un metodo de nome 'insireProduto'  que permita inserir na taboa produtos unha fila pasandolle como parametros o codigo o nome e o prezo dun produto

	- crear un metodo chamdo 'listaProdutos' que amose o contido dos rexistros que hai na base  (debe usarse crearse un resulSet e volcar o contido do mesmo ) 

	- Crear un método de nome 'actualizaPre' tal que pasandolle o codigo e prezo dun rexistro actualize o campo  prezo do rexistro  que corresponde a dito  codigo. 

	- Crear un método de nome ‘borrarfila’ tal que pasandolle o codigo dunha fila elimine dita fila da taboa produtos.

	- Crear un método de nome ‘amosarFila’ tal que pasandolle o codigo dunha fila amose o contido dos seus campos


**************


Que debemos facer : dende aplicacion java 


	- inserir varios rexistros na taboa mediante o metodo insireProduto creado anteriormente usando sentencias sql standard   
	os rexistros a  inserir son 
 		 p1 , parafusos, 3
		 p2 , cravos , 4
		 p3, tachas, 6

 	- Comprobar dende sqlplus que os rexistros foron creados .


	- actualizar o prezo dun produto mediante o metodo actualizarPre  creado anteriormente . 	
	- comprobar dende sqlplus que dita actualizacion tivo lugar correctamente
	- listar mediante o metodo listaProdutos todos os datos das filas que se atopan na taboa produtos.
	- borrar mediante o metodo borrarFila un producto.
	- amosar mediante o metodo amosarFila os datos dun produto


metodos necesarios para desenvolver esta aplicacion: 
para inserir , borrar ou modificar datos debemos crea previamente un obxecto Statement mediante o metodo
createStatement() do obxecto Connection. despois  en funcion do que queramos facer escoleremos un ou
outro metodo do obxecto statement creado anterirormente  de entre os seguintes:
- inserir : metodo executeUpdate("orde_de_insercion_sql")
- borrar : metodo executeUpdate("orde_de_borrado_sql")
- modificar: metodo executeUpdate("orde_de_modificacion_sql")
- consultar (mediante resulset fordwar_only, read_only (por defecto)): crear un obxesto ResultSet a partir de aplicar o metodo executeQuery("consulta") ao obxecto Statement 

*/
package ej18_BaseRelacionalA;

import ej13_Serializacion2.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class BRA {

    public static String conexion() {

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;

        return url;
    }

    public static ArrayList<Producto> listaProductos() {
        String sql = "Select * from productos";
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            //conexion
            Connection conn = DriverManager.getConnection(conexion());
            //intermediario
            Statement statement = conn.createStatement();
            //resultados
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();

                producto.setCodigo(rs.getString("codigo"));
                producto.setDescripcion(rs.getNString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));

                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }

    public static int insertarProducto(Producto producto) {
        String sql = "insert into productos ('codigo','descripcion','precio') values ('" + producto.getCodigo() + "', '" + producto.getDescripcion() + "', '" + producto.getPrecio() + "')";
        int i = 0;
        try {
            //conexionl
            Connection conn = DriverManager.getConnection(conexion());
            //intermediario
            Statement statement = conn.createStatement();
            //resultados
            i = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BRA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public static int actualizarPrecio(Producto producto, double precioNuevo) {
        String sql = "Update productos set precio='" + precioNuevo + "' where codigo='" + producto.getCodigo() + "'";
        int i = 0;
        try {
            //conexionl
            Connection conn = DriverManager.getConnection(conexion());
            //intermediario
            Statement statement = conn.createStatement();
            //resultados
            i = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BRA.class.getName()).log(Level.SEVERE, null, ex);
        }
        //actualizacion del producto si se realizo el Update
        if (i != 0) {
            producto.setPrecio(precioNuevo);
        }
        return i;
    }

    public static int borrarProducto(Producto producto) {
        String sql = "Delete from productos where codigo='" + producto.getCodigo() + "'";
        int i = 0;
        try {
            //conexionl
            Connection conn = DriverManager.getConnection(conexion());
            //intermediario
            Statement statement = conn.createStatement();
            //resultados
            i = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BRA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;

    }

    public static Producto mostrarProducto(String codigo){
        String sql = "Select * from productos where codigo = '"+codigo+"' ";
        Producto producto = null;
         try {
            //conexionl
            Connection conn = DriverManager.getConnection(conexion());
            //intermediario
            Statement statement = conn.createStatement();
            //resultados
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getString("codigo"));
                producto.setDescripcion(rs.getNString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BRA.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return producto;
        
    }
   
    public static void main(String[] args) {
       /*
        Producto p1 = new Producto("c1","p1",1.5);
        Producto p2 = new Producto("c2","p2",2.5);
        Producto p3 = new Producto("c3","p3",3.5);
        
        insertarProducto(p1);
        insertarProducto(p2); 
        insertarProducto(p3);
        */
        for (Producto producto : listaProductos()){
            System.out.println(producto.toString());
        }
        
        System.out.println(listaProductos().size());
    }
    
}
