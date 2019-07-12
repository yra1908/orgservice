package pinc.org.service.orgservice.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Role {

    UBER("uber", 1),
    ADMIN("admin", 2),
    PO_ADMIN("po-admin", 3),
    MANAGER("manager", 4),
    CARE_MANAGER("care-manager", 5),
    PROVIDER("provider", 6);

    private final String name;
    private final int id;

    private static Map<Role, List<Privilege>> roleToPrivilege = new HashMap<>();
    static {
        //provider role
        List<Privilege> providerPrivrileges = new ArrayList<>();
        providerPrivrileges.add(new Privilege("read_patient"));
        providerPrivrileges.add(new Privilege("edit_patient"));
        roleToPrivilege.put(Role.PROVIDER, providerPrivrileges);
    }

    Role(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static List<Privilege> getPrivilegesByRoleId(Integer roleId){
        return roleToPrivilege.get(getRoleById(roleId));
    }

    private static Role getRoleById(Integer id){
        for (Role role : Role.values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role with Id : " + id);
    }
}
