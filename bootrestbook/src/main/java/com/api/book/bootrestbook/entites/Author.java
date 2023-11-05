package com.api.book.bootrestbook.entites;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    @Column(name= "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String language;
    
    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
   
    public Author(int authorId, String firstName, String lastName, String language) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public Author() {
    
    }
    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
                + language + "]";
    }

    

}
