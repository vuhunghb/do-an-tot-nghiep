package irestads.beans.dishs_store;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import sun.font.Script;

public class FileUploadController {
	private String pathImg="E:/1.jpg";
	 private StreamedContent scImg;
	 private String imageID;

	// public void uploadImg(FileUploadEvent event) {
	// FacesMessage msg = new FacesMessage("Succesful",
	// event.getFile().getFileName() + " is uploaded.");
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// System.out.println("vo day"+ event.getFile().getFileName() );
	// }
	private String destination = "E:\\";

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public void uploadImg(FileUploadEvent event) {
		
		FacesMessage msg = new FacesMessage("Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Starting...");
//		
//		InputStream in = new ByteArrayInputStream(event.getFile().getContents());
//		this.scImg= new DefaultStreamedContent(in, "image/jpeg");

	}

	public void copyFile(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(destination + fileName);
			byte[] buff = new byte[1024];
			int read = 0;
			while ((read = in.read(buff)) != -1) {
				out.write(buff, 0, read);
			}
			in.close();
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public StreamedContent getScImg() {
//		if (scImg == null) {
//            try {
//            	BufferedImage thumb = ImageIO.read(new File (pathImg));
//            	ByteArrayOutputStream os = new ByteArrayOutputStream();
//            	ImageIO.write(thumb, "jpeg", os);
//            	InputStream is = new ByteArrayInputStream(os.toByteArray());
//            	System.out.println("byte "+os.toByteArray());
//            	scImg = new DefaultStreamedContent(is, "image/jpeg");
//            }
//            catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}}
		File f=new File(pathImg);
		
		
        
		return scImg;
	}

	public void setScImg(StreamedContent scImg) {
		this.scImg = scImg;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getImageID() {
		 System.out.println("ImageController set == "+ this.imageID);
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

}
