package com.sixdog.xiaodong.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVUtil {

	public static char separator = ',';
	public static String filePath = "src/main/resources/sayInfo.csv";
    public static void main(String[] args) throws Exception {
        // 测试导出
        String filePath = "src/main/resources/sayInfo.csv";
        //添加标题
        String[] dataList = new String[]{"No.", "标题", "内容"};
//        for (int i = 0; i < 10; i++) {
//            dataList.add(new String[]{"2010000" + i, "张三" + i, "8" + i});
//        }
        createCSV(dataList);

        // 读取CSV文件
        readCSV(filePath);
    }

    /**
     * 读取CSV文件
     * @param filePath:全路径名
     */
    public static List<String[]> readCSV(String filePath) throws Exception {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));

            // 读取表头
            reader.readHeaders();
            String[] headArray = reader.getHeaders();//获取标题
            System.out.println(headArray[0] + headArray[1] + headArray[2]);

            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                // 读一整行
                System.out.println(reader.getRawRecord());
                // 读这行的第一列
                System.out.println(reader.get("学号"));
                // 读这行的第二列
                System.out.println(reader.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }

    /**
     * 生成CSV文件
     * @param dataList:数据集
     * @param filePath:全路径名
     */
    public static boolean createCSV(String[] data) throws Exception {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath, true);
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            writer = new CsvWriter(out, separator, Charset.forName("UTF-8"));
            writer.writeRecord(data);
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }
}
