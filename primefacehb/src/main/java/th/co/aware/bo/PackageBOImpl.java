package th.co.aware.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.aware.Dao.PackageDAO;
import th.co.aware.model.PackageService;

@Service("PackageBOImpl")
@Transactional(readOnly = false)
public class PackageBOImpl implements PackageBO {

	@Autowired
	private PackageDAO packDAO;
	
	
	@Transactional(readOnly = false)
	public void register(PackageService pack) {
		packDAO.register(pack);

	}
	@Transactional
	public List<PackageService> findAll() {
		// TODO Auto-generated method stub
		return packDAO.findAll();
	}
	public void delete(PackageService pack) throws Exception {
		if(pack == null || pack.getPackageId() == 0){
			throw  new Exception("Not value id");
		}else{
			packDAO.delete(pack);
		}
		
	}

}
