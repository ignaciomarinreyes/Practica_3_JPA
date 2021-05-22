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
@Table(name = "USER_POST_SUBJECT_R")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPostSubjectR.findAll", query = "SELECT u FROM UserPostSubjectR u"),
    @NamedQuery(name = "UserPostSubjectR.findByUserid", query = "SELECT u FROM UserPostSubjectR u WHERE u.userPostSubjectRPK.userid = :userid"),
    @NamedQuery(name = "UserPostSubjectR.findByPostid", query = "SELECT u FROM UserPostSubjectR u WHERE u.userPostSubjectRPK.postid = :postid"),
    @NamedQuery(name = "UserPostSubjectR.findBySubjectid", query = "SELECT u FROM UserPostSubjectR u WHERE u.userPostSubjectRPK.subjectid = :subjectid")})
public class UserPostSubjectR implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPostSubjectRPK userPostSubjectRPK;
    @JoinColumn(name = "POSTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Post post;
    @JoinColumn(name = "SUBJECTID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserPostSubjectR() {
    }

    public UserPostSubjectR(UserPostSubjectRPK userPostSubjectRPK) {
        this.userPostSubjectRPK = userPostSubjectRPK;
    }

    public UserPostSubjectR(int userid, int postid, int subjectid) {
        this.userPostSubjectRPK = new UserPostSubjectRPK(userid, postid, subjectid);
    }

    public UserPostSubjectRPK getUserPostSubjectRPK() {
        return userPostSubjectRPK;
    }

    public void setUserPostSubjectRPK(UserPostSubjectRPK userPostSubjectRPK) {
        this.userPostSubjectRPK = userPostSubjectRPK;
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
        hash += (userPostSubjectRPK != null ? userPostSubjectRPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPostSubjectR)) {
            return false;
        }
        UserPostSubjectR other = (UserPostSubjectR) object;
        if ((this.userPostSubjectRPK == null && other.userPostSubjectRPK != null) || (this.userPostSubjectRPK != null && !this.userPostSubjectRPK.equals(other.userPostSubjectRPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserPostSubjectR[ userPostSubjectRPK=" + userPostSubjectRPK + " ]";
    }
    
}
