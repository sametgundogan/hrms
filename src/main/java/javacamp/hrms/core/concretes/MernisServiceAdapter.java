package javacamp.hrms.core.concretes;

import javacamp.hrms.core.abstracts.JobSeekerCheckService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements JobSeekerCheckService {

	@Override
	public boolean ifRealPerson(String tcId, String name, String lastName, int birthYear) {

		KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
		
		try {
			boolean isReal = kpsPublic.TCKimlikNoDogrula(Long.parseLong(tcId), name.toUpperCase(),lastName.toUpperCase(),Integer.parseInt(null, birthYear));
			if(!isReal) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
