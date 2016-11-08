package petitions;

import java.io.Serializable;


public class PublicationPetition implements Serializable{
    
    private String Id;
	private static final long serialVersionUID = 3L;

    public PublicationPetition(String userID) {
        this.Id = userID;
    }
    public String getId() {
        return Id;
    }
}
