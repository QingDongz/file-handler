package cn.summerwaves.dao;

import cn.summerwaves.model.File;
import cn.summerwaves.model.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface FileMapper {
    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    long countByExample(FileExample example);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int deleteByExample(FileExample example);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int insert(File record);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int insertSelective(File record);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    List<File> selectByExample(FileExample example);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    File selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int updateByPrimaryKeySelective(File record);

    /**
     *
     * @mbg.generated Tue Sep 18 15:40:53 CST 2018
     */
    int updateByPrimaryKey(File record);

    int batchSave(@Param("files")List<File> files);

    int countByDirSubFileNumber(@Param("dir") String dir);


}