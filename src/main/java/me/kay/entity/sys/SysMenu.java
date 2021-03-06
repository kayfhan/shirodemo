package me.kay.entity.sys;

import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_permission
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int menuId;
    private int parentMenuId;
    private String menuName;
    private String menuLevel;
    private int menuSeq;
    private String menuUrl;
    private int menuStatus;
    private int permissionIid;

    public SysMenu() {
    }

    public SysMenu(int menuId, int parentMenuId, String menuName, String menuLevel, int menuSeq, String menuUrl, int menuStatus, int permissionIid) {
        this.menuId = menuId;
        this.parentMenuId = parentMenuId;
        this.menuName = menuName;
        this.menuLevel = menuLevel;
        this.menuSeq = menuSeq;
        this.menuUrl = menuUrl;
        this.menuStatus = menuStatus;
        this.permissionIid = permissionIid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(int parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public int getMenuSeq() {
        return menuSeq;
    }

    public void setMenuSeq(int menuSeq) {
        this.menuSeq = menuSeq;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(int menuStatus) {
        this.menuStatus = menuStatus;
    }

    public int getPermissionIid() {
        return permissionIid;
    }

    public void setPermissionIid(int permissionIid) {
        this.permissionIid = permissionIid;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuId=" + menuId +
                ", parentMenuId=" + parentMenuId +
                ", menuName='" + menuName + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuSeq=" + menuSeq +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuStatus=" + menuStatus +
                ", permissionIid=" + permissionIid +
                '}';
    }
}