package elm.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import elm.back.domain.entity.Business;
import elm.back.domain.entity.BusinessType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (BusinessType)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-11 17:00:22
 */
public interface BusinessTypeMapper {


    @Select("select * from business_type where delTag=0")
    List<BusinessType> getAllBusinessType();

    @Select("select * from business where business_type_id=#{typeId}")
    List<Business> getBusinessListByType(Integer typeId);

//    @Update("UPDATE business_type_idiness SET business_name=#{businessName}, business_address=#{businessAddress}, business_introduction=#{businessIntroduction}, business_img=#{businessImg}, business_type_id=#{businessTypeId}, star_price=#{starPrice}, delivery_price=#{deliveryPrice}, remarks=#{remarks}, order_num=#{orderNum}, stars=#{stars} WHERE business_id=#{businessId}")
    int updateBusinessInfo(Business business);
}

