package com.example.agenda_sqlite;

public class CursosModelos {

    private String nombre,telefono,correo;

    public CursosModelos(){

     }
public CursosModelos(String nombre,String telefono,String correo){
        this.nombre=nombre;
        this.telefono=telefono;
        this.correo=correo;

}

public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    public String getTelefono(){return telefono;}
    public void setTelefono(String telefono){this.telefono=telefono;}

    public String getCorreo(){return correo;}
    public void setCorreo(String correo){this.correo=correo;}


}
