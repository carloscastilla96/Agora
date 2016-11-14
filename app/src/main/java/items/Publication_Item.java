package items;

import red.User;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * los items contienen solo la informaci�n de cada publicaci�n. los nombres de
 * las variables son lo sufientemente claros para saber que se est� almacenando
 *
 */

public class Publication_Item implements Serializable {
    int id;
    String tittle, catagorie, subCategorie, description, city;
    String name, lastName;
    ArrayList<ProfessionalRequired> professionalsRequired;
    ArrayList<ProfessionalRequired> professionalsObtained;
    String address, number, email, webAddres;
    byte[] bytesImagen= null;
    String nombreImagen= null;


    private static final long serialVersionUID = 4L;

    public Publication_Item(int id,String name, String lastName, String tittle, String catagorie, String subCategorie, String description) {
        this.id= id;
        this.name = name;
        this.lastName = lastName;
        this.tittle = tittle;
        this.catagorie = catagorie;
        this.subCategorie = subCategorie;
        this.description = description;
    }

    public void setBytesImagen(byte[] bytesImagen) {
        this.bytesImagen = bytesImagen;
    }

    public byte[] getBytesImagen() {
        return bytesImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public void needed(ArrayList<ProfessionalRequired> professionalRequired, ArrayList<ProfessionalRequired> professionalsObtained, String address, String number, String email, String webAddres) {
        this.professionalsObtained = professionalsObtained;
        this.professionalsRequired = professionalRequired;
        this.address = address;
        this.number = number;
        this.email = email;
        this.webAddres = webAddres;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ArrayList<ProfessionalRequired> getProfessionalsObtained() {
        return professionalsObtained;
    }

    public ArrayList<ProfessionalRequired> getProfessionalsRequired() {
        return professionalsRequired;
    }

    public String getAddress() {
        return address;
    }

    public String getCatagorie() {
        return catagorie;
    }

    public String getNumber() {
        return number;
    }

    public String getSubCategorie() {
        return subCategorie;
    }

    public String getTittle() {
        return tittle;
    }

    public String getWebAddres() {
        return webAddres;
    }


    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}