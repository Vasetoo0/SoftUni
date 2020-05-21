package softuni.workshop.data.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyRootDto {

    @XmlElement(name = "company")
    private Set<CompanyDto> companies;

    public CompanyRootDto() {
    }

    public Set<CompanyDto> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompanyDto> companies) {
        this.companies = companies;
    }
}
