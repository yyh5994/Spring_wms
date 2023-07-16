package com.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * 
 * @TableName goods
 */
public class Goods implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 货名
     */
    private String name;

    /**
     * 仓库
     */
    private Integer storage;

    /**
     * 分类
     */
    private Integer goodstype;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 货名
     */
    public String getName() {
        return name;
    }

    /**
     * 货名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 仓库
     */
    public Integer getStorage() {
        return storage;
    }

    /**
     * 仓库
     */
    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    /**
     * 分类
     */
    public Integer getGoodstype() {
        return goodstype;
    }

    /**
     * 分类
     */
    public void setGoodstype(Integer goodstype) {
        this.goodstype = goodstype;
    }

    /**
     * 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStorage() == null ? other.getStorage() == null : this.getStorage().equals(other.getStorage()))
            && (this.getGoodstype() == null ? other.getGoodstype() == null : this.getGoodstype().equals(other.getGoodstype()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStorage() == null) ? 0 : getStorage().hashCode());
        result = prime * result + ((getGoodstype() == null) ? 0 : getGoodstype().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", storage=").append(storage);
        sb.append(", goodstype=").append(goodstype);
        sb.append(", count=").append(count);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}