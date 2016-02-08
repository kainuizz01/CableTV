package th.co.aware.bo;

import java.util.List;
import th.co.aware.model.PackageService;


public interface PackageBO {
	
	public void register(PackageService pack);
	
	public void delete(PackageService pack) throws Exception;
	
	public List<PackageService> findAll();
}
