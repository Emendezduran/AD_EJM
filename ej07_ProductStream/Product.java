package ej07_ProductStream;

public class Product{
    
    private String codigo;
    private String descripcion;
    private int precio;
    
    public Product(){
        codigo = null;
        descripcion = null;
        precio = 0;
    }
    
    public Product(String codigo, String descripcion, int precio){
        
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

    public int getPrecio() {
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
