package irestads.beans.maintain_menu;

import irestads.defination.Base64;

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
	private String base64Encoded;

	public void handleFileUpload(FileUploadEvent event) throws InterruptedException {
		System.out.println("Starting...");
		byte [] byteContent =event.getFile().getContents();
		this.base64Encoded=	Base64.encodeBytes(byteContent);

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

	public ArrayList<StreamedContent> getLists() {
		return lists;
	}

	public void setLists(ArrayList<StreamedContent> lists) {
		this.lists = lists;
	}

	public String getBase64Encoded() {
		return base64Encoded;
	}

	public void setBase64Encoded(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}
	

}
