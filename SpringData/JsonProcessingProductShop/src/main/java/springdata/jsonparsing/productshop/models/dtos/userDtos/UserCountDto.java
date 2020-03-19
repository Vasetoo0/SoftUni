package springdata.jsonparsing.productshop.models.dtos.userDtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserCountDto {

    @Expose
    private int usersCount;
    @Expose
    private Set<UserProductsSoldDto> users;

    public UserCountDto() {
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserProductsSoldDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserProductsSoldDto> users) {
        this.users = users;
    }
}
