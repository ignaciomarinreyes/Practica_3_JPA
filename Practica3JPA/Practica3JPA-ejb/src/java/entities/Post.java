/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ignacio
 */
@Entity
@Table(name = "POST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id"),
    @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title"),
    @NamedQuery(name = "Post.findByDate", query = "SELECT p FROM Post p WHERE p.date = :date"),
    @NamedQuery(name = "Post.findByContent", query = "SELECT p FROM Post p WHERE p.content = :content"),
    @NamedQuery(name = "Post.findByPathimage", query = "SELECT p FROM Post p WHERE p.pathimage = :pathimage")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 250)
    @Column(name = "CONTENT")
    private String content;
    @Size(max = 30)
    @Column(name = "PATHIMAGE")
    private String pathimage;
    @JoinTable(name = "USER_POST_LIKEDRELATION", joinColumns = {
        @JoinColumn(name = "POSTID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<User> userCollectionLike;
    @JoinTable(name = "USER_POST_FAVOURITERELATION", joinColumns = {
        @JoinColumn(name = "POSTID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "ID")})
    @ManyToMany
    private ArrayList<User> userCollectionFavourite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Collection<UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection;
    @JoinColumn(name = "SUBJECT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "USER_", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Collection<Comment> commentCollection;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }
    
    public void addUserCollectionFavourite(User user){
        if(userCollectionFavourite == null){
            userCollectionFavourite = new ArrayList<User>();
        }
        userCollectionFavourite.add(user);
    }

    public void addUserPostSubjectPublicationrelationCollection(UserPostSubjectPublicationrelation userPostSubjectPublicationrelation) {
        if (userPostSubjectPublicationrelationCollection == null) {
            userPostSubjectPublicationrelationCollection = new ArrayList<UserPostSubjectPublicationrelation>();
        }
        userPostSubjectPublicationrelationCollection.add(userPostSubjectPublicationrelation);
    }

    public Post(String title, Timestamp date, String content, String pathimage, Subject subject, User user) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.pathimage = pathimage;
        this.subject = subject;
        this.user = user;
    }

    public Post(Integer id, String title, Timestamp date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPathimage() {
        return pathimage;
    }

    public void setPathimage(String pathimage) {
        this.pathimage = pathimage;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollectionLike;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollectionLike = userCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection1() {
        return userCollectionFavourite;
    }

    public void setUserCollection1(ArrayList<User> userCollection1) {
        this.userCollectionFavourite = userCollection1;
    }

    @XmlTransient
    public Collection<UserPostSubjectPublicationrelation> getUserPostSubjectPublicationrelationCollection() {
        return userPostSubjectPublicationrelationCollection;
    }

    public void setUserPostSubjectPublicationrelationCollection(Collection<UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection) {
        this.userPostSubjectPublicationrelationCollection = userPostSubjectPublicationrelationCollection;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Post[ id=" + id + " ]";
    }

    public void removeLastUserCollectionFavourite() {
        userCollectionFavourite.remove(userCollectionFavourite.size() - 1);
    }

}
