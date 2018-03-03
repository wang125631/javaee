package com.wpx.linux.demo03;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastdfsClientTest {
	
	
	public String conf_filename = "D:\\nodejs\\javaee\\java\\com\\wpx\\linux\\demo03\\fdfs_client.conf"; 
   
	public String local_filename = "H:\\profile\\profile.docx"; 

   
    private void saveFile(byte[] b, String path, String fileName) {
  		
    	File file = new File(path+fileName);
    	FileOutputStream fileOutputStream = null;
    	try {
			fileOutputStream= new FileOutputStream(file);
			
			fileOutputStream.write(b);
			
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}finally{
			if(fileOutputStream!=null){
				try {
					fileOutputStream.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
			
		}
  		
  	}
    //上传文件
    @Test 
    public void testUpload() { 
    	
    	

        try { 
            ClientGlobal.init(conf_filename); 

            TrackerClient tracker = new TrackerClient(); 
            TrackerServer trackerServer = tracker.getConnection(); 
            StorageServer storageServer = null; 

            StorageClient storageClient = new StorageClient(trackerServer, 
                    storageServer); 
            NameValuePair nvp [] = new NameValuePair[]{ 
                    new NameValuePair("item_id", "100010"), 
                    new NameValuePair("width", "80"),
                    new NameValuePair("height", "90")
            }; 
            String fileIds[] = storageClient.upload_file(local_filename, null, 
                    nvp); 

            System.out.println(fileIds.length); 
            System.out.println("组名：" + fileIds[0]); 
            System.out.println("路径: " + fileIds[1]); 

        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (Exception e) {
			e.printStackTrace();
		} 
    	
    } 
  

}
