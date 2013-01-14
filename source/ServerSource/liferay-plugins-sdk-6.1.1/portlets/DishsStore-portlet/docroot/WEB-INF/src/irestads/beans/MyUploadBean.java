package irestads.beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "uploadBean")
@SessionScoped
public class MyUploadBean {
	ArrayList<StreamedContent> lists = new ArrayList<StreamedContent>();
	StreamedContent image;

	public void handleFileUpload(FileUploadEvent event) throws InterruptedException {
		System.out.println("Starting...");
		
		InputStream in = new ByteArrayInputStream(event.getFile().getContents());
		setImage(new DefaultStreamedContent(in, "image/jpeg"));

	}

	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
		lists.add(image);
	}
	
	public void save(){
		System.out.println("toi dc day ne");
	}
	

}
