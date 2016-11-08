package petitions;

import java.io.Serializable;


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
