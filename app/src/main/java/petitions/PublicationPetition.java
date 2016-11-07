package petitions;

import java.io.Serializable;

/**
 * Las peticiones contienen solo el id que identifica que objeto en especifico
 * desea el dispositivo movil.
 * 
 * @author Andres
 *
 */
public class PublicationPetition implements Serializable{
    
    private String Id;
	private static final long serialVersionUID = 3L;

    public PublicationPetition(String subjectid) {
        this.Id = subjectid;
    }
    public String getId() {
        return Id;
    }
}
