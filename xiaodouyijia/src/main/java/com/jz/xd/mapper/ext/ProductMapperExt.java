package com.jz.xd.mapper.ext;

import com.jz.xd.model.TbSysProduct;
import com.jz.xd.model.ext.CourseExt;
import com.jz.xd.model.ext.OrderItem;
import com.jz.xd.model.ext.ProductStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/4/28.
 */
public interface ProductMapperExt {
    List<ProductStock> getProductJoinFun(@Param("state") Integer state, @Param("number") Integer number, @Param("size") Integer size);

    TbSysProduct getProductByPid(@Param("pid") Integer pid);

    List<OrderItem> getItems(@Param("oid") Integer oid);

    List<ProductStock> getCourseWithStock(@Param("kind") String kind, @Param("month") String month, @Param("age") String age);

    List<CourseExt> getMaterials(@Param("oid") Integer oid);
}
