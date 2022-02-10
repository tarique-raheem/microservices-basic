package ae.etisalat.ecare.transaction.history.persistence;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id @GeneratedValue
    private int id;

    @Version
    private int version;

    private String author;
    private String content;

    public ReviewEntity() {
    }

    public ReviewEntity(int productId, int reviewId, String author, String subject, String content) {
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
