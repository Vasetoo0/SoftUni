package softuni.workshop.data.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeRootDto {

    @XmlElement(name = "employee")
    private Set<EmployeeDto> employees;

    public EmployeeRootDto() {
    }

    public Set<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDto> employees) {
        this.employees = employees;
    }
}
