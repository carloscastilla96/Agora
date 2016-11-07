package items;

import java.io.Serializable;

/**
 * Created by andre on 11/6/2016.
 */
public class ProfessionalRequired implements Serializable{
    String career, description;


    public ProfessionalRequired(String career, String description){
        this.description= description;
        this.career= career;
    }

    public String getCareer() {
        return career;
    }

    public String getDescription() {
        return description;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
