

import java.io.*;
import com.aspose.words.*;         //引入aspose-words-15.8.0-jdk16.jar包

public class Doc2Pdf {

    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream in = Doc2Pdf.class.getResourceAsStream("./license.xml");
                       License aposeLic = new License();
            aposeLic.setLicense(in);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param fromPath 批量转哪个目录下的文档
     * @param outPath　生成到哪个目录下面
     */
    public static void doc2pdf(String fromPath,String outPath) {

        if (!getLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath);  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(fromPath);                    //Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}