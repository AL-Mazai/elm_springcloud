package elm.business.service;


import com.baomidou.mybatisplus.extension.service.IService;
import elm.business.domain.entity.Business;

import java.util.List;

/**
* @author 1
* @description 针对表【business】的数据库操作Service
* @createDate 2023-09-28 11:45:11
*/
public interface BusinessService extends IService<Business> {

    /**
     * 获取商家列表，按订单数量降序排序
     * @param sortWay
     * @return
     */
    List<Business> getAllBusiness(String sortWay);

    /**
     * 根据商家类型获取商家列表
     * @param typeId
     * @return
     */
    List<Business> listById(Integer typeId);

    List<Business> listByName(String businessName);
}
