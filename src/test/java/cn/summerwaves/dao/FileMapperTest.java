package cn.summerwaves.dao;

import cn.summerwaves.model.File;
import cn.summerwaves.model.FileExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath:spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FileMapperTest {
    @Resource
    private FileMapper fileMapper;

    @org.junit.Test
    public void insertSelective() {
        File file = new File();
        file.setDir("testDir");
        file.setFile_name("testFileName");
        int success = fileMapper.insertSelective(file);
        System.out.println(success);
    }

    @Test
    public void batchSave() {
        File file = new File();
        file.setDir("testDir3");
        file.setFile_name("testFileName3");
        File file2 = new File();
        file2.setDir("testDir2");
        file2.setFile_name("testFileName2");

        List<File> files = Arrays.asList(file, file2);
        fileMapper.batchSave(files);
    }

    @Test
    public void countByDirSubFileNumber() {
        System.out.println(fileMapper.countByDirSubFileNumber("gdb_pic"));
    }

    @Test
    public void deleteByExample() {
        FileExample fileExample = new FileExample();
        fileExample.createCriteria().andDirEqualTo("gdb_pic");
        fileMapper.deleteByExample(fileExample);
    }

}