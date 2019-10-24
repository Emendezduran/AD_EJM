package ej13_Serializacion2;

import java.io.Serializable;

public class Producto implements Serializable{
    
    private String codigo;
    private String descripcion;
    private double precio;
    
    public Producto(){
        codigo = null;
        descripcion = null;
        precio = 0;
    }
    
    public Producto(String codigo, String descripcion, double precio){
        
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
