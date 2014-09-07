package com.parakhi.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;



import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("files")
public class Upload {
String location;
	
	
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public  String uploadfile(@FormDataParam("file") InputStream is, @FormDataParam("file") FormDataContentDisposition filedetail){
		
		saveToDisk(is,filedetail);
		return  "File Uploaded Succesfully_"+location;
	}


	private void saveToDisk(InputStream is1,
			FormDataContentDisposition filedetail) {
		// TODO Auto-generated method stub
		
		 location = "E://upload/"+filedetail.getFileName();
		try{
			OutputStream out = new FileOutputStream(new File(location));
			int read = 0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream (new File(location));
			while((read = is1.read(bytes)) != -1){
				out.write(bytes,0,read);
			}
			out.flush();
			
			out.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	

}