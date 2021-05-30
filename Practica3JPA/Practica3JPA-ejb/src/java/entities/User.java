/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ignacio
 */
@Entity
@Table(name = "USER_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByNickname", query = "SELECT u FROM User u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SURNAME")
    private String surname;
    @ManyToMany(mappedBy = "userCollectionLike")
    private ArrayList<Post> postCollectionLike;
    @ManyToMany(mappedBy = "userFollowedCollection")
    private Collection<Subject> subjectFollowedCollection;
    @ManyToMany(mappedBy = "userCollectionFavourite")
    private ArrayList<Post> postCollectionFavourite;
    @JoinColumn(name = "ADDRESS", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Address address;
    @JoinColumn(name = "DEGREE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Degree degree;
    @JoinColumn(name = "ROL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "UNIVERSITY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private University university;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Post> myPostsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Subject> subjectCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Comment> commentCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public void addSubjectFollowedCollection(Subject subject) {
        if (subjectFollowedCollection == null) {
            subjectFollowedCollection = new ArrayList<Subject>();
        }
        subjectFollowedCollection.add(subject);
    }

    public void addPostCollectionFavourite(Post post) {
        if (postCollectionFavourite == null) {
            postCollectionFavourite = new ArrayList<Post>();
        }
        postCollectionFavourite.add(post);
    }

    public void addPostCollectionLike(Post post) {
        if (postCollectionLike == null) {
            postCollectionLike = new ArrayList<Post>();
        }
        postCollectionLike.add(post);
    }

    public Collection<Post> getPostCollectionFavourite() {
        return postCollectionFavourite;
    }

    public void addUserPostSubjectPublicationrelationCollection(UserPostSubjectPublicationrelation userPostSubjectPublicationrelation) {
        if (userPostSubjectPublicationrelationCollection == null) {
            userPostSubjectPublicationrelationCollection = new ArrayList<UserPostSubjectPublicationrelation>();
        }
        userPostSubjectPublicationrelationCollection.add(userPostSubjectPublicationrelation);
    }

    public void addMyPostsCollection(Post post) {
        if (myPostsCollection == null) {
            myPostsCollection = new ArrayList<Post>();
        }
        myPostsCollection.add(post);
    }

    public User(Integer id, String nickname, String password, String name, String surname) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollectionLike;
    }

    public void setPostCollection(ArrayList<Post> postCollection) {
        this.postCollectionLike = postCollection;
    }

    @XmlTransient
    public Collection<Subject> getFollowedSubjects() {
        return subjectFollowedCollection;
    }

    public void setFollowedSubject(Collection<Subject> subjectCollection) {
        this.subjectFollowedCollection = subjectCollection;
    }

    @XmlTransient
    public Collection<Post> getPostCollection1() {
        return postCollectionFavourite;
    }

    public void setPostCollection1(ArrayList<Post> postCollection1) {
        this.postCollectionFavourite = postCollection1;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @XmlTransient
    public Collection<UserPostSubjectPublicationrelation> getUserPostSubjectPublicationrelationCollection() {
        return userPostSubjectPublicationrelationCollection;
    }

    public void setUserPostSubjectPublicationrelationCollection(Collection<UserPostSubjectPublicationrelation> userPostSubjectPublicationrelationCollection) {
        this.userPostSubjectPublicationrelationCollection = userPostSubjectPublicationrelationCollection;
    }

    @XmlTransient
    public Collection<Post> getPostCollection2() {
        return myPostsCollection;
    }

    public void setPostCollection2(Collection<Post> postCollection2) {
        this.myPostsCollection = postCollection2;
    }

    @XmlTransient
    public Collection<Subject> getSubjectCollection1() {
        return subjectCollection1;
    }

    public void setSubjectCollection1(Collection<Subject> subjectCollection1) {
        this.subjectCollection1 = subjectCollection1;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
    }

    public void unfollowSubject(Integer idSubjectUnfollow) {
        Iterator iterator = subjectFollowedCollection.iterator();
        while (iterator.hasNext()) {
            Subject subject = (Subject) iterator.next();
            if (subject.getId().intValue() == idSubjectUnfollow.intValue()) {
                iterator.remove();
            }
        }
    }

    public void removeLastPostCollectionFavourite() {
        postCollectionFavourite.remove(postCollectionFavourite.size() - 1);
    }

    public void removeLastPostCollectionLike() {
        postCollectionLike.remove(postCollectionLike.size() - 1);
    }

}
