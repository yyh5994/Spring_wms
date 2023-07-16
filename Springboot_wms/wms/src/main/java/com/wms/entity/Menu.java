package com.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * 
 * @TableName menu
 */
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单名字
     */
    private String menuName;

    /**
     * 菜单级别
     */
    private String menuLevel;

    /**
     * 菜单的父code
     */
    private String menuParentCode;

    /**
     * 点击触发的函数
     */
    private String menuClick;

    /**
     * 
     */
    private String menuRight;

    /**
     * 
     */
    private String menuComponent;

    /**
     * 
     */
    private String menuIcon;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 菜单编码
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 菜单编码
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 菜单名字
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单名字
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 菜单级别
     */
    public String getMenuLevel() {
        return menuLevel;
    }

    /**
     * 菜单级别
     */
    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 菜单的父code
     */
    public String getMenuParentCode() {
        return menuParentCode;
    }

    /**
     * 菜单的父code
     */
    public void setMenuParentCode(String menuParentCode) {
        this.menuParentCode = menuParentCode;
    }

    /**
     * 点击触发的函数
     */
    public String getMenuClick() {
        return menuClick;
    }

    /**
     * 点击触发的函数
     */
    public void setMenuClick(String menuClick) {
        this.menuClick = menuClick;
    }

    /**
     * 
     */
    public String getMenuRight() {
        return menuRight;
    }

    /**
     * 
     */
    public void setMenuRight(String menuRight) {
        this.menuRight = menuRight;
    }

    /**
     * 
     */
    public String getMenuComponent() {
        return menuComponent;
    }

    /**
     * 
     */
    public void setMenuComponent(String menuComponent) {
        this.menuComponent = menuComponent;
    }

    /**
     * 
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
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
        Menu other = (Menu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuCode() == null ? other.getMenuCode() == null : this.getMenuCode().equals(other.getMenuCode()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuLevel() == null ? other.getMenuLevel() == null : this.getMenuLevel().equals(other.getMenuLevel()))
            && (this.getMenuParentCode() == null ? other.getMenuParentCode() == null : this.getMenuParentCode().equals(other.getMenuParentCode()))
            && (this.getMenuClick() == null ? other.getMenuClick() == null : this.getMenuClick().equals(other.getMenuClick()))
            && (this.getMenuRight() == null ? other.getMenuRight() == null : this.getMenuRight().equals(other.getMenuRight()))
            && (this.getMenuComponent() == null ? other.getMenuComponent() == null : this.getMenuComponent().equals(other.getMenuComponent()))
            && (this.getMenuIcon() == null ? other.getMenuIcon() == null : this.getMenuIcon().equals(other.getMenuIcon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuCode() == null) ? 0 : getMenuCode().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuLevel() == null) ? 0 : getMenuLevel().hashCode());
        result = prime * result + ((getMenuParentCode() == null) ? 0 : getMenuParentCode().hashCode());
        result = prime * result + ((getMenuClick() == null) ? 0 : getMenuClick().hashCode());
        result = prime * result + ((getMenuRight() == null) ? 0 : getMenuRight().hashCode());
        result = prime * result + ((getMenuComponent() == null) ? 0 : getMenuComponent().hashCode());
        result = prime * result + ((getMenuIcon() == null) ? 0 : getMenuIcon().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuCode=").append(menuCode);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuLevel=").append(menuLevel);
        sb.append(", menuParentCode=").append(menuParentCode);
        sb.append(", menuClick=").append(menuClick);
        sb.append(", menuRight=").append(menuRight);
        sb.append(", menuComponent=").append(menuComponent);
        sb.append(", menuIcon=").append(menuIcon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}