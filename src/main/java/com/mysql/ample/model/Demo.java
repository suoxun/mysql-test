package com.mysql.ample.model;

import java.io.Serializable;
import javax.persistence.*;

public class Demo implements Serializable {
    @Id
    private Integer id;

    @Column(name = "id_other")
    private Integer idOther;

    private String flag;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return id_other
     */
    public Integer getIdOther() {
        return idOther;
    }

    /**
     * @param idOther
     */
    public void setIdOther(Integer idOther) {
        this.idOther = idOther;
    }

    /**
     * @return flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idOther=").append(idOther);
        sb.append(", flag=").append(flag);
        sb.append("]");
        return sb.toString();
    }
}