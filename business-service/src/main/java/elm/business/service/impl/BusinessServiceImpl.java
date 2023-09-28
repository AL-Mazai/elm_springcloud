package elm.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import elm.business.domain.entity.Business;
import elm.business.mapper.BusinessMapper;
import elm.business.service.BusinessService;
import org.springframework.stereotype.Service;

@Service("businessService")
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

}
