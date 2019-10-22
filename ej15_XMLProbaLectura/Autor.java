package ej15_XMLProbaLectura;

public class Autor {
    
    public String nombre;
    public String codigo;
    public String titulo1;
    public String titulo2;
    
        public Autor(){
            
        }

        public Autor(String nombre, String codigo, String titulo1, String titulo2) {
            this.nombre = nombre;
            this.codigo = codigo;
            this.titulo1 = titulo1;
            this.titulo2 = titulo2;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getTitulo1() {
            return titulo1;
        }

        public void setTitulo1(String titulo1) {
            this.titulo1 = titulo1;
        }

        public String getTitulo2() {
            return titulo2;
        }

        public void setTitulo2(String titulo2) {
            this.titulo2 = titulo2;
        }

        @Override
        public String toString() {
            return "Autores{" + "nombre=" + nombre + ", codigo=" + codigo + ", titulo1=" + titulo1 + ", titulo2=" + titulo2 + '}';
        }
    
}
