package cn.summerwaves.model;

import java.io.Serializable;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class File implements Serializable {
    /**
     *
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    private Long id;

    /**
     *
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    private String dir;

    /**
     *
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    private String file_name;

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column tb_file.id
     *
     * @return the value of tb_file.id
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public File withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column tb_file.id
     *
     * @param id the value for tb_file.id
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column tb_file.dir
     *
     * @return the value of tb_file.dir
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public String getDir() {
        return dir;
    }

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public File withDir(String dir) {
        this.setDir(dir);
        return this;
    }

    /**
     * This method sets the value of the database column tb_file.dir
     *
     * @param dir the value for tb_file.dir
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * This method returns the value of the database column tb_file.file_name
     *
     * @return the value of tb_file.file_name
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public String getFile_name() {
        return file_name;
    }

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public File withFile_name(String file_name) {
        this.setFile_name(file_name);
        return this;
    }

    /**
     * This method sets the value of the database column tb_file.file_name
     *
     * @param file_name the value for tb_file.file_name
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dir=").append(dir);
        sb.append(", file_name=").append(file_name);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
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
        File other = (File) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDir() == null ? other.getDir() == null : this.getDir().equals(other.getDir()))
            && (this.getFile_name() == null ? other.getFile_name() == null : this.getFile_name().equals(other.getFile_name()));
    }

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDir() == null) ? 0 : getDir().hashCode());
        result = prime * result + ((getFile_name() == null) ? 0 : getFile_name().hashCode());
        return result;
    }
}