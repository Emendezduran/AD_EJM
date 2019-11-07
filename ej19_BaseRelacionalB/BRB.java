/*
exercicio 19
baserelacionalB
a partir da taboa produtos creada no exerciio anterior e usando un resultset de tipo scrollable, updatable que devolte todas as
filas da taboa , desenvolver catro metodos
que permitan
    - listar o contido completo do resultset
    - actualizar dende dentro do resultet : por exemplo a fila do producto p2 facendo que o seu precio pase a ser 8
    - inserir dende dentro do resultset unha fila de valores : por exemplo o produto  p4, martelo, 20
    - borrar : por exemplo a  fila de codigo p3 tamen dende dentro do resultset
Lembrar que para consultar  con posibilidade de actualizar o resultado do consultado debo usar un obxecto Statement creado cas opcions
 scrollable, updatable , e aplicarlle despois o  metodo executeQuery("consulta") para obter o resultset . E dicir
    Statement statement= conn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
    e despois crear o obxecto ResultSet a partir de aplicar o metodo executeQuery("consulta") a o obxecto Statement anterior
         para inserir un rexistro:
                invocar o metodo moveToInsertRow() do obxecto ResultSet
                introducir valores nos campos do rexistro que queremos inserir
                    usar metodo updateString("nome_campo", valor) do ResultSet ( se e in enteiro sera updateInt("nome_campo", valor) )
                inserir a fila : invocar o metodo insertRow() do obxecto ResultSet
        para actualizar un rexistro:
                unha vez situado nun rexisro do obxecto ResultSet:
                    actualizar un campo: invocar o metodo updateString("nome_campo", valor) do  ResultSet (se e un un enteiro sera :
                    updateInt("nome_campo", valor))
		    a continuación para actualizar a fila que conten os campos actualizados ; invocar o metodo updateRow()
        para borrar un rexistro (sobre o que estamos situados : invocar o metodo deleteRow()
outros metodos deste resultset (scrollable and updatable):
    first() : move o cursor a primeira fila do obxecto ResultSet
    last() : move o cursor a ultima  fila do obxecto ResultSet
    isLast(): retorna un valor verdadeiro se estamos posicionados na ultima fila do obxecto ResultSet
    close()
    next():   move o cursor a proxima  fila do obxecto ResultSet
    previous(): move o cursor a  fila previa a actual do obxecto ResultSet
IMPORTANTE: a consulta de todos os campos dunha fila debe facerse explicitando o nome da tabao antes do * , e decir:  select produtos.* from produtos . . .
 */

package ej19_BaseRelacionalB;

import ej13_Serializacion2.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class BRB {
    
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
    
     public static void mostrarTabla(){
        String sql = "Select productos.* from productos";
        Connection conn = null;
         try { 
            //conexion
            conn = DriverManager.getConnection(conexion());
            //intermediario scrollable, updatable
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultados
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                    System.out.println( rs.getString("Codigo") +" "+ rs.getString("Descripcion") +" "+ rs.getString("Precio") + "\n" ); 
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
              try {
                  conn.close();
              } catch (SQLException ex) {
                  Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
              }
          }        
     }
     
     public static void updatePrecio(String codigo, double precioNuevo){
          String sql = "Select productos.* from productos";
          Connection conn = null;
          try { 
            //conexion
            conn = DriverManager.getConnection(conexion());
            //intermediario scrollable, updatable
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultados
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                if (rs.getString("codigo").equals(codigo)){           
                    rs.updateDouble("precio", precioNuevo);
                    rs.updateRow();
                    System.out.println("Precio Actualizado a "+ Double.toString(precioNuevo));
                }
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
              try {
                  conn.close();
              } catch (SQLException ex) {
                  Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
              }
          }   
     }
     
     public static void insertarFila(Producto producto){
         String sql = "Select productos.* from productos";
          Connection conn = null;
          try { 
            //conexion
            conn = DriverManager.getConnection(conexion());
            //intermediario scrollable, updatable
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultados
            ResultSet rs = statement.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("codigo", producto.getCodigo() );
            rs.updateString("descripcion", producto.getDescripcion() );
            rs.updateDouble("precio", producto.getPrecio());
            rs.insertRow();
            rs.close();
              System.out.println("fila insertada: " + producto.toString());
        } catch (SQLException ex) {
            Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
              try {
                  conn.close();
              } catch (SQLException ex) {
                  Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
              }
          }   
         
     }
     
     public static void borrarFila(String codigo){
         String sql = "Select productos.* from productos";
          Connection conn = null;
          try { 
            //conexion
            conn = DriverManager.getConnection(conexion());
            //intermediario scrollable, updatable
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultados
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("codigo").equals(codigo)){           
                    rs.deleteRow();
                    System.out.println("Fila eliminada ");
                    break;
                }                    
            }
            rs.close();    
        } catch (SQLException ex) {
            Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
              try {
                  conn.close();
              } catch (SQLException ex) {
                  Logger.getLogger(BRB.class.getName()).log(Level.SEVERE, null, ex);
              }
          }           
     }
    
    
    public static void main(String[] args) {
        
        mostrarTabla();
        updatePrecio("c2",8);
        mostrarTabla();
        Producto producto = new Producto("c3","p3", 4);
        insertarFila(producto);
        mostrarTabla();
        borrarFila("c3");
        mostrarTabla();
        
    }
}
