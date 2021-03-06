package items;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * los items contienen solo la informaci�n de cada publicaci�n. los nombres de
 * las variables son lo sufientemente claros para saber que se est� almacenando
 *
 * @author
 */

public class Comment_Item implements Serializable {
    private String commentId;
    private String content;
    private String nameUser;
    private int publicationID;
    private static final long serialVersionUID = 10L;
    int timePublication;
    // estos guardaron los archivos que se agregan al comentario, en caso de que
    // los publiquen,por supuesto
    ArrayList<File> files;
    int thanks;

    public Comment_Item(int publicationID, String nameUser, String content) {
        this.nameUser = nameUser;
        this.content = content;
        this.publicationID= publicationID;

    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTimePublication() {
        return timePublication;
    }

    public void setTimePublication(int timePublication) {
        this.timePublication = timePublication;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public int getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

}
