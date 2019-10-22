package ejercicio13;

import java.io.Serializable;

public class Productos implements Serializable{
    
    private String codigo;
    private String descripcion;
    private double precio;
    
    public Productos(){
        codigo = null;
        descripcion = null;
        precio = 0;
    }
    
    public Productos(String codigo, String descripcion, double precio){
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Product{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
        
}
