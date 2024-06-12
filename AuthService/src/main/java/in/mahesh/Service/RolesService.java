package in.mahesh.Service;

import java.util.List;

import in.mahesh.entity.Roles;

public interface RolesService {
	
	public Roles createRoles(Roles roles);
	
	public Roles getRolesById(Integer rolesId);
	
	public List<Roles> getAllRoles();
	
	public Roles delRolesById(Integer rolesId);

}
