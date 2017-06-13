package com.jz.xd.model.ext;

import com.jz.xd.model.TbRProductStock;
import com.jz.xd.model.TbSysProduct;

/**
 * Created by HARU on 2017/5/9.
 */
public class ProductStock extends TbSysProduct{
    private TbRProductStock tbRProductStock;

    public TbRProductStock getTbRProductStock() {
        return tbRProductStock;
    }

    public void setTbRProductStock(TbRProductStock tbRProductStock) {
        this.tbRProductStock = tbRProductStock;
    }
}
