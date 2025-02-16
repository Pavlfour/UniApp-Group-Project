package uniapp.utils;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "UNIVERSITY")
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :name"),
    @NamedQuery(name = "University.findByCurrentName", query = "SELECT u FROM University u WHERE u.currentName = :currentName"),
    @NamedQuery(name = "University.findByDomain", query = "SELECT u FROM University u WHERE u.domain = :domain"),
    @NamedQuery(name = "University.findByUrl", query = "SELECT u FROM University u WHERE u.url = :url"),
    @NamedQuery(name = "University.findByStateProvince", query = "SELECT u FROM University u WHERE u.stateProvince = :stateProvince"),
    @NamedQuery(name = "University.findByContact", query = "SELECT u FROM University u WHERE u.contact = :contact"),
    @NamedQuery(name = "University.findBySchools", query = "SELECT u FROM University u WHERE u.schools = :schools"),
    @NamedQuery(name = "University.findBySearches", query = "SELECT u FROM University u WHERE u.searches = :searches")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "CURRENT_NAME")
    private String currentName;
    @Column(name = "DOMAIN")
    private String domain;
    @Column(name = "URL")
    private String url;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "SCHOOLS")
    private String schools;
    @Column(name = "SEARCHES")
    private Integer searches;
    @JoinColumn(name = "COUNTRY_NAME", referencedColumnName = "NAME")
    @ManyToOne(optional = false)
    private Country countryName;

    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public University(String name, String currentName) {
        this.name = name;
        this.currentName = currentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    public Integer getSearches() {
        return searches;
    }

    public void setSearches(Integer searches) {
        this.searches = searches;
    }

    public Country getCountryName() {
        return countryName;
    }

    public void setCountryName(Country countryName) {
        this.countryName = countryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    // Method to increment searches
    public void incrementSearches() {
        this.searches++;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uniapp.utils.University[ name=" + name + " ]";
    }

}
