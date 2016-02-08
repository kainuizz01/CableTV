package th.co.aware.Dao;

import java.util.List;
import th.co.aware.model.PackageService;

public interface PackageDAO {
	
	public void register(PackageService pack);
	
	public void delete(PackageService pack);

	public List<PackageService> findAll();
}


