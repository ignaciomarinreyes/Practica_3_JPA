/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ignacio
 */
@Entity
@Table(name = "USER_POST_SUBJECT_PUBLICATIONRELATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPostSubjectPublicationrelation.findAll", query = "SELECT u FROM UserPostSubjectPublicationrelation u"),
    @NamedQuery(name = "UserPostSubjectPublicationrelation.findByUserid", query = "SELECT u FROM UserPostSubjectPublicationrelation u WHERE u.userPostSubjectPublicationrelationPK.userid = :userid"),
    @NamedQuery(name = "UserPostSubjectPublicationrelation.findByPostid", query = "SELECT u FROM UserPostSubjectPublicationrelation u WHERE u.userPostSubjectPublicationrelationPK.postid = :postid"),
    @NamedQuery(name = "UserPostSubjectPublicationrelation.findBySubjectid", query = "SELECT u FROM UserPostSubjectPublicationrelation u WHERE u.userPostSubjectPublicationrelationPK.subjectid = :subjectid")})
public class UserPostSubjectPublicationrelation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPostSubjectPublicationrelationPK userPostSubjectPublicationrelationPK;
    @JoinColumn(name = "POSTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Post post;
    @JoinColumn(name = "SUBJECTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserPostSubjectPublicationrelation() {
    }

    public UserPostSubjectPublicationrelation(Post post, Subject subject, User user, UserPostSubjectPublicationrelationPK userPostSubjectPublicationrelationPK) {
        this.post = post;
        this.subject = subject;
        this.user = user;
        this.userPostSubjectPublicationrelationPK = userPostSubjectPublicationrelationPK;
    }

    public UserPostSubjectPublicationrelation(UserPostSubjectPublicationrelationPK userPostSubjectPublicationrelationPK) {
        this.userPostSubjectPublicationrelationPK = userPostSubjectPublicationrelationPK;
    }

    public UserPostSubjectPublicationrelation(int userid, int postid, int subjectid) {
        this.userPostSubjectPublicationrelationPK = new UserPostSubjectPublicationrelationPK(userid, postid, subjectid);
    }

    public UserPostSubjectPublicationrelationPK getUserPostSubjectPublicationrelationPK() {
        return userPostSubjectPublicationrelationPK;
    }

    public void setUserPostSubjectPublicationrelationPK(UserPostSubjectPublicationrelationPK userPostSubjectPublicationrelationPK) {
        this.userPostSubjectPublicationrelationPK = userPostSubjectPublicationrelationPK;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPostSubjectPublicationrelationPK != null ? userPostSubjectPublicationrelationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPostSubjectPublicationrelation)) {
            return false;
        }
        UserPostSubjectPublicationrelation other = (UserPostSubjectPublicationrelation) object;
        if ((this.userPostSubjectPublicationrelationPK == null && other.userPostSubjectPublicationrelationPK != null) || (this.userPostSubjectPublicationrelationPK != null && !this.userPostSubjectPublicationrelationPK.equals(other.userPostSubjectPublicationrelationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserPostSubjectPublicationrelation[ userPostSubjectPublicationrelationPK=" + userPostSubjectPublicationrelationPK + " ]";
    }
    
}
