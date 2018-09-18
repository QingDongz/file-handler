package cn.summerwaves.main;

import cn.summerwaves.dao.FileMapper;
import cn.summerwaves.model.File;
import cn.summerwaves.model.FileExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MainApp {
    private static FileMapper fileMapper;

    public static void main(String[] args) {
        //使用spring+mybatis操作数据库
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        fileMapper = (FileMapper) context.getBean("fileMapper");

        //使用最新的JAVA1.7 NIO 操作文件
        Path listDir = Paths.get("D:\\file");
        ListTree walk = new ListTree();
        walk.setFileMapper(fileMapper);
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        try {
            //遍历文件
            Files.walkFileTree(listDir, opts, Integer.MAX_VALUE, walk);

        } catch (IOException e) {
            System.err.println(e);
        }

    }


}

class ListTree extends SimpleFileVisitor<Path> {

    /**此文件夹是第一次遍历*/
    private static int IS_FIRST_INSERT = 1;
    /**此文件夹为重复数据，数据库中已存有其路径*/
    private static int IS_REPEAT_FILE = 2;
    /**此文件夹的数据在数据库中存过，但是文件夹之后被更新过*/
    private static int IS_FILE_UPDATE = 3;

    private FileMapper fileMapper;

    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {


        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs)
            throws IOException {
        //跳过总父文件夹
        if ("file".equals(dir.getFileName().toString())) {
            return FileVisitResult.CONTINUE;
        }
        List<File> files = new ArrayList<>(30);

        //文件夹下一共有多少个文件
        int countDirFileNumber = 0;
        //数据库中是否存在文件，若存在，则把个数统计出来
        int fileInDatabase = fileMapper.countByDirSubFileNumber(dir.getFileName().toString());
        //此文件夹下的文件的状态
        int dataStatus;
        //获取文件流，速度极快
        DirectoryStream<Path> entries = Files.newDirectoryStream(dir);
        //如果数据库中不存在此文件夹数据，则判断为第一次存储数据，直接存储
        if (fileInDatabase != 0) {
            //统计文件夹中文件个数
            for (Path path : entries) {
                countDirFileNumber++;
            }
            //如果文件夹中的文件个数和数据库中的此文件夹数据条数相等，则判断此文件夹已被存储过，且未更新
            if (countDirFileNumber == fileInDatabase) {
                dataStatus = IS_REPEAT_FILE;
            } else {
                //若个数不相等，则判断文件夹数据存入过数据库，且更新过
                dataStatus = IS_FILE_UPDATE;
            }
        } else {
            dataStatus = IS_FIRST_INSERT;
        }



        if (dataStatus == IS_FIRST_INSERT || dataStatus == IS_FILE_UPDATE) {
            //如果判断文件更新过，则将原本数据删除
            if (dataStatus == IS_FILE_UPDATE) {
                FileExample fileExample = new FileExample();
                fileExample.createCriteria().andDirEqualTo(dir.toString());
                fileMapper.deleteByExample(fileExample);
            }

            //将数据存入数据库
            DirectoryStream<Path> entries2 = Files.newDirectoryStream(dir);
            int count = 0;
            for (Path path : entries2) {
                File file = new File();
                file.setDir(new String(path.getParent().getFileName().toString().getBytes("utf-8"),"utf-8"));
                file.setFile_name(new String(path.getFileName().toString().getBytes("utf-8"),"utf-8"));
                files.add(file);
                count++;
                //批量提交，调高效率
                if (count % 500 == 0) {
                    fileMapper.batchSave(files);
                    files.clear();
                }
            }
            if (!files.isEmpty()) {
                fileMapper.batchSave(files);
            }

            //如果重复，则跳过此文件夹
        } else if (dataStatus == IS_REPEAT_FILE) {
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }
}