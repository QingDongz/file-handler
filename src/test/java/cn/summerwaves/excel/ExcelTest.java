package cn.summerwaves.excel;

import cn.summerwaves.model.StudentExcel;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ExcelTest {

    @Test
    public void excelTest() throws InvalidFormatException, Excel4JException, IOException {
        String path = "G:\\code\\myproject\\file-handler\\src\\main\\resources\\excel\\学生.xlsx";
        List<StudentExcel> students = ExcelUtils.getInstance().readExcel2Objects(path, StudentExcel.class, 0, 0);
        System.out.println("读取Excel至对象数组(支持类型转换)：");
        for (StudentExcel st : students) {
            System.out.println(st);
        }
    }
}
