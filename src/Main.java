import java.io.File;

/**
 * @Author wenjun
 * @Date 2020/10/29
 * @Description
 */
public class Main {
    //使用时只需将下面路径替换掉即可
    public static void main(String[] args) {
        //单个文件转
        Doc2Pdf.doc2pdf("/data/opt/workspace/2020/10/29/需求.docx","/data/opt/workspace/2020/10/29/需求.pdf");
        //批量转
        doc2PdfBatch("/data/opt/workspace/2020/10/29/拆分/","/data/opt/workspace/2020/10/31/");

    }

    /**
     *
     * @param fromDir 批量转哪个目录下的文档
     * @param outDir　生成到哪个目录下面
     */
    private static void doc2PdfBatch(String fromDir,String outDir){
        File file = new File(fromDir);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File file1 : files){
                doc2PdfBatch(file1.getAbsolutePath(),outDir);
            }
        }else{
            if(fromDir.endsWith(".docx")||fromDir.endsWith(".doc")){
                File file1 = new File(outDir);
                if(!file1.exists()){
                    file1.mkdirs();
                }
                String fileName = file.getName();
                fileName = fileName.substring(0,fileName.lastIndexOf("."));
                Doc2Pdf.doc2pdf(fromDir,outDir + File.separator + fileName + "pdf");
            }
        }
    }
}
