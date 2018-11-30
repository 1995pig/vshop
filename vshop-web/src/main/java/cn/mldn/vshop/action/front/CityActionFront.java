package cn.mldn.vshop.action.front;

import cn.mldn.util.factory.Factory;
import cn.mldn.vshop.service.front.ICityServiceFront;
import cn.mldn.vshop.util.action.AbstractBaseAction;
import net.sf.json.JSONObject;

public class CityActionFront extends AbstractBaseAction {
	private ICityServiceFront cityService = Factory.getServiceInstance("city.service.front");
	public void list(int pid) throws Exception{
		JSONObject obj = new JSONObject();
 		obj.put("allCitys", cityService.listByProvince(pid));
		super.print(obj);
 	}
	
}
