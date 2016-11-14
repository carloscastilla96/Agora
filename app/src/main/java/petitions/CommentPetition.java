package petitions;

import java.io.Serializable;

public class CommentPetition implements Serializable {
	private int publicationId;
	private static final long serialVersionUID = 6L;

	public CommentPetition(int publicationId) {
		this.publicationId = publicationId;
	}

	public double getPublicationId() {
		return publicationId;
	}
}
