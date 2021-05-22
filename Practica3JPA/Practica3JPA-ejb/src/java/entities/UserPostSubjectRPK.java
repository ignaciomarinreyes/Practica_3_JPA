/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ignacio
 */
@Embeddable
public class UserPostSubjectRPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTID")
    private int postid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECTID")
    private int subjectid;

    public UserPostSubjectRPK() {
    }

    public UserPostSubjectRPK(int userid, int postid, int subjectid) {
        this.userid = userid;
        this.postid = postid;
        this.subjectid = subjectid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) postid;
        hash += (int) subjectid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPostSubjectRPK)) {
            return false;
        }
        UserPostSubjectRPK other = (UserPostSubjectRPK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.postid != other.postid) {
            return false;
        }
        if (this.subjectid != other.subjectid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserPostSubjectRPK[ userid=" + userid + ", postid=" + postid + ", subjectid=" + subjectid + " ]";
    }
    
}
