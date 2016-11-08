package petitions;

import java.io.Serializable;

public class CommentPetition implements Serializable {
	private double publicationId;
	private static final long serialVersionUID = 6L;

	public CommentPetition(double publicationId) {
		this.publicationId = publicationId;
	}

	public double getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(double publicationId) {
		this.publicationId = publicationId;
	}
}
